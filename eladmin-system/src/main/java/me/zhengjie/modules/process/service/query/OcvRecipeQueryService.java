package me.zhengjie.modules.process.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.process.domain.OcvRecipe;
import me.zhengjie.modules.process.service.dto.OcvRecipeDTO;
import me.zhengjie.modules.process.repository.OcvRecipeRepository;
import me.zhengjie.modules.process.service.mapper.OcvRecipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "ocvRecipe")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OcvRecipeQueryService {

    @Autowired
    private OcvRecipeRepository ocvRecipeRepository;

    @Autowired
    private OcvRecipeMapper ocvRecipeMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(OcvRecipeDTO ocvRecipe, Pageable pageable) {
        Page<OcvRecipe> page = ocvRecipeRepository.findAll(new Spec(ocvRecipe), pageable);
        return PageUtil.toPage(page.map(ocvRecipeMapper::toDto));
    }

    /**
     * 查询所有名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<OcvRecipe> all = ocvRecipeRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(OcvRecipeDTO ocvRecipe) {
        return ocvRecipeMapper.toDto(ocvRecipeRepository.findAll(new Spec(ocvRecipe)));
    }

    class Spec implements Specification<OcvRecipe> {

        private OcvRecipeDTO ocvRecipe;

        public Spec(OcvRecipeDTO ocvRecipe) {
            this.ocvRecipe = ocvRecipe;
        }

        @Override
        public Predicate toPredicate(Root<OcvRecipe> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(ocvRecipe.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + ocvRecipe.getName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
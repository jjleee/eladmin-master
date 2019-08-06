package me.zhengjie.modules.process.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.process.domain.DcrRecipe;
import me.zhengjie.modules.process.service.dto.DcrRecipeDTO;
import me.zhengjie.modules.process.repository.DcrRecipeRepository;
import me.zhengjie.modules.process.service.mapper.DcrRecipeMapper;
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
@CacheConfig(cacheNames = "dcrRecipe")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DcrRecipeQueryService {

    @Autowired
    private DcrRecipeRepository dcrRecipeRepository;

    @Autowired
    private DcrRecipeMapper dcrRecipeMapper;

    /**
     * 查询所有名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<DcrRecipe> all = dcrRecipeRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(DcrRecipeDTO dcrRecipe, Pageable pageable) {
        Page<DcrRecipe> page = dcrRecipeRepository.findAll(new Spec(dcrRecipe), pageable);
        return PageUtil.toPage(page.map(dcrRecipeMapper::toDto));
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(DcrRecipeDTO dcrRecipe) {
        return dcrRecipeMapper.toDto(dcrRecipeRepository.findAll(new Spec(dcrRecipe)));
    }

    class Spec implements Specification<DcrRecipe> {

        private DcrRecipeDTO dcrRecipe;

        public Spec(DcrRecipeDTO dcrRecipe) {
            this.dcrRecipe = dcrRecipe;
        }

        @Override
        public Predicate toPredicate(Root<DcrRecipe> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(dcrRecipe.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + dcrRecipe.getName() + "%"));
            }
            if (!ObjectUtils.isEmpty(dcrRecipe.getMethodName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("method_name").as(String.class), "%" + dcrRecipe.getMethodName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
package me.zhengjie.modules.process.service.query;

import me.zhengjie.modules.process.domain.DivisionRecipe;
import me.zhengjie.modules.process.domain.WorkStepInfo;
import me.zhengjie.modules.process.repository.DivisionRecipeRepository;
import me.zhengjie.modules.process.repository.WorkStepInfoRepository;
import me.zhengjie.modules.process.service.dto.DivisionRecipeDTO;
import me.zhengjie.modules.process.service.mapper.DivisionRecipeMapper;
import me.zhengjie.utils.PageUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "divisionRecipe")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DivisionRecipeQueryService {

    @Autowired
    private DivisionRecipeRepository divisionRecipeRepository;

    @Autowired
    private DivisionRecipeMapper divisionRecipeMapper;

    @Autowired
    private WorkStepInfoRepository workStepInfoRepository;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(DivisionRecipeDTO divisionRecipe, Pageable pageable) {
        Page<DivisionRecipe> page = divisionRecipeRepository.findAll(new Spec(divisionRecipe), pageable);
        return PageUtil.toPage(page.map(divisionRecipeMapper::toDto));
    }

    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllPlus(DivisionRecipeDTO resource, Pageable pageable) {
        Page<DivisionRecipe> page = divisionRecipeRepository.findAll(new Spec(resource), pageable);
        List<DivisionRecipeDTO> dtos = new ArrayList<>();
        for (Iterator<DivisionRecipe> iterator = page.iterator(); iterator.hasNext(); ) {
            DivisionRecipe next = iterator.next();
            if (next.getValid()) {
                DivisionRecipeDTO divisionRecipeDTO = new DivisionRecipeDTO();
                BeanUtils.copyProperties(next, divisionRecipeDTO);
                List<WorkStepInfo> byRecipeId = workStepInfoRepository.findByRecipeId(next.getId());
                divisionRecipeDTO.setWorkStepInfos(byRecipeId);
                dtos.add(divisionRecipeDTO);
            }
        }
        Page<DivisionRecipeDTO> dtoPage = new PageImpl(dtos, pageable, dtos.size());
        return PageUtil.toPage(dtoPage);
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(DivisionRecipeDTO divisionRecipe) {
        return divisionRecipeMapper.toDto(divisionRecipeRepository.findAll(new Spec(divisionRecipe)));
    }

    class Spec implements Specification<DivisionRecipe> {

        private DivisionRecipeDTO divisionRecipe;

        public Spec(DivisionRecipeDTO divisionRecipe) {
            this.divisionRecipe = divisionRecipe;
        }

        @Override
        public Predicate toPredicate(Root<DivisionRecipe> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(divisionRecipe.getRecipeName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("recipe_name").as(String.class), "%" + divisionRecipe.getRecipeName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }

    /**
     * 查询所有名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName(Integer type) {
        List<DivisionRecipe> all = divisionRecipeRepository.findByValidAndRecipeType(true,type);
        List<String> allName = all.stream().map(e -> e.getRecipeName()).collect(Collectors.toList());
        return allName;
    }
}
package me.zhengjie.modules.process.service.query;
import me.zhengjie.modules.process.domain.WorkStepInfo;
import me.zhengjie.modules.process.repository.WorkStepInfoRepository;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.process.domain.FormationRecipe;
import me.zhengjie.modules.process.service.dto.FormationRecipeDTO;
import me.zhengjie.modules.process.repository.FormationRecipeRepository;
import me.zhengjie.modules.process.service.mapper.FormationRecipeMapper;
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
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jie
 * @date 2019-08-03
 */
@Service
@CacheConfig(cacheNames = "formationRecipe")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class FormationRecipeQueryService {

    @Autowired
    private FormationRecipeRepository formationRecipeRepository;

    @Autowired
    private FormationRecipeMapper formationRecipeMapper;
    @Autowired
    private WorkStepInfoRepository workStepInfoRepository;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(FormationRecipeDTO formationRecipe, Pageable pageable) {
        Page<FormationRecipe> page = formationRecipeRepository.findAll(new Spec(formationRecipe), pageable);
        return PageUtil.toPage(page.map(formationRecipeMapper::toDto));
    }

    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllPlus(FormationRecipeDTO resource, Pageable pageable) {
        Page<FormationRecipe> page = formationRecipeRepository.findAll(new Spec(resource), pageable);
        List<FormationRecipeDTO> dtos = new ArrayList<>();
        for (Iterator<FormationRecipe> iterator = page.getContent().iterator(); iterator.hasNext(); ) {
            FormationRecipe next = iterator.next();
            FormationRecipeDTO formationRecipeDTO = new FormationRecipeDTO();
            BeanUtils.copyProperties(next, formationRecipeDTO);
            List<WorkStepInfo> byRecipeId = workStepInfoRepository.findByRecipeId(next.getId());
            formationRecipeDTO.setWorkStepInfos(byRecipeId);
            dtos.add(formationRecipeDTO);
        }

        Page<FormationRecipeDTO> dtoPage = new PageImpl(dtos, pageable, page.getTotalElements());
        return PageUtil.toPage(dtoPage);
    }

    /**
     * 查询所有名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName(Integer type) {
        List<FormationRecipe> all = formationRecipeRepository.findAllByValidAndRecipeType(true, type);
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }

    @Cacheable(keyGenerator = "keyGenerator")
    public List<String> queryFormationStepName(String recipeName) {
        FormationRecipe formationRecipe = formationRecipeRepository.findByNameAndValid(recipeName, true);
        List<WorkStepInfo> steps = workStepInfoRepository.findByRecipeId(formationRecipe.getId());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < steps.size(); i++) {
            if (steps.get(i).getStroke().equals("cycle-start")) {
                int m = 0;
                int n = 0;
                for (int k = i + 1; k < steps.size(); k++) {
                    if ("cycle-end".equals(steps.get(k).getStroke()) && steps.get(k).getCycleNumber().intValue() == steps.get(i).getCycleNumber().intValue()) {
                        m = k - i;
                        n = steps.get(k).getCycleNumber();
                    }
                }
                for (int j = 0; j < steps.get(i).getCycleCount(); j++) {
                    for (int z = 0; z < m; z++) {
                        result.add("F-L" + n + "-" + (j + 1) + "-" + steps.get(i + z + 1).getStroke());
                    }
                }
            } else if (steps.get(i).getStroke().equals("CC") || steps.get(i).getStroke().equals("DC") || steps.get(i).getStroke().equals("DC-DV") || "CC-CV".equals(steps.get(i).getStroke())) {
                result.add("F-" + steps.get(i).getStroke());
            }

        }
        return result;
    }

    class Spec implements Specification<FormationRecipe> {

        private FormationRecipeDTO formationRecipe;

        public Spec(FormationRecipeDTO formationRecipe) {
            this.formationRecipe = formationRecipe;
        }

        @Override
        public Predicate toPredicate(Root<FormationRecipe> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();
            list.add(cb.isTrue(root.get("valid").as(Boolean.class)));
            if (!ObjectUtils.isEmpty(formationRecipe.getRecipeType())) {
                /**
                 * 模糊
                 */
                list.add(cb.equal(root.get("recipeType").as(Integer.class), formationRecipe.getRecipeType()));
            }
            if (!ObjectUtils.isEmpty(formationRecipe.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + formationRecipe.getName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(FormationRecipeDTO formationRecipe) {
        return formationRecipeMapper.toDto(formationRecipeRepository.findAll(new Spec(formationRecipe)));
    }
}



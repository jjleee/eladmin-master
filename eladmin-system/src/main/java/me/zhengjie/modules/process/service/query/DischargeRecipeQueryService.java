package me.zhengjie.modules.process.service.query;

import me.zhengjie.modules.process.domain.DischargeRecipe;
import me.zhengjie.modules.process.domain.WorkStepInfo;
import me.zhengjie.modules.process.repository.DischargeRecipeRepository;
import me.zhengjie.modules.process.repository.WorkStepInfoRepository;
import me.zhengjie.modules.process.service.dto.DischargeRecipeDTO;
import me.zhengjie.modules.process.service.dto.DivisionRecipeDTO;
import me.zhengjie.modules.process.service.mapper.DischargeRecipeMapper;
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
@CacheConfig(cacheNames = "dischargeRecipe")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DischargeRecipeQueryService {

    @Autowired
    private DischargeRecipeRepository dischargeRecipeRepository;

    @Autowired
    private DischargeRecipeMapper dischargeRecipeMapper;

    @Autowired
    private WorkStepInfoRepository workStepInfoRepository;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(DischargeRecipeDTO dischargeRecipe, Pageable pageable) {
        Page<DischargeRecipe> page = dischargeRecipeRepository.findAll(new Spec(dischargeRecipe), pageable);
        return PageUtil.toPage(page.map(dischargeRecipeMapper::toDto));
    }

    /**
     * 根据配方名查找工步
     * @param recipeName
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public List<String> queryChargeStepName(String recipeName) {
        DischargeRecipe dischargeRecipe = dischargeRecipeRepository.findByRecipeNameAndValid(recipeName, true);
        List<WorkStepInfo> steps = workStepInfoRepository.findByRecipeId(dischargeRecipe.getId());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < steps.size(); i++) {
            if (steps.get(i).getStroke().equals("cycle-start")) {
                int m = 0;
                int n=0;
                for (int k = i + 1; k < steps.size(); k++) {
                    if ("cycle-end".equals(steps.get(k).getStroke()) && steps.get(k).getCycleNumber().intValue() == steps.get(i).getCycleNumber().intValue()) {
                        m = k - i;
                        n=steps.get(k).getCycleNumber();
                    }
                }
                for (int j = 0; j < steps.get(i).getCycleCount(); j++) {
                    for (int z = 0; z < m; z++) {
                        result.add("T-L" +n+"-"+ (j + 1) + "-" + steps.get(i + z + 1).getStroke());
                    }
                }
            } else if (steps.get(i).getStroke().equals("CC") || steps.get(i).getStroke().equals("DC") || steps.get(i).getStroke().equals("DC-DV") || "CC-CV".equals(steps.get(i).getStroke())) {
                result.add("T-"+steps.get(i).getStroke());
            }

        }
        return result;
    }

    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllPlus(DischargeRecipeDTO resource, Pageable pageable) {
        Page<DischargeRecipe> page = dischargeRecipeRepository.findAll(new Spec(resource), pageable);
        List<DischargeRecipeDTO> dtos = new ArrayList<>();
        for (Iterator<DischargeRecipe> iterator = page.iterator(); iterator.hasNext(); ) {
            DischargeRecipe next = iterator.next();
            if (next.getValid()) {
                DischargeRecipeDTO divisionRecipeDTO = new DischargeRecipeDTO();
                BeanUtils.copyProperties(next, divisionRecipeDTO);
                List<WorkStepInfo> byRecipeId = workStepInfoRepository.findByRecipeId(next.getId());
                divisionRecipeDTO.setWorkStepInfos(byRecipeId);
                dtos.add(divisionRecipeDTO);
            }
        }
        Page<DischargeRecipeDTO> dtoPage = new PageImpl(dtos, pageable, dtos.size());
        return PageUtil.toPage(dtoPage);
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(DischargeRecipeDTO dischargeRecipe) {
        return dischargeRecipeMapper.toDto(dischargeRecipeRepository.findAll(new Spec(dischargeRecipe)));
    }

    class Spec implements Specification<DischargeRecipe> {

        private DischargeRecipeDTO dischargeRecipe;

        public Spec(DischargeRecipeDTO dischargeRecipe) {
            this.dischargeRecipe = dischargeRecipe;
        }

        @Override
        public Predicate toPredicate(Root<DischargeRecipe> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

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
        List<DischargeRecipe> all = dischargeRecipeRepository.findByValidAndRecipeType(true,type);
        List<String> allName = all.stream().map(e -> e.getRecipeName()).collect(Collectors.toList());
        return allName;
    }
}
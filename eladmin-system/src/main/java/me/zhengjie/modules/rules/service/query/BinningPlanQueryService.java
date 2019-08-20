package me.zhengjie.modules.rules.service.query;

import cn.hutool.core.util.ArrayUtil;
import me.zhengjie.modules.basicInfo.service.query.BatteryInfoQueryService;
import me.zhengjie.modules.process.service.query.DischargeRecipeQueryService;
import me.zhengjie.modules.process.service.query.DivisionRecipeQueryService;
import me.zhengjie.modules.process.service.query.FormationRecipeQueryService;
import me.zhengjie.modules.rules.domain.BinningPlan;
import me.zhengjie.modules.rules.repository.BinningPlanRepository;
import me.zhengjie.modules.rules.service.dto.BinningPlanDTO;
import me.zhengjie.modules.rules.service.mapper.BinningPlanMapper;
import me.zhengjie.utils.PageUtil;
import org.apache.commons.lang.ArrayUtils;
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
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "binningPlan")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BinningPlanQueryService {

    @Autowired
    private BinningPlanRepository binningPlanRepository;

    @Autowired
    private BinningPlanMapper binningPlanMapper;
    @Autowired
    private BatteryInfoQueryService batteryInfoQueryService;
    @Autowired
    private FormationRecipeQueryService formationRecipeQueryService;
    @Autowired
    private DivisionRecipeQueryService divisionRecipeQueryService;
    @Autowired
    private DischargeRecipeQueryService dischargeRecipeQueryService;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(BinningPlanDTO binningPlan, Pageable pageable) {
        Page<BinningPlan> page = binningPlanRepository.findAll(new Spec(binningPlan), pageable);
        return PageUtil.toPage(page.map(binningPlanMapper::toDto));
    }

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public List<String> queryAllStepName(String number) {
        Map<String, String> map = batteryInfoQueryService.queryRecipeName(number);
        List<String> stepNames = new ArrayList<>();
        List<String> formationStepNames = new ArrayList<>();
        List<String> divisionStepNames = new ArrayList<>();
        List<String> chargeStepNames = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals("formation")) {
                formationStepNames = formationRecipeQueryService.queryFormationStepName(entry.getValue());
            }
            if (entry.getKey().equals("division")) {
                divisionStepNames = divisionRecipeQueryService.queryDivisionStepName(entry.getValue());
            }
            if (entry.getKey().equals("discharge")) {
                chargeStepNames = dischargeRecipeQueryService.queryChargeStepName(entry.getValue());
            }
        }
        stepNames.addAll(formationStepNames);
        stepNames.addAll(divisionStepNames);
        stepNames.addAll(chargeStepNames);

        return stepNames;
    }

    /**
     * 查询所有名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<BinningPlan> all = binningPlanRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getPlanName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(BinningPlanDTO binningPlan) {
        return binningPlanMapper.toDto(binningPlanRepository.findAll(new Spec(binningPlan)));
    }

    class Spec implements Specification<BinningPlan> {

        private BinningPlanDTO binningPlan;

        public Spec(BinningPlanDTO binningPlan) {
            this.binningPlan = binningPlan;
        }

        @Override
        public Predicate toPredicate(Root<BinningPlan> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(binningPlan.getPlanName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + binningPlan.getPlanName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
package me.zhengjie.modules.process.service.query;

import me.zhengjie.modules.process.domain.VacuumPlan;
import me.zhengjie.modules.process.repository.VacuumPlanRepository;
import me.zhengjie.modules.process.service.dto.VacuumPlanDTO;
import me.zhengjie.modules.process.service.mapper.VacuumPlanMapper;
import me.zhengjie.utils.PageUtil;
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
@CacheConfig(cacheNames = "vacuumPlan")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class VacuumPlanQueryService {

    @Autowired
    private VacuumPlanRepository vacuumPlanRepository;

    @Autowired
    private VacuumPlanMapper vacuumPlanMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(VacuumPlanDTO vacuumPlan, Pageable pageable) {
        Page<VacuumPlan> page = vacuumPlanRepository.findAll(new Spec(vacuumPlan), pageable);
        return PageUtil.toPage(page.map(vacuumPlanMapper::toDto));
    }

    /**
     * 查找所有方案名称
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<VacuumPlan> all = vacuumPlanRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(VacuumPlanDTO vacuumPlan) {
        return vacuumPlanMapper.toDto(vacuumPlanRepository.findAll(new Spec(vacuumPlan)));
    }

    class Spec implements Specification<VacuumPlan> {

        private VacuumPlanDTO vacuumPlan;

        public Spec(VacuumPlanDTO vacuumPlan) {
            this.vacuumPlan = vacuumPlan;
        }

        @Override
        public Predicate toPredicate(Root<VacuumPlan> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(vacuumPlan.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + vacuumPlan.getName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
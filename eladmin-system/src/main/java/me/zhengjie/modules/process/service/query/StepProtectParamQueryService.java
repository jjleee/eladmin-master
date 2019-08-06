package me.zhengjie.modules.process.service.query;

import me.zhengjie.modules.process.domain.StepProtectParam;
import me.zhengjie.modules.process.repository.StepProtectParamRepository;
import me.zhengjie.modules.process.service.dto.StepProtectParamDTO;
import me.zhengjie.modules.process.service.mapper.StepProtectParamMapper;
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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "stepProtectParam")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class StepProtectParamQueryService {

    @Autowired
    private StepProtectParamRepository stepProtectParamRepository;

    @Autowired
    private StepProtectParamMapper stepProtectParamMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(StepProtectParamDTO stepProtectParam, Pageable pageable) {
        Page<StepProtectParam> page = stepProtectParamRepository.findAll(new Spec(stepProtectParam), pageable);
        return PageUtil.toPage(page.map(stepProtectParamMapper::toDto));
    }

    /**
     * 根据工步名称查找所有模板名称
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryBystroke(String stroke) {
        List<StepProtectParam> byStepName = stepProtectParamRepository.findAllByStepName(stroke);
        List<String> allName = byStepName.stream().map(e -> e.getProtectName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 根据模板名称查找模板
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryByName(String protectName) {
        StepProtectParam stepProtectParam = stepProtectParamRepository.findByProtectName(protectName);
        return stepProtectParam;
    }



    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(StepProtectParamDTO stepProtectParam) {
        return stepProtectParamMapper.toDto(stepProtectParamRepository.findAll(new Spec(stepProtectParam)));
    }

    class Spec implements Specification<StepProtectParam> {

        private StepProtectParamDTO stepProtectParam;

        public Spec(StepProtectParamDTO stepProtectParam) {
            this.stepProtectParam = stepProtectParam;
        }

        @Override
        public Predicate toPredicate(Root<StepProtectParam> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
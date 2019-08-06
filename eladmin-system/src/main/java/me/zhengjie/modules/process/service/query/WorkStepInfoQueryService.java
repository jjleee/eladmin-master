package me.zhengjie.modules.process.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.process.domain.WorkStepInfo;
import me.zhengjie.modules.process.service.dto.WorkStepInfoDTO;
import me.zhengjie.modules.process.repository.WorkStepInfoRepository;
import me.zhengjie.modules.process.service.mapper.WorkStepInfoMapper;
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

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "workStepInfo")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class WorkStepInfoQueryService {

    @Autowired
    private WorkStepInfoRepository workStepInfoRepository;

    @Autowired
    private WorkStepInfoMapper workStepInfoMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(WorkStepInfoDTO workStepInfo, Pageable pageable) {
        Page<WorkStepInfo> page = workStepInfoRepository.findAll(new Spec(workStepInfo), pageable);
        return PageUtil.toPage(page.map(workStepInfoMapper::toDto));
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(WorkStepInfoDTO workStepInfo) {
        return workStepInfoMapper.toDto(workStepInfoRepository.findAll(new Spec(workStepInfo)));
    }

    class Spec implements Specification<WorkStepInfo> {

        private WorkStepInfoDTO workStepInfo;

        public Spec(WorkStepInfoDTO workStepInfo) {
            this.workStepInfo = workStepInfo;
        }

        @Override
        public Predicate toPredicate(Root<WorkStepInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
package me.zhengjie.modules.data.service.query;

import me.zhengjie.modules.data.domain.ProcessData;
import me.zhengjie.modules.data.repository.ProcessDataRepository;
import me.zhengjie.modules.data.service.dto.ProcessDataDTO;
import me.zhengjie.modules.data.service.mapper.ProcessDataMapper;
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

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "processData")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProcessDataQueryService {

    @Autowired
    private ProcessDataRepository processDataRepository;

    @Autowired
    private ProcessDataMapper processDataMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ProcessDataDTO processData, Pageable pageable) {
        Page<ProcessData> page = processDataRepository.findAll(new Spec(processData), pageable);
        return PageUtil.toPage(page.map(processDataMapper::toDto));
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ProcessDataDTO processData) {
        return processDataMapper.toDto(processDataRepository.findAll(new Spec(processData)));
    }

    class Spec implements Specification<ProcessData> {

        private ProcessDataDTO processData;

        public Spec(ProcessDataDTO processData) {
            this.processData = processData;
        }

        @Override
        public Predicate toPredicate(Root<ProcessData> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(processData.getBatteryNo())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("batteryNo").as(String.class), "%" + processData.getBatteryNo() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
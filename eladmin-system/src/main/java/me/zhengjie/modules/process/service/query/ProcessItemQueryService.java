package me.zhengjie.modules.process.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.process.domain.ProcessItem;
import me.zhengjie.modules.process.service.dto.ProcessItemDTO;
import me.zhengjie.modules.process.repository.ProcessItemRepository;
import me.zhengjie.modules.process.service.mapper.ProcessItemMapper;
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
@CacheConfig(cacheNames = "processItem")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProcessItemQueryService {

    @Autowired
    private ProcessItemRepository processItemRepository;

    @Autowired
    private ProcessItemMapper processItemMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ProcessItemDTO processItem, Pageable pageable) {
        Page<ProcessItem> page = processItemRepository.findAll(new Spec(processItem), pageable);
        return PageUtil.toPage(page.map(processItemMapper::toDto));
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ProcessItemDTO processItem) {
        return processItemMapper.toDto(processItemRepository.findAll(new Spec(processItem)));
    }

    class Spec implements Specification<ProcessItem> {

        private ProcessItemDTO processItem;

        public Spec(ProcessItemDTO processItem) {
            this.processItem = processItem;
        }

        @Override
        public Predicate toPredicate(Root<ProcessItem> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
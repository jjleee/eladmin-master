package me.zhengjie.modules.process.service.query;

import me.zhengjie.modules.process.domain.LeakVacuum;
import me.zhengjie.modules.process.repository.LeakVacuumRepository;
import me.zhengjie.modules.process.service.dto.LeakVacuumDTO;
import me.zhengjie.modules.process.service.mapper.LeakVacuumMapper;
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
@CacheConfig(cacheNames = "leakVacuum")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LeakVacuumQueryService {

    @Autowired
    private LeakVacuumRepository leakVacuumRepository;

    @Autowired
    private LeakVacuumMapper leakVacuumMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(LeakVacuumDTO leakVacuum, Pageable pageable) {
        Page<LeakVacuum> page = leakVacuumRepository.findAll(new Spec(leakVacuum), pageable);
        return PageUtil.toPage(page.map(leakVacuumMapper::toDto));
    }

    /**
     * 查找所有方案名称
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<LeakVacuum> all = leakVacuumRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(LeakVacuumDTO leakVacuum) {
        return leakVacuumMapper.toDto(leakVacuumRepository.findAll(new Spec(leakVacuum)));
    }

    class Spec implements Specification<LeakVacuum> {

        private LeakVacuumDTO leakVacuum;

        public Spec(LeakVacuumDTO leakVacuum) {
            this.leakVacuum = leakVacuum;
        }

        @Override
        public Predicate toPredicate(Root<LeakVacuum> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(leakVacuum.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + leakVacuum.getName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
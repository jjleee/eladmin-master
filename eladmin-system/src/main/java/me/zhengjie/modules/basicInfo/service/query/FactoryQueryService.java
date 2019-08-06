package me.zhengjie.modules.basicInfo.service.query;

import me.zhengjie.modules.basicInfo.domain.BatteryInfo;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.basicInfo.domain.Factory;
import me.zhengjie.modules.basicInfo.service.dto.FactoryDTO;
import me.zhengjie.modules.basicInfo.repository.FactoryRepository;
import me.zhengjie.modules.basicInfo.service.mapper.FactoryMapper;
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
@CacheConfig(cacheNames = "factory")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class FactoryQueryService {

    @Autowired
    private FactoryRepository factoryRepository;

    @Autowired
    private FactoryMapper factoryMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(FactoryDTO factory, Pageable pageable) {
        Page<Factory> page = factoryRepository.findAll(new Spec(factory), pageable);
        return PageUtil.toPage(page.map(factoryMapper::toDto));
    }

    /**
     * 查询所有名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<Factory> all = factoryRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(FactoryDTO factory) {
        return factoryMapper.toDto(factoryRepository.findAll(new Spec(factory)));
    }

    class Spec implements Specification<Factory> {

        private FactoryDTO factory;

        public Spec(FactoryDTO factory) {
            this.factory = factory;
        }

        @Override
        public Predicate toPredicate(Root<Factory> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(factory.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + factory.getName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
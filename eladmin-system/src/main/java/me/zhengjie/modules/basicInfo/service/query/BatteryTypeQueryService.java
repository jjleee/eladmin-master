package me.zhengjie.modules.basicInfo.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.basicInfo.domain.BatteryType;
import me.zhengjie.modules.basicInfo.service.dto.BatteryTypeDTO;
import me.zhengjie.modules.basicInfo.repository.BatteryTypeRepository;
import me.zhengjie.modules.basicInfo.service.mapper.BatteryTypeMapper;
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
@CacheConfig(cacheNames = "batteryType")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BatteryTypeQueryService {

    @Autowired
    private BatteryTypeRepository batteryTypeRepository;

    @Autowired
    private BatteryTypeMapper batteryTypeMapper;

    /**
     * 查询所有名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<BatteryType> all = batteryTypeRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(BatteryTypeDTO batteryType, Pageable pageable) {
        Page<BatteryType> page = batteryTypeRepository.findAll(new Spec(batteryType), pageable);
        return PageUtil.toPage(page.map(batteryTypeMapper::toDto));
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(BatteryTypeDTO batteryType) {
        return batteryTypeMapper.toDto(batteryTypeRepository.findAll(new Spec(batteryType)));
    }

    class Spec implements Specification<BatteryType> {

        private BatteryTypeDTO batteryType;

        public Spec(BatteryTypeDTO batteryType) {
            this.batteryType = batteryType;
        }

        @Override
        public Predicate toPredicate(Root<BatteryType> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(batteryType.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + batteryType.getName() + "%"));
            }
            if (!ObjectUtils.isEmpty(batteryType.getAvailable())) {
                /**
                 * 精确
                 */
                list.add(cb.equal(root.get("available").as(Integer.class), batteryType.getAvailable()));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
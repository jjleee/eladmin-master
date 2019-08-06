package me.zhengjie.modules.basicInfo.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.basicInfo.domain.ExperimentBattery;
import me.zhengjie.modules.basicInfo.service.dto.ExperimentBatteryDTO;
import me.zhengjie.modules.basicInfo.repository.ExperimentBatteryRepository;
import me.zhengjie.modules.basicInfo.service.mapper.ExperimentBatteryMapper;
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
@CacheConfig(cacheNames = "experimentBattery")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ExperimentBatteryQueryService {

    @Autowired
    private ExperimentBatteryRepository experimentBatteryRepository;

    @Autowired
    private ExperimentBatteryMapper experimentBatteryMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ExperimentBatteryDTO experimentBattery, Pageable pageable){
        Page<ExperimentBattery> page = experimentBatteryRepository.findAll(new Spec(experimentBattery),pageable);
        return PageUtil.toPage(page.map(experimentBatteryMapper::toDto));
    }

    /**
    * 不分页
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ExperimentBatteryDTO experimentBattery){
        return experimentBatteryMapper.toDto(experimentBatteryRepository.findAll(new Spec(experimentBattery)));
    }

    class Spec implements Specification<ExperimentBattery> {

        private ExperimentBatteryDTO experimentBattery;

        public Spec(ExperimentBatteryDTO experimentBattery){
            this.experimentBattery = experimentBattery;
        }

        @Override
        public Predicate toPredicate(Root<ExperimentBattery> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

                if(!ObjectUtils.isEmpty(experimentBattery.getBatteryNumber())){
                    /**
                    * 模糊
                    */
                    list.add(cb.like(root.get("battery_number").as(String.class),"%"+experimentBattery.getBatteryNumber()+"%"));
                }
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
        }
    }
}
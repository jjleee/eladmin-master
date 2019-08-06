package me.zhengjie.modules.warning.service.query;

import me.zhengjie.modules.warning.domain.PowerWarning;
import me.zhengjie.modules.warning.repository.PowerWarningRepository;
import me.zhengjie.modules.warning.service.dto.PowerWarningDTO;
import me.zhengjie.modules.warning.service.mapper.PowerWarningMapper;
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
@CacheConfig(cacheNames = "powerWarning")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PowerWarningQueryService {

    @Autowired
    private PowerWarningRepository powerWarningRepository;

    @Autowired
    private PowerWarningMapper powerWarningMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(PowerWarningDTO powerWarning, Pageable pageable){
        Page<PowerWarning> page = powerWarningRepository.findAll(new Spec(powerWarning),pageable);
        return PageUtil.toPage(page.map(powerWarningMapper::toDto));
    }

    /**
    * 不分页
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(PowerWarningDTO powerWarning){
        return powerWarningMapper.toDto(powerWarningRepository.findAll(new Spec(powerWarning)));
    }

    class Spec implements Specification<PowerWarning> {

        private PowerWarningDTO powerWarning;

        public Spec(PowerWarningDTO powerWarning){
            this.powerWarning = powerWarning;
        }

        @Override
        public Predicate toPredicate(Root<PowerWarning> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

                if(!ObjectUtils.isEmpty(powerWarning.getLine())){
                    /**
                    * 模糊
                    */
                    list.add(cb.like(root.get("line").as(String.class),"%"+powerWarning.getLine()+"%"));
                }
                if(!ObjectUtils.isEmpty(powerWarning.getCabinet())){
                    /**
                    * 精确
                    */
                    list.add(cb.equal(root.get("cabinet").as(Integer.class),powerWarning.getCabinet()));
                }
                if(!ObjectUtils.isEmpty(powerWarning.getCell())){
                    /**
                    * 精确
                    */
                    list.add(cb.equal(root.get("cell").as(Integer.class),powerWarning.getCell()));
                }
                if(!ObjectUtils.isEmpty(powerWarning.getChannel())){
                    /**
                    * 精确
                    */
                    list.add(cb.equal(root.get("channel").as(Integer.class),powerWarning.getChannel()));
                }
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
        }
    }
}
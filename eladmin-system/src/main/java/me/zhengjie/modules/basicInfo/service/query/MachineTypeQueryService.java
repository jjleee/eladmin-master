package me.zhengjie.modules.basicInfo.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.basicInfo.domain.MachineType;
import me.zhengjie.modules.basicInfo.service.dto.MachineTypeDTO;
import me.zhengjie.modules.basicInfo.repository.MachineTypeRepository;
import me.zhengjie.modules.basicInfo.service.mapper.MachineTypeMapper;
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
@CacheConfig(cacheNames = "machineType")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MachineTypeQueryService {

    @Autowired
    private MachineTypeRepository machineTypeRepository;

    @Autowired
    private MachineTypeMapper machineTypeMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(MachineTypeDTO machineType, Pageable pageable) {
        Page<MachineType> page = machineTypeRepository.findAll(new Spec(machineType), pageable);
        return PageUtil.toPage(page.map(machineTypeMapper::toDto));
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(MachineTypeDTO machineType) {
        return machineTypeMapper.toDto(machineTypeRepository.findAll(new Spec(machineType)));
    }

    class Spec implements Specification<MachineType> {

        private MachineTypeDTO machineType;

        public Spec(MachineTypeDTO machineType) {
            this.machineType = machineType;
        }

        @Override
        public Predicate toPredicate(Root<MachineType> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(machineType.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + machineType.getName() + "%"));
            }
            if (!ObjectUtils.isEmpty(machineType.getCreatorName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("creator_name").as(String.class), "%" + machineType.getCreatorName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
package me.zhengjie.modules.basicInfo.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.basicInfo.domain.MachineInfo;
import me.zhengjie.modules.basicInfo.service.dto.MachineInfoDTO;
import me.zhengjie.modules.basicInfo.repository.MachineInfoRepository;
import me.zhengjie.modules.basicInfo.service.mapper.MachineInfoMapper;
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
@CacheConfig(cacheNames = "machineInfo")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MachineInfoQueryService {

    @Autowired
    private MachineInfoRepository machineInfoRepository;

    @Autowired
    private MachineInfoMapper machineInfoMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(MachineInfoDTO machineInfo, Pageable pageable) {
        Page<MachineInfo> page = machineInfoRepository.findAll(new Spec(machineInfo), pageable);
        return PageUtil.toPage(page.map(machineInfoMapper::toDto));
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(MachineInfoDTO machineInfo) {
        return machineInfoMapper.toDto(machineInfoRepository.findAll(new Spec(machineInfo)));
    }

    class Spec implements Specification<MachineInfo> {

        private MachineInfoDTO machineInfo;

        public Spec(MachineInfoDTO machineInfo) {
            this.machineInfo = machineInfo;
        }

        @Override
        public Predicate toPredicate(Root<MachineInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
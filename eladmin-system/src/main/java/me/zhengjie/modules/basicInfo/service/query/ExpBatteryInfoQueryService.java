package me.zhengjie.modules.basicInfo.service.query;

import me.zhengjie.modules.basicInfo.domain.ExpBatteryInfo;
import me.zhengjie.modules.basicInfo.domain.vo.ExpBatteryInfoVO;
import me.zhengjie.modules.basicInfo.repository.ExpBatteryInfoRepository;
import me.zhengjie.modules.basicInfo.service.dto.ExpBatteryInfoDTO;
import me.zhengjie.modules.basicInfo.service.mapper.ExpBatteryInfoMapper;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "expBatteryInfo")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ExpBatteryInfoQueryService {

    @Autowired
    private ExpBatteryInfoRepository expBatteryInfoRepository;

    @Autowired
    private ExpBatteryInfoMapper expBatteryInfoMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ExpBatteryInfoDTO expBatteryInfoDTO, Pageable pageable) {
        Page<ExpBatteryInfo> page = expBatteryInfoRepository.findAll(new Spec(expBatteryInfoDTO), pageable);
        return PageUtil.toPage(page.map(this::convertToVo));
    }

    public ExpBatteryInfoVO convertToVo(ExpBatteryInfo entity) {
        if (entity == null) {
            return null;
        }
        ExpBatteryInfoVO batteryInfoVO = new ExpBatteryInfoVO();
        batteryInfoVO.setId(entity.getId());
        batteryInfoVO.setNumber(entity.getNumber());
        batteryInfoVO.setTypeName(entity.getTypeName());
        batteryInfoVO.setFormationRecipeName(entity.getFormationRecipeName());
        batteryInfoVO.setDivisionRecipeName(entity.getDivisionRecipeName());
        batteryInfoVO.setDcrRecipeName(entity.getDcrRecipeName());
        batteryInfoVO.setChargeRecipeName(entity.getChargeRecipeName());
        batteryInfoVO.setProtectParamName(entity.getProtectParamName());
        batteryInfoVO.setNgRuleName(entity.getNgRuleName());
        batteryInfoVO.setCreatorName(entity.getCreatorName());
        batteryInfoVO.setCreateTime(entity.getCreateTime());
        batteryInfoVO.setAvailable(entity.getAvailable());
        if (entity.getLineName() != null) {
            List<String> lines = Arrays.asList(entity.getLineName().split("\\|"));
            batteryInfoVO.setLineNames(lines);
        }
        return batteryInfoVO;
    }

    /**
     * 查询所有电池名
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<ExpBatteryInfo> all = expBatteryInfoRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getNumber()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ExpBatteryInfoDTO batteryInfo) {
        return expBatteryInfoMapper.toDto(expBatteryInfoRepository.findAll(new Spec(batteryInfo)));
    }

    class Spec implements Specification<ExpBatteryInfo> {

        private ExpBatteryInfoDTO batteryInfo;

        public Spec(ExpBatteryInfoDTO batteryInfo) {
            this.batteryInfo = batteryInfo;
        }

        @Override
        public Predicate toPredicate(Root<ExpBatteryInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(batteryInfo.getNumber())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("number").as(String.class), "%" + batteryInfo.getNumber() + "%"));
            }
            if (!ObjectUtils.isEmpty(batteryInfo.getTypeName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("type_name").as(String.class), "%" + batteryInfo.getTypeName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
package me.zhengjie.modules.basicInfo.service.query;

import me.zhengjie.modules.basicInfo.domain.vo.BatteryInfoVO;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.basicInfo.domain.BatteryInfo;
import me.zhengjie.modules.basicInfo.service.dto.BatteryInfoDTO;
import me.zhengjie.modules.basicInfo.repository.BatteryInfoRepository;
import me.zhengjie.modules.basicInfo.service.mapper.BatteryInfoMapper;
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
@CacheConfig(cacheNames = "batteryInfo")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BatteryInfoQueryService {

    @Autowired
    private BatteryInfoRepository batteryInfoRepository;

    @Autowired
    private BatteryInfoMapper batteryInfoMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(BatteryInfoDTO batteryInfo, Pageable pageable) {
        Page<BatteryInfo> page = batteryInfoRepository.findAll(new Spec(batteryInfo), pageable);
        return PageUtil.toPage(page.map(this::convertToVo));
    }

    public BatteryInfoVO convertToVo(BatteryInfo entity) {
        if (entity == null) {
            return null;
        }
        BatteryInfoVO batteryInfoVO = new BatteryInfoVO();
        batteryInfoVO.setId(entity.getId());
        batteryInfoVO.setNumber(entity.getNumber());
        batteryInfoVO.setTypeName(entity.getTypeName());
        batteryInfoVO.setFormationRecipeName(entity.getFormationRecipeName());
        batteryInfoVO.setDivisionRecipeName(entity.getDivisionRecipeName());
        batteryInfoVO.setOcvRecipeName(entity.getOcvRecipeName());
        batteryInfoVO.setDcrRecipeName(entity.getDcrRecipeName());
        batteryInfoVO.setChargeRecipeName(entity.getChargeRecipeName());
        batteryInfoVO.setProtectParamName(entity.getProtectParamName());
        batteryInfoVO.setBinningRuleName(entity.getBinningRuleName());
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
        List<BatteryInfo> all = batteryInfoRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getNumber()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(BatteryInfoDTO batteryInfo) {
        return batteryInfoMapper.toDto(batteryInfoRepository.findAll(new Spec(batteryInfo)));
    }

    class Spec implements Specification<BatteryInfo> {

        private BatteryInfoDTO batteryInfo;

        public Spec(BatteryInfoDTO batteryInfo) {
            this.batteryInfo = batteryInfo;
        }

        @Override
        public Predicate toPredicate(Root<BatteryInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

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
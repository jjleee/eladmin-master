package me.zhengjie.modules.basicInfo.service.impl;

import me.zhengjie.modules.basicInfo.domain.BatteryType;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.basicInfo.repository.BatteryTypeRepository;
import me.zhengjie.modules.basicInfo.service.BatteryTypeService;
import me.zhengjie.modules.basicInfo.service.dto.BatteryTypeDTO;
import me.zhengjie.modules.basicInfo.service.mapper.BatteryTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-03-29
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BatteryTypeServiceImpl implements BatteryTypeService {

    @Autowired
    private BatteryTypeRepository batteryTypeRepository;

    @Autowired
    private BatteryTypeMapper batteryTypeMapper;

    @Override
    public BatteryTypeDTO findById(Long id) {
        Optional<BatteryType> batteryType = batteryTypeRepository.findById(id);
        ValidationUtil.isNull(batteryType, "BatteryType", "id", id);
        return batteryTypeMapper.toDto(batteryType.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BatteryTypeDTO create(BatteryType resources) {
        return batteryTypeMapper.toDto(batteryTypeRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(BatteryType resources) {
        Optional<BatteryType> optionalBatteryType = batteryTypeRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalBatteryType, "BatteryType", "id", resources.getId());

        BatteryType batteryType = optionalBatteryType.get();
        // 此处需自己修改
        resources.setId(batteryType.getId());
        batteryTypeRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        batteryTypeRepository.deleteById(id);
    }
}
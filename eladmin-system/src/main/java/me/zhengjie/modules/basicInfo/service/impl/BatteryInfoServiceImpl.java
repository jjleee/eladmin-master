package me.zhengjie.modules.basicInfo.service.impl;

import me.zhengjie.modules.basicInfo.domain.BatteryInfo;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.basicInfo.repository.BatteryInfoRepository;
import me.zhengjie.modules.basicInfo.service.BatteryInfoService;
import me.zhengjie.modules.basicInfo.service.dto.BatteryInfoDTO;
import me.zhengjie.modules.basicInfo.service.mapper.BatteryInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-04-01
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BatteryInfoServiceImpl implements BatteryInfoService {

    @Autowired
    private BatteryInfoRepository batteryInfoRepository;

    @Autowired
    private BatteryInfoMapper batteryInfoMapper;

    @Override
    public BatteryInfoDTO findById(Long id) {
        Optional<BatteryInfo> batteryInfo = batteryInfoRepository.findById(id);
        ValidationUtil.isNull(batteryInfo, "BatteryInfo", "id", id);
        return batteryInfoMapper.toDto(batteryInfo.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BatteryInfoDTO create(BatteryInfo resources) {
        return batteryInfoMapper.toDto(batteryInfoRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(BatteryInfoDTO resources) {
        Optional<BatteryInfo> optionalBatteryInfo = batteryInfoRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalBatteryInfo, "BatteryInfo", "id", resources.getId());

        // 此处需自己修改
        BatteryInfo batteryInfo = batteryInfoMapper.toEntity(resources);
        batteryInfo.setLineName(String.join("|", resources.getLineNames()));
        batteryInfoRepository.save(batteryInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        batteryInfoRepository.deleteById(id);
    }
}
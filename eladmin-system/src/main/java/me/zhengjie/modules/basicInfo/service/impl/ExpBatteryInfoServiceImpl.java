package me.zhengjie.modules.basicInfo.service.impl;

import me.zhengjie.modules.basicInfo.domain.BatteryInfo;
import me.zhengjie.modules.basicInfo.domain.ExpBatteryInfo;
import me.zhengjie.modules.basicInfo.repository.BatteryInfoRepository;
import me.zhengjie.modules.basicInfo.repository.ExpBatteryInfoRepository;
import me.zhengjie.modules.basicInfo.service.BatteryInfoService;
import me.zhengjie.modules.basicInfo.service.ExpBatteryInfoService;
import me.zhengjie.modules.basicInfo.service.dto.BatteryInfoDTO;
import me.zhengjie.modules.basicInfo.service.dto.ExpBatteryInfoDTO;
import me.zhengjie.modules.basicInfo.service.mapper.BatteryInfoMapper;
import me.zhengjie.modules.basicInfo.service.mapper.ExpBatteryInfoMapper;
import me.zhengjie.utils.ValidationUtil;
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
public class ExpBatteryInfoServiceImpl implements ExpBatteryInfoService {

    @Autowired
    private ExpBatteryInfoRepository expBatteryInfoRepository;

    @Autowired
    private ExpBatteryInfoMapper expBatteryInfoMapper;

    @Override
    public ExpBatteryInfoDTO findById(Long id) {
        Optional<ExpBatteryInfo> batteryInfo = expBatteryInfoRepository.findById(id);
        ValidationUtil.isNull(batteryInfo, "ExpBatteryInfo", "id", id);
        return expBatteryInfoMapper.toDto(batteryInfo.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ExpBatteryInfoDTO create(ExpBatteryInfo resources) {
        return expBatteryInfoMapper.toDto(expBatteryInfoRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ExpBatteryInfoDTO resources) {
        Optional<ExpBatteryInfo> optionalBatteryInfo = expBatteryInfoRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalBatteryInfo, "ExpBatteryInfo", "id", resources.getId());

        // 此处需自己修改
        ExpBatteryInfo batteryInfo = expBatteryInfoMapper.toEntity(resources);
        batteryInfo.setLineName(String.join("|", resources.getLineNames()));
        expBatteryInfoRepository.save(batteryInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        expBatteryInfoRepository.deleteById(id);
    }
}
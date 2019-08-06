package me.zhengjie.modules.basicInfo.service.impl;

import me.zhengjie.modules.basicInfo.domain.MachineInfo;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.basicInfo.repository.MachineInfoRepository;
import me.zhengjie.modules.basicInfo.service.MachineInfoService;
import me.zhengjie.modules.basicInfo.service.dto.MachineInfoDTO;
import me.zhengjie.modules.basicInfo.service.mapper.MachineInfoMapper;
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
public class MachineInfoServiceImpl implements MachineInfoService {

    @Autowired
    private MachineInfoRepository machineInfoRepository;

    @Autowired
    private MachineInfoMapper machineInfoMapper;

    @Override
    public MachineInfoDTO findById(Long id) {
        Optional<MachineInfo> machineInfo = machineInfoRepository.findById(id);
        ValidationUtil.isNull(machineInfo, "MachineInfo", "id", id);
        return machineInfoMapper.toDto(machineInfo.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MachineInfoDTO create(MachineInfo resources) {
        return machineInfoMapper.toDto(machineInfoRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(MachineInfo resources) {
        Optional<MachineInfo> optionalMachineInfo = machineInfoRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalMachineInfo, "MachineInfo", "id", resources.getId());

        MachineInfo machineInfo = optionalMachineInfo.get();
        // 此处需自己修改
        resources.setId(machineInfo.getId());
        machineInfoRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        machineInfoRepository.deleteById(id);
    }
}
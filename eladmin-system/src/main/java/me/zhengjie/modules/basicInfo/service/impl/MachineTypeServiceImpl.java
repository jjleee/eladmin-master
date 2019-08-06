package me.zhengjie.modules.basicInfo.service.impl;

import me.zhengjie.modules.basicInfo.domain.MachineType;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.basicInfo.repository.MachineTypeRepository;
import me.zhengjie.modules.basicInfo.service.MachineTypeService;
import me.zhengjie.modules.basicInfo.service.dto.MachineTypeDTO;
import me.zhengjie.modules.basicInfo.service.mapper.MachineTypeMapper;
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
public class MachineTypeServiceImpl implements MachineTypeService {

    @Autowired
    private MachineTypeRepository machineTypeRepository;

    @Autowired
    private MachineTypeMapper machineTypeMapper;

    @Override
    public MachineTypeDTO findById(Long id) {
        Optional<MachineType> machineType = machineTypeRepository.findById(id);
        ValidationUtil.isNull(machineType, "MachineType", "id", id);
        return machineTypeMapper.toDto(machineType.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MachineTypeDTO create(MachineType resources) {
        return machineTypeMapper.toDto(machineTypeRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(MachineType resources) {
        Optional<MachineType> optionalMachineType = machineTypeRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalMachineType, "MachineType", "id", resources.getId());

        MachineType machineType = optionalMachineType.get();
        // 此处需自己修改
        resources.setId(machineType.getId());
        machineTypeRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        machineTypeRepository.deleteById(id);
    }
}
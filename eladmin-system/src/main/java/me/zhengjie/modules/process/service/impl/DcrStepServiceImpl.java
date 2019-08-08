package me.zhengjie.modules.process.service.impl;

import me.zhengjie.exception.EntityExistException;
import me.zhengjie.modules.process.domain.DcrStep;
import me.zhengjie.modules.process.repository.DcrStepRepository;
import me.zhengjie.modules.process.service.DcrStepService;
import me.zhengjie.modules.process.service.dto.DcrStepDTO;
import me.zhengjie.modules.process.service.mapper.DcrStepMapper;
import me.zhengjie.modules.system.domain.Permission;
import me.zhengjie.modules.system.repository.PermissionRepository;
import me.zhengjie.modules.system.service.PermissionService;
import me.zhengjie.modules.system.service.dto.PermissionDTO;
import me.zhengjie.modules.system.service.mapper.PermissionMapper;
import me.zhengjie.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DcrStepServiceImpl implements DcrStepService {

    @Autowired
    private DcrStepRepository dcrStepRepository;

    @Autowired
    private DcrStepMapper dcrStepMapper;

    @Override
    public DcrStepDTO findById(String id) {
        Optional<DcrStep> dcrStep = dcrStepRepository.findById(id);
        ValidationUtil.isNull(dcrStep, "DcrStep", "id", id);
        return dcrStepMapper.toDto(dcrStep.get());
    }

    @Override
    public DcrStepDTO create(DcrStep resources) {
        return dcrStepMapper.toDto(dcrStepRepository.save(resources));
    }

    @Override
    public void update(DcrStep resources) {
        Optional<DcrStep> optionalDcrStep = dcrStepRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalDcrStep, "DcrStep", "id", resources.getId());

        DcrStep dcrStep = optionalDcrStep.get();
        // 此处需自己修改
        resources.setId(dcrStep.getId());
        dcrStepRepository.save(resources);
    }

    @Override
    public void delete(String id) {
        dcrStepRepository.deleteById(id);
    }

}

package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.StepProtectParam;
import me.zhengjie.modules.process.repository.StepProtectParamRepository;
import me.zhengjie.modules.process.service.StepProtectParamService;
import me.zhengjie.modules.process.service.dto.StepProtectParamDTO;
import me.zhengjie.modules.process.service.mapper.StepProtectParamMapper;
import me.zhengjie.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-04-25
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class StepProtectParamServiceImpl implements StepProtectParamService {

    @Autowired
    private StepProtectParamRepository stepProtectParamRepository;

    @Autowired
    private StepProtectParamMapper stepProtectParamMapper;

    @Override
    public StepProtectParamDTO findById(Long id) {
        Optional<StepProtectParam> stepProtectParam = stepProtectParamRepository.findById(id);
        ValidationUtil.isNull(stepProtectParam, "StepProtectParam", "id", id);
        return stepProtectParamMapper.toDto(stepProtectParam.get());
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public StepProtectParamDTO create(StepProtectParam resources) {
        return stepProtectParamMapper.toDto(stepProtectParamRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(StepProtectParam resources) {
        Optional<StepProtectParam> optionalStepProtectParam = stepProtectParamRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalStepProtectParam, "StepProtectParam", "id", resources.getId());

        StepProtectParam stepProtectParam = optionalStepProtectParam.get();
        // 此处需自己修改
        resources.setId(stepProtectParam.getId());
        stepProtectParamRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        stepProtectParamRepository.deleteById(id);
    }
}
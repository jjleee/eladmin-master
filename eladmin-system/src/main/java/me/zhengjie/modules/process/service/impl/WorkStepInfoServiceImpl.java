package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.WorkStepInfo;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.process.repository.WorkStepInfoRepository;
import me.zhengjie.modules.process.service.WorkStepInfoService;
import me.zhengjie.modules.process.service.dto.WorkStepInfoDTO;
import me.zhengjie.modules.process.service.mapper.WorkStepInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-04-03
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class WorkStepInfoServiceImpl implements WorkStepInfoService {

    @Autowired
    private WorkStepInfoRepository workStepInfoRepository;

    @Autowired
    private WorkStepInfoMapper workStepInfoMapper;

    @Override
    public WorkStepInfoDTO findById(String id) {
        Optional<WorkStepInfo> workStepInfo = workStepInfoRepository.findById(id);
        ValidationUtil.isNull(workStepInfo, "WorkStepInfo", "id", id);
        return workStepInfoMapper.toDto(workStepInfo.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public WorkStepInfoDTO create(WorkStepInfo resources) {
        return workStepInfoMapper.toDto(workStepInfoRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(WorkStepInfo resources) {
        Optional<WorkStepInfo> optionalWorkStepInfo = workStepInfoRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalWorkStepInfo, "WorkStepInfo", "id", resources.getId());

        WorkStepInfo workStepInfo = optionalWorkStepInfo.get();
        // 此处需自己修改
        resources.setId(workStepInfo.getId());
        workStepInfoRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        workStepInfoRepository.deleteById(id);
    }
}
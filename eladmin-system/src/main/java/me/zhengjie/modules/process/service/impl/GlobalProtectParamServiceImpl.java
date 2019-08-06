package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.GlobalProtectParam;
import me.zhengjie.modules.process.repository.GlobalProtectParamRepository;
import me.zhengjie.modules.process.service.GlobalProtectParamService;
import me.zhengjie.modules.process.service.dto.GlobalProtectParamDTO;
import me.zhengjie.modules.process.service.mapper.GlobalProtectParamMapper;
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
public class GlobalProtectParamServiceImpl implements GlobalProtectParamService {

    @Autowired
    private GlobalProtectParamRepository globalProtectParamRepository;

    @Autowired
    private GlobalProtectParamMapper globalProtectParamMapper;

    @Override
    public GlobalProtectParamDTO findById(Long id) {
        Optional<GlobalProtectParam> globalProtectParam = globalProtectParamRepository.findById(id);
        ValidationUtil.isNull(globalProtectParam, "GlobalProtectParam", "id", id);
        return globalProtectParamMapper.toDto(globalProtectParam.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public GlobalProtectParamDTO create(GlobalProtectParam resources) {
        return globalProtectParamMapper.toDto(globalProtectParamRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(GlobalProtectParam resources) {
        Optional<GlobalProtectParam> optionalglobalProtectParam = globalProtectParamRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalglobalProtectParam, "globalProtectParam", "id", resources.getId());

        GlobalProtectParam globalProtectParam = optionalglobalProtectParam.get();
        // 此处需自己修改
        resources.setId(globalProtectParam.getId());
        globalProtectParamRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        globalProtectParamRepository.deleteById(id);
    }
}
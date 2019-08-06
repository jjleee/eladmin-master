package me.zhengjie.modules.data.service.impl;

import me.zhengjie.modules.data.domain.ProcessData;
import me.zhengjie.modules.data.repository.ProcessDataRepository;
import me.zhengjie.modules.data.service.ProcessDataService;
import me.zhengjie.modules.data.service.dto.ProcessDataDTO;
import me.zhengjie.modules.data.service.mapper.ProcessDataMapper;
import me.zhengjie.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-05-22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProcessDataServiceImpl implements ProcessDataService {

    @Autowired
    private ProcessDataRepository processDataRepository;

    @Autowired
    private ProcessDataMapper processDataMapper;

    @Override
    public ProcessDataDTO findById(Long id) {
        Optional<ProcessData> processData = processDataRepository.findById(id);
        ValidationUtil.isNull(processData, "ProcessData", "id", id);
        return processDataMapper.toDto(processData.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProcessDataDTO create(ProcessData resources) {
        return processDataMapper.toDto(processDataRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ProcessData resources) {
        Optional<ProcessData> optionalProcessData = processDataRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalProcessData, "ProcessData", "id", resources.getId());

        ProcessData processData = optionalProcessData.get();
        // 此处需自己修改
        resources.setId(processData.getId());
        processDataRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        processDataRepository.deleteById(id);
    }
}
package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.ProcessItem;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.process.repository.ProcessItemRepository;
import me.zhengjie.modules.process.service.ProcessItemService;
import me.zhengjie.modules.process.service.dto.ProcessItemDTO;
import me.zhengjie.modules.process.service.mapper.ProcessItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-04-08
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProcessItemServiceImpl implements ProcessItemService {

    @Autowired
    private ProcessItemRepository processItemRepository;

    @Autowired
    private ProcessItemMapper processItemMapper;

    @Override
    public ProcessItemDTO findById(String id) {
        Optional<ProcessItem> processItem = processItemRepository.findById(id);
        ValidationUtil.isNull(processItem, "ProcessItem", "id", id);
        return processItemMapper.toDto(processItem.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProcessItemDTO create(ProcessItem resources) {
        return processItemMapper.toDto(processItemRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ProcessItem resources) {
        Optional<ProcessItem> optionalProcessItem = processItemRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalProcessItem, "ProcessItem", "id", resources.getId());

        ProcessItem processItem = optionalProcessItem.get();
        // 此处需自己修改
        resources.setId(processItem.getId());
        processItemRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        processItemRepository.deleteById(id);
    }
}
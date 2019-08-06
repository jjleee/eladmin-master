package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.ProcessItem;
import me.zhengjie.modules.process.domain.ProcessRecipe;
import me.zhengjie.modules.process.repository.ProcessItemRepository;
import me.zhengjie.utils.KeyUtil;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.process.repository.ProcessRecipeRepository;
import me.zhengjie.modules.process.service.ProcessRecipeService;
import me.zhengjie.modules.process.service.dto.ProcessRecipeDTO;
import me.zhengjie.modules.process.service.mapper.ProcessRecipeMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author jie
 * @date 2019-04-08
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProcessRecipeServiceImpl implements ProcessRecipeService {

    @Autowired
    private ProcessRecipeRepository processRecipeRepository;

    @Autowired
    private ProcessRecipeMapper processRecipeMapper;

    @Autowired
    private ProcessItemRepository processItemRepository;

    @Override
    public ProcessRecipeDTO findById(String id) {
        Optional<ProcessRecipe> processRecipe = processRecipeRepository.findById(id);
        ValidationUtil.isNull(processRecipe, "ProcessRecipe", "id", id);
        return processRecipeMapper.toDto(processRecipe.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProcessRecipeDTO create(ProcessRecipeDTO resources) {
        String recipeId = KeyUtil.genUniqueKey();
        for (ProcessItem processItem : resources.getProcessItems()) {
            processItem.setId(KeyUtil.genUniqueKey());
            processItem.setProcessId(recipeId);
            processItemRepository.save(processItem);
        }
        ProcessRecipe processRecipe = new ProcessRecipe();
        resources.setId(recipeId);
        BeanUtils.copyProperties(resources, processRecipe);
        processRecipe.setValid(true);
        processRecipe.setVersion(1);
        return processRecipeMapper.toDto(processRecipeRepository.save(processRecipe));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ProcessRecipeDTO resources) {
        Optional<ProcessRecipe> optionalProcessRecipe = processRecipeRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalProcessRecipe, "ProcessRecipe", "id", resources.getId());

        ProcessRecipe oldRecipe = optionalProcessRecipe.get();
        oldRecipe.setValid(false);
        // 此处需自己修改
        ProcessRecipe newRecipe = new ProcessRecipe();
        BeanUtils.copyProperties(resources, newRecipe);
        String recipeId = KeyUtil.genUniqueKey();
        newRecipe.setId(recipeId);
        for (ProcessItem processItem : resources.getProcessItems()) {
            if (processItem.getItemName() != null && processItem.getOrderNo() != null) {
                processItem.setId(KeyUtil.genUniqueKey());
                processItem.setProcessId(recipeId);
                processItemRepository.save(processItem);
            }
        }
        newRecipe.setValid(true);
        newRecipe.setVersion(oldRecipe.getVersion() + 1);
        processRecipeRepository.save(oldRecipe);
        processRecipeRepository.save(newRecipe);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        processRecipeRepository.deleteById(id);
    }
}
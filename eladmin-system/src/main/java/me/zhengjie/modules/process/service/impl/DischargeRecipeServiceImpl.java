package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.DischargeRecipe;
import me.zhengjie.modules.process.domain.WorkStepInfo;
import me.zhengjie.modules.process.repository.DischargeRecipeRepository;
import me.zhengjie.modules.process.repository.WorkStepInfoRepository;
import me.zhengjie.modules.process.service.DischargeRecipeService;
import me.zhengjie.modules.process.service.dto.DischargeRecipeDTO;
import me.zhengjie.modules.process.service.mapper.DischargeRecipeMapper;
import me.zhengjie.utils.KeyUtil;
import me.zhengjie.utils.ValidationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Optional;

/**
 * @author jie
 * @date 2019-04-26
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DischargeRecipeServiceImpl implements DischargeRecipeService {

    @Autowired
    private DischargeRecipeRepository dischargeRecipeRepository;

    @Autowired
    private DischargeRecipeMapper dischargeRecipeMapper;

    @Autowired
    private WorkStepInfoRepository workStepInfoRepository;

    @Override
    public DischargeRecipeDTO findById(String id) {
        Optional<DischargeRecipe> dischargeRecipe = dischargeRecipeRepository.findById(id);
        ValidationUtil.isNull(dischargeRecipe, "DischargeRecipe", "id", id);
        return dischargeRecipeMapper.toDto(dischargeRecipe.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DischargeRecipeDTO create(DischargeRecipeDTO resources) {
        String recipeId = KeyUtil.genUniqueKey();
        for (WorkStepInfo workStepInfo : resources.getWorkStepInfos()) {
            workStepInfo.setId(KeyUtil.genUniqueKey());
            workStepInfo.setRecipeId(recipeId);
            workStepInfoRepository.save(workStepInfo);
        }
        DischargeRecipe dischargeRecipe = new DischargeRecipe();
        resources.setId(recipeId);
        BeanUtils.copyProperties(resources, dischargeRecipe);
        dischargeRecipe.setValid(true);
        dischargeRecipe.setRecipeVersion(1);
        dischargeRecipe.setUpdaterName(resources.getEditorName());
        return dischargeRecipeMapper.toDto(dischargeRecipeRepository.save(dischargeRecipe));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DischargeRecipeDTO resources, Principal principal) {
        Optional<DischargeRecipe> optionalDischargeRecipe = dischargeRecipeRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalDischargeRecipe, "DischargeRecipe", "id", resources.getId());

        DischargeRecipe oldRecipe = optionalDischargeRecipe.get();
        oldRecipe.setValid(false);
        // 此处需自己修改
        DischargeRecipe newRecipe = new DischargeRecipe();
        BeanUtils.copyProperties(resources, newRecipe);
        String recipeId = KeyUtil.genUniqueKey();
        newRecipe.setId(recipeId);
        for (WorkStepInfo workStepInfo : resources.getWorkStepInfos()) {
            if (workStepInfo.getId() != null && workStepInfo.getStroke() != null) {
                workStepInfo.setId(KeyUtil.genUniqueKey());
                workStepInfo.setRecipeId(recipeId);
                workStepInfoRepository.save(workStepInfo);
            }
        }
        newRecipe.setValid(true);
        newRecipe.setUpdaterName(principal.getName());
        newRecipe.setRecipeVersion(oldRecipe.getRecipeVersion() + 1);
        dischargeRecipeRepository.save(oldRecipe);
        dischargeRecipeRepository.save(newRecipe);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        dischargeRecipeRepository.deleteById(id);
    }
}
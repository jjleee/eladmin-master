package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.FormationRecipe;
import me.zhengjie.modules.process.domain.WorkStepInfo;
import me.zhengjie.modules.process.repository.FormationRecipeRepository;
import me.zhengjie.modules.process.repository.WorkStepInfoRepository;
import me.zhengjie.modules.process.service.FormationRecipeService;
import me.zhengjie.modules.process.service.dto.FormationRecipeDTO;
import me.zhengjie.modules.process.service.mapper.FormationRecipeMapper;
import me.zhengjie.utils.KeyUtil;
import me.zhengjie.utils.StringUtils;
import me.zhengjie.utils.ValidationUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

/**
 * @author jie
 * @date 2019-04-03
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class FormationRecipeServiceImpl implements FormationRecipeService {

    @Autowired
    private FormationRecipeRepository formationRecipeRepository;

    @Autowired
    private FormationRecipeMapper formationRecipeMapper;

    @Autowired
    private WorkStepInfoRepository workStepInfoRepository;

    @Override
    public FormationRecipeDTO findById(String id) {
        Optional<FormationRecipe> formationRecipe = formationRecipeRepository.findById(id);
        ValidationUtil.isNull(formationRecipe, "FormationRecipe", "id", id);
        return formationRecipeMapper.toDto(formationRecipe.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FormationRecipeDTO create(FormationRecipeDTO resources,String name) {

        String recipeId = KeyUtil.genUniqueKey();
        for (WorkStepInfo workStepInfo : resources.getWorkStepInfos()) {
            handleLogic(resources, recipeId, workStepInfo);
        }
        FormationRecipe formationRecipe = new FormationRecipe();
        resources.setId(recipeId);
        BeanUtils.copyProperties(resources, formationRecipe);
        formationRecipe.setValid(true);
        formationRecipe.setEditorName(name);
        formationRecipe.setUpdaterName(name);
        formationRecipe.setVersion(1);
        return formationRecipeMapper.toDto(formationRecipeRepository.save(formationRecipe));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FormationRecipeDTO copy(String id,String name,Principal principal) {
        String recipeId=KeyUtil.genUniqueKey();
        FormationRecipe recipe = formationRecipeRepository.findById(id).get();
        List<WorkStepInfo> workStepInfos=workStepInfoRepository.findByRecipeId(recipe.getId());
        FormationRecipe formationRecipe=new FormationRecipe();
        BeanUtils.copyProperties(recipe, formationRecipe);
        formationRecipe.setId(recipeId);
        formationRecipe.setName(name);
        formationRecipe.setVersion(1);
        formationRecipe.setValid(true);
        formationRecipe.setEditorName(principal.getName());
        formationRecipe.setUpdaterName(principal.getName());
        for (WorkStepInfo workStepInfo : workStepInfos) {
            WorkStepInfo stepInfo=new WorkStepInfo();
            BeanUtils.copyProperties(workStepInfo, stepInfo);
            stepInfo.setId(KeyUtil.genUniqueKey());
            stepInfo.setRecipeId(recipeId);
            workStepInfoRepository.save(stepInfo);
        }
        return formationRecipeMapper.toDto(formationRecipeRepository.save(formationRecipe));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(FormationRecipeDTO resources, Principal principal) {
        Optional<FormationRecipe> optionalFormationRecipe = formationRecipeRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalFormationRecipe, "FormationRecipe", "id", resources.getId());
        FormationRecipe oldRecipe = optionalFormationRecipe.get();
        oldRecipe.setValid(false);
        FormationRecipe newRecipe = new FormationRecipe();
        BeanUtils.copyProperties(resources, newRecipe);
        String recipeId = KeyUtil.genUniqueKey();
        newRecipe.setId(recipeId);
        for (WorkStepInfo workStepInfo : resources.getWorkStepInfos()) {
            if (StringUtils.isNotEmpty(workStepInfo.getStroke())) {
                handleLogic(resources, recipeId, workStepInfo);
            }
        }
        newRecipe.setValid(true);
        newRecipe.setUpdaterName(principal.getName());
        newRecipe.setVersion(oldRecipe.getVersion() + 1);
        formationRecipeRepository.save(oldRecipe);
        formationRecipeRepository.save(newRecipe);
    }

    private void handleLogic(FormationRecipeDTO resources, String recipeId,  @NotNull WorkStepInfo workStepInfo) {
        workStepInfo.setId(KeyUtil.genUniqueKey());
        workStepInfo.setRecipeId(recipeId);
        if (StringUtils.isNotEmpty(workStepInfo.getStroke())) {
            switch (workStepInfo.getStroke()) {
                case "CC":
                    if (workStepInfo.getOffCapacity() != null) {
                        workStepInfo.setOffCapacityLogic(1);
                    }
                    if (workStepInfo.getOffVoltage() != null) {
                        workStepInfo.setOffVoltageLogic(1);
                    }
                    if (workStepInfo.getOffTimeMin() != null || workStepInfo.getOffTimeSec() != null) {
                        workStepInfo.setOffTimeLogic(1);
                    }
                    break;
                case "DC":
                    if (workStepInfo.getOffCapacity() != null) {
                        workStepInfo.setOffCapacityLogic(1);
                    }
                    if (workStepInfo.getOffVoltage() != null) {
                        workStepInfo.setOffVoltageLogic(2);
                    }
                    if (workStepInfo.getOffTimeMin() != null || workStepInfo.getOffTimeSec() != null) {
                        workStepInfo.setOffTimeLogic(1);
                    }
                    break;
                case "CC-CV":
                    if (workStepInfo.getOffCapacity() != null) {
                        workStepInfo.setOffCapacityLogic(1);
                    }
                    if (workStepInfo.getOffCurrent() != null) {
                        workStepInfo.setOffCurrentLogic(2);
                    }
                    if (workStepInfo.getOffTimeMin() != null || workStepInfo.getOffTimeSec() != null) {
                        workStepInfo.setOffTimeLogic(1);
                    }
                    break;
                case "DC-DV":
                    if (workStepInfo.getOffCapacity() != null) {
                        workStepInfo.setOffCapacityLogic(1);
                    }
                    if (workStepInfo.getOffCurrent() != null) {
                        workStepInfo.setOffCurrentLogic(2);
                    }
                    if (workStepInfo.getOffTimeMin() != null || workStepInfo.getOffTimeSec() != null) {
                        workStepInfo.setOffTimeLogic(1);
                    }
                    break;
                case "standing":
                    if (workStepInfo.getOffTimeMin() != null || workStepInfo.getOffTimeSec() != null) {
                        workStepInfo.setOffTimeLogic(1);
                    }
                    break;
                default:
            }
        }
        if (workStepInfo.getOrderNumber() == resources.getWorkStepInfos().size()) {
            workStepInfo.setOffAction(3);
        } else {
            workStepInfo.setOffAction(1);
        }
        workStepInfoRepository.save(workStepInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        workStepInfoRepository.deleteWorkStepInfosByRecipeId(id);
        formationRecipeRepository.deleteById(id);
    }
}
package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.DcrRecipe;
import me.zhengjie.modules.process.domain.DcrStep;
import me.zhengjie.modules.process.repository.DcrStepRepository;
import me.zhengjie.modules.process.service.dto.DcrStepDTO;
import me.zhengjie.utils.KeyUtil;
import me.zhengjie.utils.StringUtils;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.process.repository.DcrRecipeRepository;
import me.zhengjie.modules.process.service.DcrRecipeService;
import me.zhengjie.modules.process.service.dto.DcrRecipeDTO;
import me.zhengjie.modules.process.service.mapper.DcrRecipeMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-04-09
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DcrRecipeServiceImpl implements DcrRecipeService {

    @Autowired
    private DcrRecipeRepository dcrRecipeRepository;

    @Autowired
    private DcrRecipeMapper dcrRecipeMapper;
    @Autowired
    private DcrStepRepository dcrStepRepository;

    @Override
    public DcrRecipeDTO findById(String id) {
        Optional<DcrRecipe> dcrRecipe = dcrRecipeRepository.findById(id);
        ValidationUtil.isNull(dcrRecipe, "DcrRecipe", "id", id);
        return dcrRecipeMapper.toDto(dcrRecipe.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DcrRecipeDTO create(DcrRecipeDTO resources) {
        String recipeId = KeyUtil.genUniqueKey();
        for (DcrStep dcrStep : resources.getSteps()) {
            dcrStep.setId(KeyUtil.genUniqueKey());
            dcrStep.setRecipeId(recipeId);
            dcrStepRepository.save(dcrStep);
        }
        DcrRecipe recipe = new DcrRecipe();
        resources.setId(recipeId);
        BeanUtils.copyProperties(resources, recipe);
        recipe.setValid(true);
        recipe.setVersion(1);
        return dcrRecipeMapper.toDto(dcrRecipeRepository.save(recipe));
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DcrRecipeDTO resources) {
        Optional<DcrRecipe> optionalDcrRecipe = dcrRecipeRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalDcrRecipe, "DcrRecipe", "id", resources.getId());

        DcrRecipe oldRecipe = optionalDcrRecipe.get();
        oldRecipe.setValid(false);
        DcrRecipe newRecipe = new DcrRecipe();
        BeanUtils.copyProperties(resources, newRecipe);
        String recipeId = KeyUtil.genUniqueKey();
        newRecipe.setId(recipeId);
        for (DcrStep dcrStep : resources.getSteps()) {
            if (StringUtils.isNotEmpty(dcrStep.getStepName())) {
                dcrStep.setId(KeyUtil.genUniqueKey());
                dcrStep.setRecipeId(recipeId);
                dcrStepRepository.save(dcrStep);
            }
        }
        newRecipe.setValid(true);
        newRecipe.setVersion(oldRecipe.getVersion() + 1);
        dcrRecipeRepository.save(oldRecipe);
        dcrRecipeRepository.save(newRecipe);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        dcrStepRepository.deleteDcrStepsByRecipeId(id);
        dcrRecipeRepository.deleteById(id);
    }
}
package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.DivisionRecipe;
import me.zhengjie.modules.process.domain.WorkStepInfo;
import me.zhengjie.modules.process.repository.DivisionRecipeRepository;
import me.zhengjie.modules.process.repository.WorkStepInfoRepository;
import me.zhengjie.modules.process.service.DivisionRecipeService;
import me.zhengjie.modules.process.service.dto.DivisionRecipeDTO;
import me.zhengjie.modules.process.service.mapper.DivisionRecipeMapper;
import me.zhengjie.modules.security.security.JwtUser;
import me.zhengjie.modules.security.service.JwtUserDetailsService;
import me.zhengjie.modules.security.utils.JwtTokenUtil;
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
public class DivisionRecipeServiceImpl implements DivisionRecipeService {

    @Autowired
    private DivisionRecipeRepository divisionRecipeRepository;

    @Autowired
    private DivisionRecipeMapper divisionRecipeMapper;
    @Autowired
    private WorkStepInfoRepository workStepInfoRepository;


    @Override
    public DivisionRecipeDTO findById(String id) {
        Optional<DivisionRecipe> divisionRecipe = divisionRecipeRepository.findById(id);
        ValidationUtil.isNull(divisionRecipe, "DivisionRecipe", "id", id);
        return divisionRecipeMapper.toDto(divisionRecipe.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DivisionRecipeDTO create(DivisionRecipeDTO resources) {
        String recipeId = KeyUtil.genUniqueKey();
        for (WorkStepInfo workStepInfo : resources.getWorkStepInfos()) {
            workStepInfo.setId(KeyUtil.genUniqueKey());
            workStepInfo.setRecipeId(recipeId);
            workStepInfoRepository.save(workStepInfo);
        }
        DivisionRecipe divisionRecipe = new DivisionRecipe();
        resources.setId(recipeId);
        BeanUtils.copyProperties(resources, divisionRecipe);
        divisionRecipe.setValid(true);
        divisionRecipe.setRecipeVersion(1);
        return divisionRecipeMapper.toDto(divisionRecipeRepository.save(divisionRecipe));

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DivisionRecipeDTO resources, Principal principal) {
        Optional<DivisionRecipe> optionalDivisionRecipe = divisionRecipeRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalDivisionRecipe, "DivisionRecipe", "id", resources.getId());

        DivisionRecipe oldRecipe = optionalDivisionRecipe.get();
        oldRecipe.setValid(false);
        // 此处需自己修改
        DivisionRecipe newRecipe = new DivisionRecipe();
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
        newRecipe.setRecipeVersion(oldRecipe.getRecipeVersion() + 1);

        newRecipe.setUpdaterName(principal.getName());
        divisionRecipeRepository.save(oldRecipe);
        divisionRecipeRepository.save(newRecipe);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        divisionRecipeRepository.deleteById(id);
    }
}
package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.DcrRecipe;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.process.repository.DcrRecipeRepository;
import me.zhengjie.modules.process.service.DcrRecipeService;
import me.zhengjie.modules.process.service.dto.DcrRecipeDTO;
import me.zhengjie.modules.process.service.mapper.DcrRecipeMapper;
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

    @Override
    public DcrRecipeDTO findById(Long id) {
        Optional<DcrRecipe> dcrRecipe = dcrRecipeRepository.findById(id);
        ValidationUtil.isNull(dcrRecipe, "DcrRecipe", "id", id);
        return dcrRecipeMapper.toDto(dcrRecipe.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DcrRecipeDTO create(DcrRecipe resources) {
        return dcrRecipeMapper.toDto(dcrRecipeRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DcrRecipe resources) {
        Optional<DcrRecipe> optionalDcrRecipe = dcrRecipeRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalDcrRecipe, "DcrRecipe", "id", resources.getId());

        DcrRecipe dcrRecipe = optionalDcrRecipe.get();
        // 此处需自己修改
        resources.setId(dcrRecipe.getId());
        dcrRecipeRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        dcrRecipeRepository.deleteById(id);
    }
}
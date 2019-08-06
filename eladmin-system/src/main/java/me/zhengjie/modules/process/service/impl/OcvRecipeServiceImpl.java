package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.OcvRecipe;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.process.repository.OcvRecipeRepository;
import me.zhengjie.modules.process.service.OcvRecipeService;
import me.zhengjie.modules.process.service.dto.OcvRecipeDTO;
import me.zhengjie.modules.process.service.mapper.OcvRecipeMapper;
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
public class OcvRecipeServiceImpl implements OcvRecipeService {

    @Autowired
    private OcvRecipeRepository ocvRecipeRepository;

    @Autowired
    private OcvRecipeMapper ocvRecipeMapper;

    @Override
    public OcvRecipeDTO findById(Long id) {
        Optional<OcvRecipe> ocvRecipe = ocvRecipeRepository.findById(id);
        ValidationUtil.isNull(ocvRecipe, "OcvRecipe", "id", id);
        return ocvRecipeMapper.toDto(ocvRecipe.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OcvRecipeDTO create(OcvRecipe resources) {
        return ocvRecipeMapper.toDto(ocvRecipeRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(OcvRecipe resources) {
        Optional<OcvRecipe> optionalOcvRecipe = ocvRecipeRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalOcvRecipe, "OcvRecipe", "id", resources.getId());

        OcvRecipe ocvRecipe = optionalOcvRecipe.get();
        // 此处需自己修改
        resources.setId(ocvRecipe.getId());
        ocvRecipeRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        ocvRecipeRepository.deleteById(id);
    }
}
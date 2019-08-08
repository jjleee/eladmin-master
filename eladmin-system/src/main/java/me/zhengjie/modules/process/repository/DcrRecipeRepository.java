package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.DcrRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author jie
 * @date 2019-04-09
 */
public interface DcrRecipeRepository extends JpaRepository<DcrRecipe, String>, JpaSpecificationExecutor {
    /**
     * 查找所有有效配方
     * @param valid
     * @return
     */
    List<DcrRecipe> findAllByValidAndRecipeType(Boolean valid,Integer recipeType);
}
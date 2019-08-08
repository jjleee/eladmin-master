package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.FormationRecipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author jie
 * @date 2019-04-03
 */
public interface FormationRecipeRepository extends JpaRepository<FormationRecipe, String>, JpaSpecificationExecutor {
    /**
     * 根据类型查找所有有效配方
     * @param valid
     * @param recipeType
     * @return
     */
    List<FormationRecipe> findAllByValidAndRecipeType(Boolean valid,Integer recipeType);

}
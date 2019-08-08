package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.DivisionRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author jie
 * @date 2019-04-26
 */
public interface DivisionRecipeRepository extends JpaRepository<DivisionRecipe, String>, JpaSpecificationExecutor {
    /**
     * 查询所有可用
     *
     * @param valid
     * @return
     */
    List<DivisionRecipe> findByValidAndRecipeType(Boolean valid,Integer recipeType);
}
package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.DischargeRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author jie
 * @date 2019-04-26
 */
public interface DischargeRecipeRepository extends JpaRepository<DischargeRecipe, String>, JpaSpecificationExecutor {

    /**
     * 查询所有可用的
     *
     * @param valid
     * @return
     */
    List<DischargeRecipe> findByValidAndRecipeType(Boolean valid,Integer recipeType);
}
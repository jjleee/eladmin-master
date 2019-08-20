package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.DischargeRecipe;
import me.zhengjie.modules.process.domain.DivisionRecipe;
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

    /**
     * 根据名称查找配方
     * @param name
     * @param valid
     * @return
     */
    DischargeRecipe findByRecipeNameAndValid(String name, Boolean valid);
}
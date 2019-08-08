package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.DcrStep;
import me.zhengjie.modules.system.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;

/**
 * @author jie
 * @date 2018-12-03
 */
public interface DcrStepRepository extends JpaRepository<DcrStep, String>, JpaSpecificationExecutor {

    /**
     * 根据recipeId删除
     *
     * @param recipeId
     * @return
     */
    void deleteDcrStepsByRecipeId(String recipeId);

    /**
     * 根据配方ID查找所有工步
     *
     * @param recipeId
     * @return
     */
    List<DcrStep> findByRecipeId(String recipeId);
}

package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.WorkStepInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author jie
 * @date 2019-04-03
 */
public interface WorkStepInfoRepository extends JpaRepository<WorkStepInfo, String>, JpaSpecificationExecutor {
    /**
     * 根据recipeId删除
     *
     * @param recipeId
     * @return
     */
    void deleteWorkStepInfosByRecipeId(String recipeId);

    /**
     * 根据配方ID查找所有工步
     *
     * @param recipeId
     * @return
     */
    List<WorkStepInfo> findByRecipeId(String recipeId);
}
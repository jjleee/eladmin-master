package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.ProcessRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author jie
 * @date 2019-04-08
 */
public interface ProcessRecipeRepository extends JpaRepository<ProcessRecipe, String>, JpaSpecificationExecutor {
    List<ProcessRecipe> findAllByValid(Boolean valid);
}
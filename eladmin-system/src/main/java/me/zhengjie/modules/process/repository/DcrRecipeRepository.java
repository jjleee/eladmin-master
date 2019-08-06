package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.DcrRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-04-09
 */
public interface DcrRecipeRepository extends JpaRepository<DcrRecipe, Long>, JpaSpecificationExecutor {
}
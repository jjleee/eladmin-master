package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.OcvRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-04-09
 */
public interface OcvRecipeRepository extends JpaRepository<OcvRecipe, Long>, JpaSpecificationExecutor {
}
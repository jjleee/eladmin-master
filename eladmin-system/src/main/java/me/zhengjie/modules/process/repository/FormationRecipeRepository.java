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
     * 查找可用
     *
     * @param valid
     * @return
     */
    List<FormationRecipe> findAllByValid(Boolean valid);

}
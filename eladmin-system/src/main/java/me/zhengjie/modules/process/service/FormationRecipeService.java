package me.zhengjie.modules.process.service;

import me.zhengjie.modules.process.service.dto.FormationRecipeDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.security.Principal;

/**
 * @author jie
 * @date 2019-04-03
 */
@CacheConfig(cacheNames = "formationRecipe")
public interface FormationRecipeService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    FormationRecipeDTO findById(String id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    FormationRecipeDTO create(FormationRecipeDTO resources);

    /**
     * copy
     * @param id
     * @return
     */
    @CacheEvict(allEntries = true)
    FormationRecipeDTO copy(String id,String name,Principal principal);
    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(FormationRecipeDTO resources, Principal principal);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(String id);
}
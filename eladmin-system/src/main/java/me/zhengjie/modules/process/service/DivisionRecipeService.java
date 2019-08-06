package me.zhengjie.modules.process.service;

import me.zhengjie.modules.process.domain.DivisionRecipe;
import me.zhengjie.modules.process.service.dto.DivisionRecipeDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.security.Principal;

/**
 * @author jie
 * @date 2019-04-26
 */
@CacheConfig(cacheNames = "divisionRecipe")
public interface DivisionRecipeService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    DivisionRecipeDTO findById(String id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    DivisionRecipeDTO create(DivisionRecipeDTO resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(DivisionRecipeDTO resources, Principal principal);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(String id);
}
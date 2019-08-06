package me.zhengjie.modules.process.service;

import me.zhengjie.modules.process.domain.ProcessRecipe;
import me.zhengjie.modules.process.service.dto.ProcessRecipeDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-08
 */
@CacheConfig(cacheNames = "processRecipe")
public interface ProcessRecipeService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    ProcessRecipeDTO findById(String id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    ProcessRecipeDTO create(ProcessRecipeDTO resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(ProcessRecipeDTO resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(String id);
}
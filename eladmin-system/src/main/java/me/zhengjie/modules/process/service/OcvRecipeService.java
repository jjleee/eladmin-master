package me.zhengjie.modules.process.service;

import me.zhengjie.modules.process.domain.OcvRecipe;
import me.zhengjie.modules.process.service.dto.OcvRecipeDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-09
 */
@CacheConfig(cacheNames = "ocvRecipe")
public interface OcvRecipeService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    OcvRecipeDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    OcvRecipeDTO create(OcvRecipe resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(OcvRecipe resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
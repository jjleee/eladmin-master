package me.zhengjie.modules.process.service;

import me.zhengjie.modules.process.domain.DcrRecipe;
import me.zhengjie.modules.process.service.dto.DcrRecipeDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-09
 */
@CacheConfig(cacheNames = "dcrRecipe")
public interface DcrRecipeService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    DcrRecipeDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    DcrRecipeDTO create(DcrRecipe resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(DcrRecipe resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
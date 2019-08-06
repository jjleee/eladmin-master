package me.zhengjie.modules.process.service;

import me.zhengjie.modules.process.domain.DischargeRecipe;
import me.zhengjie.modules.process.service.dto.DischargeRecipeDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.security.Principal;

/**
 * @author jie
 * @date 2019-04-26
 */
@CacheConfig(cacheNames = "dischargeRecipe")
public interface DischargeRecipeService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    DischargeRecipeDTO findById(String id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    DischargeRecipeDTO create(DischargeRecipeDTO resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(DischargeRecipeDTO resources, Principal principal);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(String id);
}
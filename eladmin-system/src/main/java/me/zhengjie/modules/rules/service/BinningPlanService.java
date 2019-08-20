package me.zhengjie.modules.rules.service;

import me.zhengjie.modules.rules.domain.BinningPlan;
import me.zhengjie.modules.rules.service.dto.BinningPlanDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-09
 */
@CacheConfig(cacheNames = "binningPlan")
public interface BinningPlanService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    BinningPlanDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    BinningPlanDTO create(BinningPlan resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(BinningPlan resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
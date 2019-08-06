package me.zhengjie.modules.process.service;

import me.zhengjie.modules.process.domain.VacuumPlan;
import me.zhengjie.modules.process.service.dto.VacuumPlanDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-05-18
 */
@CacheConfig(cacheNames = "vacuumPlan")
public interface VacuumPlanService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    VacuumPlanDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    VacuumPlanDTO create(VacuumPlan resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(VacuumPlan resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
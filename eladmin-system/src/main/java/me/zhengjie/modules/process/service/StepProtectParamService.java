package me.zhengjie.modules.process.service;

import me.zhengjie.modules.process.domain.StepProtectParam;
import me.zhengjie.modules.process.service.dto.StepProtectParamDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-25
 */
@CacheConfig(cacheNames = "stepProtectParam")
public interface StepProtectParamService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    StepProtectParamDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    StepProtectParamDTO create(StepProtectParam resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(StepProtectParam resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
package me.zhengjie.modules.process.service;

import me.zhengjie.modules.process.domain.DcrStep;
import me.zhengjie.modules.process.service.dto.DcrStepDTO;
import me.zhengjie.modules.system.domain.Permission;
import me.zhengjie.modules.system.service.dto.PermissionDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author lijj
 * @date 2019-08-05
 */
@CacheConfig(cacheNames = "dcrStep")
public interface DcrStepService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    DcrStepDTO findById(String id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    DcrStepDTO create(DcrStep resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(DcrStep resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(String id);
}

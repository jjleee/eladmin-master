package me.zhengjie.modules.process.service;

import me.zhengjie.modules.process.domain.GlobalProtectParam;
import me.zhengjie.modules.process.service.dto.GlobalProtectParamDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-25
 */
@CacheConfig(cacheNames = "globalProtectParam")
public interface GlobalProtectParamService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    GlobalProtectParamDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    GlobalProtectParamDTO create(GlobalProtectParam resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(GlobalProtectParam resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
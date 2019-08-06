package me.zhengjie.modules.basicInfo.service;

import me.zhengjie.modules.basicInfo.domain.Factory;
import me.zhengjie.modules.basicInfo.service.dto.FactoryDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-10
 */
@CacheConfig(cacheNames = "factory")
public interface FactoryService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    FactoryDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    FactoryDTO create(Factory resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Factory resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
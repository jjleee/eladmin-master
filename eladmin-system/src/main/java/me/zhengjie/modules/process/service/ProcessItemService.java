package me.zhengjie.modules.process.service;

import me.zhengjie.modules.process.domain.ProcessItem;
import me.zhengjie.modules.process.service.dto.ProcessItemDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-08
 */
@CacheConfig(cacheNames = "processItem")
public interface ProcessItemService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    ProcessItemDTO findById(String id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    ProcessItemDTO create(ProcessItem resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(ProcessItem resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(String id);
}
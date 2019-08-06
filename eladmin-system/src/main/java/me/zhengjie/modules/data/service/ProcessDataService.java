package me.zhengjie.modules.data.service;

import me.zhengjie.modules.data.domain.ProcessData;
import me.zhengjie.modules.data.service.dto.ProcessDataDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-05-22
 */
@CacheConfig(cacheNames = "processData")
public interface ProcessDataService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    ProcessDataDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    ProcessDataDTO create(ProcessData resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(ProcessData resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
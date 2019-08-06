package me.zhengjie.modules.data.service;

import me.zhengjie.modules.data.domain.CutoffData;
import me.zhengjie.modules.data.service.dto.CutoffDataDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-05-22
 */
@CacheConfig(cacheNames = "cutoffData")
public interface CutoffDataService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    CutoffDataDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    CutoffDataDTO create(CutoffData resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(CutoffData resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
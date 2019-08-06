package me.zhengjie.modules.basicInfo.service;

import me.zhengjie.modules.basicInfo.domain.LineType;
import me.zhengjie.modules.basicInfo.service.dto.LineTypeDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-10
 */
@CacheConfig(cacheNames = "lineType")
public interface LineTypeService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    LineTypeDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    LineTypeDTO create(LineType resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(LineType resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
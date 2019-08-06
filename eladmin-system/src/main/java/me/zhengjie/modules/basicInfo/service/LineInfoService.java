package me.zhengjie.modules.basicInfo.service;

import me.zhengjie.modules.basicInfo.domain.LineInfo;
import me.zhengjie.modules.basicInfo.service.dto.LineInfoDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-10
 */
@CacheConfig(cacheNames = "lineInfo")
public interface LineInfoService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    LineInfoDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    LineInfoDTO create(LineInfo resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(LineInfo resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
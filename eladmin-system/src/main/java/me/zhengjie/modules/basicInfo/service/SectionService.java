package me.zhengjie.modules.basicInfo.service;

import me.zhengjie.modules.basicInfo.domain.Section;
import me.zhengjie.modules.basicInfo.service.dto.SectionDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-03-29
 */
@CacheConfig(cacheNames = "section")
public interface SectionService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    SectionDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    SectionDTO create(Section resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Section resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
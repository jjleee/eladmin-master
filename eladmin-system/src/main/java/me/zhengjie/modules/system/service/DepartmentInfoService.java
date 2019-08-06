package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.domain.DepartmentInfo;
import me.zhengjie.modules.system.service.dto.DepartmentInfoDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-03-28
 */
@CacheConfig(cacheNames = "departmentInfo")
public interface DepartmentInfoService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    DepartmentInfoDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    DepartmentInfoDTO create(DepartmentInfo resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(DepartmentInfo resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
package me.zhengjie.modules.basicInfo.service;

import me.zhengjie.modules.basicInfo.domain.MachineType;
import me.zhengjie.modules.basicInfo.service.dto.MachineTypeDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-03-29
 */
@CacheConfig(cacheNames = "machineType")
public interface MachineTypeService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    MachineTypeDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    MachineTypeDTO create(MachineType resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(MachineType resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
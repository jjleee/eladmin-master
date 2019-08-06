package me.zhengjie.modules.basicInfo.service;

import me.zhengjie.modules.basicInfo.domain.MachineInfo;
import me.zhengjie.modules.basicInfo.service.dto.MachineInfoDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-03-29
 */
@CacheConfig(cacheNames = "machineInfo")
public interface MachineInfoService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    MachineInfoDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    MachineInfoDTO create(MachineInfo resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(MachineInfo resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
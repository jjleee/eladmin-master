package me.zhengjie.modules.basicInfo.service;

import me.zhengjie.modules.basicInfo.domain.BatteryType;
import me.zhengjie.modules.basicInfo.service.dto.BatteryTypeDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-03-29
 */
@CacheConfig(cacheNames = "batteryType")
public interface BatteryTypeService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    BatteryTypeDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    BatteryTypeDTO create(BatteryType resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(BatteryType resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
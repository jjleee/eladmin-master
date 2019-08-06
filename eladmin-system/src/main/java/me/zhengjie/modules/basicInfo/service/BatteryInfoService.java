package me.zhengjie.modules.basicInfo.service;

import me.zhengjie.modules.basicInfo.domain.BatteryInfo;
import me.zhengjie.modules.basicInfo.service.dto.BatteryInfoDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-01
 */
@CacheConfig(cacheNames = "batteryInfo")
public interface BatteryInfoService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    BatteryInfoDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    BatteryInfoDTO create(BatteryInfo resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(BatteryInfoDTO resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
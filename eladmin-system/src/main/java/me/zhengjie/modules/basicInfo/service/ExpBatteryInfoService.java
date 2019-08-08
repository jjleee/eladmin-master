package me.zhengjie.modules.basicInfo.service;

import me.zhengjie.modules.basicInfo.domain.ExpBatteryInfo;
import me.zhengjie.modules.basicInfo.service.dto.ExpBatteryInfoDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-01
 */
@CacheConfig(cacheNames = "expBatteryInfo")
public interface ExpBatteryInfoService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    ExpBatteryInfoDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    ExpBatteryInfoDTO create(ExpBatteryInfo resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(ExpBatteryInfoDTO resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
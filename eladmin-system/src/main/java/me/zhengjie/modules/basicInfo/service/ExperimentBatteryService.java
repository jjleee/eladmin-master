package me.zhengjie.modules.basicInfo.service;

import me.zhengjie.modules.basicInfo.domain.ExperimentBattery;
import me.zhengjie.modules.basicInfo.service.dto.ExperimentBatteryDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
* @author jie
* @date 2019-08-02
*/
@CacheConfig(cacheNames = "experimentBattery")
public interface ExperimentBatteryService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    ExperimentBatteryDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    ExperimentBatteryDTO create(ExperimentBattery resources);

    /**
     * createExcel
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    void createExcel(String[] resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(ExperimentBattery resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
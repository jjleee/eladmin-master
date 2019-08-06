package me.zhengjie.modules.warning.service;

import me.zhengjie.modules.warning.domain.PowerWarning;
import me.zhengjie.modules.warning.service.dto.PowerWarningDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
* @author jie
* @date 2019-07-23
*/
@CacheConfig(cacheNames = "powerWarning")
public interface PowerWarningService {

    /**
     * findById
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    PowerWarningDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    PowerWarningDTO create(PowerWarning resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(PowerWarning resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
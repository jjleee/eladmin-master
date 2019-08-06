package me.zhengjie.modules.rules.service;

import me.zhengjie.modules.rules.domain.NgRule;
import me.zhengjie.modules.rules.service.dto.NgRuleDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-09
 */
@CacheConfig(cacheNames = "ngRule")
public interface NgRuleService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    NgRuleDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    NgRuleDTO create(NgRule resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(NgRule resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
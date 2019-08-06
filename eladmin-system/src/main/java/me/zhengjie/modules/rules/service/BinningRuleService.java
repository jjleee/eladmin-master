package me.zhengjie.modules.rules.service;

import me.zhengjie.modules.rules.domain.BinningRule;
import me.zhengjie.modules.rules.service.dto.BinningRuleDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-09
 */
@CacheConfig(cacheNames = "binningRule")
public interface BinningRuleService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    BinningRuleDTO findById(Long id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    BinningRuleDTO create(BinningRule resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(BinningRule resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);
}
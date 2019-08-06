package me.zhengjie.modules.process.service;

import me.zhengjie.modules.process.domain.WorkStepInfo;
import me.zhengjie.modules.process.service.dto.WorkStepInfoDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author jie
 * @date 2019-04-03
 */
@CacheConfig(cacheNames = "workStepInfo")
public interface WorkStepInfoService {

    /**
     * findById
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    WorkStepInfoDTO findById(String id);

    /**
     * create
     *
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    WorkStepInfoDTO create(WorkStepInfo resources);

    /**
     * update
     *
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(WorkStepInfo resources);

    /**
     * delete
     *
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(String id);
}
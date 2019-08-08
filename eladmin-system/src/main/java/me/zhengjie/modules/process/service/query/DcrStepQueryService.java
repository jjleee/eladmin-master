package me.zhengjie.modules.process.service.query;

import me.zhengjie.modules.process.repository.DcrStepRepository;
import me.zhengjie.modules.process.service.mapper.DcrStepMapper;
import me.zhengjie.modules.system.domain.Permission;
import me.zhengjie.modules.system.repository.PermissionRepository;
import me.zhengjie.modules.system.service.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "dcrStep")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DcrStepQueryService {

    @Autowired
    private DcrStepRepository dcrStepRepository;

    @Autowired
    private DcrStepMapper dcrStepMapper;


}

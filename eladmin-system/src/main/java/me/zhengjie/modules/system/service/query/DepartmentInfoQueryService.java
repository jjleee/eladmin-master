package me.zhengjie.modules.system.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.system.domain.DepartmentInfo;
import me.zhengjie.modules.system.service.dto.DepartmentInfoDTO;
import me.zhengjie.modules.system.repository.DepartmentInfoRepository;
import me.zhengjie.modules.system.service.mapper.DepartmentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@CacheConfig(cacheNames = "departmentInfo")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DepartmentInfoQueryService {

    @Autowired
    private DepartmentInfoRepository departmentInfoRepository;

    @Autowired
    private DepartmentInfoMapper departmentInfoMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(DepartmentInfoDTO departmentInfo, Pageable pageable) {
        Page<DepartmentInfo> page = departmentInfoRepository.findAll(new Spec(departmentInfo), pageable);
        return PageUtil.toPage(page.map(departmentInfoMapper::toDto));
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(DepartmentInfoDTO departmentInfo) {
        return departmentInfoMapper.toDto(departmentInfoRepository.findAll(new Spec(departmentInfo)));
    }

    class Spec implements Specification<DepartmentInfo> {

        private DepartmentInfoDTO departmentInfo;

        public Spec(DepartmentInfoDTO departmentInfo) {
            this.departmentInfo = departmentInfo;
        }

        @Override
        public Predicate toPredicate(Root<DepartmentInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(departmentInfo.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + departmentInfo.getName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
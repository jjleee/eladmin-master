package me.zhengjie.modules.process.service.query;

import me.zhengjie.modules.process.domain.GlobalProtectParam;
import me.zhengjie.modules.process.repository.GlobalProtectParamRepository;
import me.zhengjie.modules.process.service.dto.GlobalProtectParamDTO;
import me.zhengjie.modules.process.service.mapper.GlobalProtectParamMapper;
import me.zhengjie.utils.PageUtil;
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
import java.util.stream.Collectors;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "globalProtectParam")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class GlobalProtectParamQueryService {

    @Autowired
    private GlobalProtectParamRepository globalProtectParamRepository;

    @Autowired
    private GlobalProtectParamMapper globalProtectParamMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(GlobalProtectParamDTO globalProtectParam, Pageable pageable) {
        Page<GlobalProtectParam> page = globalProtectParamRepository.findAll(new Spec(globalProtectParam), pageable);
        return PageUtil.toPage(page.map(globalProtectParamMapper::toDto));
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(GlobalProtectParamDTO globalProtectParam) {
        return globalProtectParamMapper.toDto(globalProtectParamRepository.findAll(new Spec(globalProtectParam)));
    }

    class Spec implements Specification<GlobalProtectParam> {

        private GlobalProtectParamDTO globalProtectParam;

        public Spec(GlobalProtectParamDTO globalProtectParam) {
            this.globalProtectParam = globalProtectParam;
        }

        @Override
        public Predicate toPredicate(Root<GlobalProtectParam> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(globalProtectParam.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + globalProtectParam.getName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }

    /**
     * 查询所有名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<GlobalProtectParam> all = globalProtectParamRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }
}
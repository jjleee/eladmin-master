package me.zhengjie.modules.rules.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.rules.domain.NgRule;
import me.zhengjie.modules.rules.service.dto.NgRuleDTO;
import me.zhengjie.modules.rules.repository.NgRuleRepository;
import me.zhengjie.modules.rules.service.mapper.NgRuleMapper;
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
@CacheConfig(cacheNames = "ngRule")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class NgRuleQueryService {

    @Autowired
    private NgRuleRepository ngRuleRepository;

    @Autowired
    private NgRuleMapper ngRuleMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(NgRuleDTO ngRule, Pageable pageable) {
        Page<NgRule> page = ngRuleRepository.findAll(new Spec(ngRule), pageable);
        return PageUtil.toPage(page.map(ngRuleMapper::toDto));
    }

    /**
     * 查询所有名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<NgRule> all = ngRuleRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(NgRuleDTO ngRule) {
        return ngRuleMapper.toDto(ngRuleRepository.findAll(new Spec(ngRule)));
    }

    class Spec implements Specification<NgRule> {

        private NgRuleDTO ngRule;

        public Spec(NgRuleDTO ngRule) {
            this.ngRule = ngRule;
        }

        @Override
        public Predicate toPredicate(Root<NgRule> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(ngRule.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + ngRule.getName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
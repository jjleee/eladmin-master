package me.zhengjie.modules.rules.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.rules.domain.BinningRule;
import me.zhengjie.modules.rules.service.dto.BinningRuleDTO;
import me.zhengjie.modules.rules.repository.BinningRuleRepository;
import me.zhengjie.modules.rules.service.mapper.BinningRuleMapper;
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
@CacheConfig(cacheNames = "binningRule")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BinningRuleQueryService {

    @Autowired
    private BinningRuleRepository binningRuleRepository;

    @Autowired
    private BinningRuleMapper binningRuleMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(BinningRuleDTO binningRule, Pageable pageable) {
        Page<BinningRule> page = binningRuleRepository.findAll(new Spec(binningRule), pageable);
        return PageUtil.toPage(page.map(binningRuleMapper::toDto));
    }
    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(BinningRuleDTO binningRule) {
        return binningRuleMapper.toDto(binningRuleRepository.findAll(new Spec(binningRule)));
    }

    class Spec implements Specification<BinningRule> {

        private BinningRuleDTO binningRule;

        public Spec(BinningRuleDTO binningRule) {
            this.binningRule = binningRule;
        }

        @Override
        public Predicate toPredicate(Root<BinningRule> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
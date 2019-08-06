package me.zhengjie.modules.data.service.query;

import me.zhengjie.modules.data.domain.CutoffData;
import me.zhengjie.modules.data.repository.CutoffDataRepository;
import me.zhengjie.modules.data.service.dto.CutoffDataDTO;
import me.zhengjie.modules.data.service.mapper.CutoffDataMapper;
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

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "cutoffData")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CutoffDataQueryService {

    @Autowired
    private CutoffDataRepository cutoffDataRepository;

    @Autowired
    private CutoffDataMapper cutoffDataMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(CutoffDataDTO cutoffData, Pageable pageable) {
        Page<CutoffData> page = cutoffDataRepository.findAll(new Spec(cutoffData), pageable);
        return PageUtil.toPage(page.map(cutoffDataMapper::toDto));
    }
    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(CutoffDataDTO cutoffData) {
        return cutoffDataMapper.toDto(cutoffDataRepository.findAll(new Spec(cutoffData)));
    }

    class Spec implements Specification<CutoffData> {

        private CutoffDataDTO cutoffData;

        public Spec(CutoffDataDTO cutoffData) {
            this.cutoffData = cutoffData;
        }

        @Override
        public Predicate toPredicate(Root<CutoffData> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();
            if (!ObjectUtils.isEmpty(cutoffData.getLineName())) {
                list.add(cb.equal(root.get("lineName").as(String.class),cutoffData.getLineName()));
            }
            if (!ObjectUtils.isEmpty(cutoffData.getCabinetNo())) {
                list.add(cb.equal(root.get("cabinetNo").as(Integer.class),cutoffData.getCabinetNo()));
            }
            if (!ObjectUtils.isEmpty(cutoffData.getCellNo())) {
                list.add(cb.equal(root.get("cellNo").as(String.class),cutoffData.getCellNo()));
            }
            if (!ObjectUtils.isEmpty(cutoffData.getChannel())) {
                list.add(cb.equal(root.get("channel").as(String.class),cutoffData.getChannel()));
            }
            if (!ObjectUtils.isEmpty(cutoffData.getStepName())) {
                list.add(cb.equal(root.get("stepName").as(String.class),cutoffData.getStepName()));
            }
            if (!ObjectUtils.isEmpty(cutoffData.getStepName())) {
                list.add(cb.equal(root.get("stepName").as(String.class),cutoffData.getStepName()));
            }
            if (!ObjectUtils.isEmpty(cutoffData.getStepNo())) {
                list.add(cb.equal(root.get("stepNo").as(Integer.class),cutoffData.getStepNo()));
            }
            if (!ObjectUtils.isEmpty(cutoffData.getTime1())&&!ObjectUtils.isEmpty(cutoffData.getTime2())) {
                list.add(cb.between(root.get("recordTime").as(String.class),cutoffData.getTime1(),cutoffData.getTime2()));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
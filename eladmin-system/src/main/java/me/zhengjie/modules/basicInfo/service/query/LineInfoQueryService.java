package me.zhengjie.modules.basicInfo.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.basicInfo.domain.LineInfo;
import me.zhengjie.modules.basicInfo.service.dto.LineInfoDTO;
import me.zhengjie.modules.basicInfo.repository.LineInfoRepository;
import me.zhengjie.modules.basicInfo.service.mapper.LineInfoMapper;
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
@CacheConfig(cacheNames = "lineInfo")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LineInfoQueryService {

    @Autowired
    private LineInfoRepository lineInfoRepository;

    @Autowired
    private LineInfoMapper lineInfoMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(LineInfoDTO lineInfo, Pageable pageable) {
        Page<LineInfo> page = lineInfoRepository.findAll(new Spec(lineInfo), pageable);
        return PageUtil.toPage(page.map(lineInfoMapper::toDto));
    }

    /**
     * 查询所有名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<LineInfo> all = lineInfoRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(LineInfoDTO lineInfo) {
        return lineInfoMapper.toDto(lineInfoRepository.findAll(new Spec(lineInfo)));
    }

    class Spec implements Specification<LineInfo> {

        private LineInfoDTO lineInfo;

        public Spec(LineInfoDTO lineInfo) {
            this.lineInfo = lineInfo;
        }

        @Override
        public Predicate toPredicate(Root<LineInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(lineInfo.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + lineInfo.getName() + "%"));
            }
            if (!ObjectUtils.isEmpty(lineInfo.getLineTypeName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("line_type_name").as(String.class), "%" + lineInfo.getLineTypeName() + "%"));
            }
            if (!ObjectUtils.isEmpty(lineInfo.getFactoryName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("factory_name").as(String.class), "%" + lineInfo.getFactoryName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
package me.zhengjie.modules.basicInfo.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.basicInfo.domain.LineType;
import me.zhengjie.modules.basicInfo.service.dto.LineTypeDTO;
import me.zhengjie.modules.basicInfo.repository.LineTypeRepository;
import me.zhengjie.modules.basicInfo.service.mapper.LineTypeMapper;
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
@CacheConfig(cacheNames = "lineType")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LineTypeQueryService {

    @Autowired
    private LineTypeRepository lineTypeRepository;

    @Autowired
    private LineTypeMapper lineTypeMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(LineTypeDTO lineType, Pageable pageable) {
        Page<LineType> page = lineTypeRepository.findAll(new Spec(lineType), pageable);
        return PageUtil.toPage(page.map(lineTypeMapper::toDto));
    }

    /**
     * 查询所有产线类型名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<LineType> all = lineTypeRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(LineTypeDTO lineType) {
        return lineTypeMapper.toDto(lineTypeRepository.findAll(new Spec(lineType)));
    }

    class Spec implements Specification<LineType> {

        private LineTypeDTO lineType;

        public Spec(LineTypeDTO lineType) {
            this.lineType = lineType;
        }

        @Override
        public Predicate toPredicate(Root<LineType> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(lineType.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + lineType.getName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
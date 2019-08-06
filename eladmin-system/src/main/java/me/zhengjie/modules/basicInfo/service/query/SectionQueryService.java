package me.zhengjie.modules.basicInfo.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.basicInfo.domain.Section;
import me.zhengjie.modules.basicInfo.service.dto.SectionDTO;
import me.zhengjie.modules.basicInfo.repository.SectionRepository;
import me.zhengjie.modules.basicInfo.service.mapper.SectionMapper;
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
@CacheConfig(cacheNames = "section")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SectionQueryService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private SectionMapper sectionMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(SectionDTO section, Pageable pageable) {
        Page<Section> page = sectionRepository.findAll(new Spec(section), pageable);
        return PageUtil.toPage(page.map(sectionMapper::toDto));
    }

    /**
     * 查询所有名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<Section> all = sectionRepository.findAll();
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(SectionDTO section) {
        return sectionMapper.toDto(sectionRepository.findAll(new Spec(section)));
    }

    class Spec implements Specification<Section> {

        private SectionDTO section;

        public Spec(SectionDTO section) {
            this.section = section;
        }

        @Override
        public Predicate toPredicate(Root<Section> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(section.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + section.getName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
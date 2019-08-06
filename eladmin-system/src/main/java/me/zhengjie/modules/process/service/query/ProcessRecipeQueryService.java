package me.zhengjie.modules.process.service.query;

import me.zhengjie.modules.process.domain.ProcessItem;
import me.zhengjie.modules.process.repository.ProcessItemRepository;
import me.zhengjie.modules.process.service.dto.FormationRecipeDTO;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.process.domain.ProcessRecipe;
import me.zhengjie.modules.process.service.dto.ProcessRecipeDTO;
import me.zhengjie.modules.process.repository.ProcessRecipeRepository;
import me.zhengjie.modules.process.service.mapper.ProcessRecipeMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "processRecipe")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProcessRecipeQueryService {

    @Autowired
    private ProcessRecipeRepository processRecipeRepository;

    @Autowired
    private ProcessRecipeMapper processRecipeMapper;

    @Autowired
    private ProcessItemRepository processItemRepository;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ProcessRecipeDTO processRecipe, Pageable pageable) {
        Page<ProcessRecipe> page = processRecipeRepository.findAll(new Spec(processRecipe), pageable);
        return PageUtil.toPage(page.map(processRecipeMapper::toDto));
    }


    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllPlus(ProcessRecipeDTO processRecipe, Pageable pageable) {
        Page<ProcessRecipe> page = processRecipeRepository.findAll(new Spec(processRecipe), pageable);
        List<ProcessRecipeDTO> dtos = new ArrayList<>();
        for (Iterator<ProcessRecipe> iterator = page.iterator(); iterator.hasNext(); ) {
            ProcessRecipe next = iterator.next();
            if (next.getValid()) {
                ProcessRecipeDTO processRecipeDTO = new ProcessRecipeDTO();
                BeanUtils.copyProperties(next, processRecipeDTO);
                List<ProcessItem> byProcessId = processItemRepository.findByProcessId(next.getId());
                processRecipeDTO.setProcessItems(byProcessId);
                dtos.add(processRecipeDTO);
            }
        }
        Page<ProcessRecipeDTO> dtoPage = new PageImpl(dtos, pageable, dtos.size());
        return PageUtil.toPage(dtoPage);
    }

    /**
     * 查询所有名称
     *
     * @return
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAllName() {
        List<ProcessRecipe> all = processRecipeRepository.findAllByValid(true);
        List<String> allName = all.stream().map(e -> e.getName()).collect(Collectors.toList());
        return allName;
    }

    /**
     * 不分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(ProcessRecipeDTO processRecipe) {
        return processRecipeMapper.toDto(processRecipeRepository.findAll(new Spec(processRecipe)));
    }

    class Spec implements Specification<ProcessRecipe> {

        private ProcessRecipeDTO processRecipe;

        public Spec(ProcessRecipeDTO processRecipe) {
            this.processRecipe = processRecipe;
        }

        @Override
        public Predicate toPredicate(Root<ProcessRecipe> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

            if (!ObjectUtils.isEmpty(processRecipe.getName())) {
                /**
                 * 模糊
                 */
                list.add(cb.like(root.get("name").as(String.class), "%" + processRecipe.getName() + "%"));
            }
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    }
}
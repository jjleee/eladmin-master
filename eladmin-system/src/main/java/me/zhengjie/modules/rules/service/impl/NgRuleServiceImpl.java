package me.zhengjie.modules.rules.service.impl;

import me.zhengjie.modules.rules.domain.NgRule;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.rules.repository.NgRuleRepository;
import me.zhengjie.modules.rules.service.NgRuleService;
import me.zhengjie.modules.rules.service.dto.NgRuleDTO;
import me.zhengjie.modules.rules.service.mapper.NgRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-04-09
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class NgRuleServiceImpl implements NgRuleService {

    @Autowired
    private NgRuleRepository ngRuleRepository;

    @Autowired
    private NgRuleMapper ngRuleMapper;

    @Override
    public NgRuleDTO findById(Long id) {
        Optional<NgRule> ngRule = ngRuleRepository.findById(id);
        ValidationUtil.isNull(ngRule, "NgRule", "id", id);
        return ngRuleMapper.toDto(ngRule.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public NgRuleDTO create(NgRule resources) {
        return ngRuleMapper.toDto(ngRuleRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(NgRule resources) {
        Optional<NgRule> optionalNgRule = ngRuleRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalNgRule, "NgRule", "id", resources.getId());

        NgRule ngRule = optionalNgRule.get();
        // 此处需自己修改
        resources.setId(ngRule.getId());
        ngRuleRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        ngRuleRepository.deleteById(id);
    }
}
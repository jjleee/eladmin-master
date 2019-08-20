package me.zhengjie.modules.rules.service.impl;

import me.zhengjie.modules.rules.domain.BinningRule;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.rules.repository.BinningRuleRepository;
import me.zhengjie.modules.rules.service.BinningRuleService;
import me.zhengjie.modules.rules.service.dto.BinningRuleDTO;
import me.zhengjie.modules.rules.service.mapper.BinningRuleMapper;
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
public class BinningRuleServiceImpl implements BinningRuleService {

    @Autowired
    private BinningRuleRepository binningRuleRepository;

    @Autowired
    private BinningRuleMapper binningRuleMapper;

    @Override
    public BinningRuleDTO findById(Long id) {
        Optional<BinningRule> binningRule = binningRuleRepository.findById(id);
        ValidationUtil.isNull(binningRule, "BinningRule", "id", id);
        return binningRuleMapper.toDto(binningRule.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BinningRuleDTO create(BinningRule resources) {
        return binningRuleMapper.toDto(binningRuleRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(BinningRule resources) {
        Optional<BinningRule> optionalBinningRule = binningRuleRepository.findById(resources.getRuleId());
        ValidationUtil.isNull(optionalBinningRule, "BinningRule", "id", resources.getRuleId());

        BinningRule binningRule = optionalBinningRule.get();
        // 此处需自己修改
        resources.setRuleId(binningRule.getRuleId());
        binningRuleRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        binningRuleRepository.deleteById(id);
    }
}
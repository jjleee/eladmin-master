package me.zhengjie.modules.rules.service.impl;

import me.zhengjie.modules.rules.domain.BinningPlan;
import me.zhengjie.modules.rules.repository.BinningPlanRepository;
import me.zhengjie.modules.rules.service.BinningPlanService;
import me.zhengjie.modules.rules.service.BinningPlanService;
import me.zhengjie.modules.rules.service.dto.BinningPlanDTO;
import me.zhengjie.modules.rules.service.mapper.BinningPlanMapper;
import me.zhengjie.utils.ValidationUtil;
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
public class BinningPlanServiceImpl implements BinningPlanService {

    @Autowired
    private BinningPlanRepository binningPlanRepository;

    @Autowired
    private BinningPlanMapper binningPlanMapper;

    @Override
    public BinningPlanDTO findById(Long id) {
        Optional<BinningPlan> binningPlan = binningPlanRepository.findById(id);
        ValidationUtil.isNull(binningPlan, "BinningPlan", "id", id);
        return binningPlanMapper.toDto(binningPlan.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BinningPlanDTO create(BinningPlan resources) {
        return binningPlanMapper.toDto(binningPlanRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(BinningPlan resources) {
        Optional<BinningPlan> optionalBinningPlan = binningPlanRepository.findById(resources.getPlanId());
        ValidationUtil.isNull(optionalBinningPlan, "BinningPlan", "planId", resources.getPlanId());

        BinningPlan binningPlan = optionalBinningPlan.get();
        // 此处需自己修改
        resources.setPlanId(binningPlan.getPlanId());
        binningPlanRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        binningPlanRepository.deleteById(id);
    }
}
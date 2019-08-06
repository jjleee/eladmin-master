package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.VacuumPlan;
import me.zhengjie.modules.process.repository.VacuumPlanRepository;
import me.zhengjie.modules.process.service.VacuumPlanService;
import me.zhengjie.modules.process.service.dto.VacuumPlanDTO;
import me.zhengjie.modules.process.service.mapper.VacuumPlanMapper;
import me.zhengjie.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-05-18
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class VacuumPlanServiceImpl implements VacuumPlanService {

    @Autowired
    private VacuumPlanRepository vacuumPlanRepository;

    @Autowired
    private VacuumPlanMapper vacuumPlanMapper;

    @Override
    public VacuumPlanDTO findById(Long id) {
        Optional<VacuumPlan> vacuumPlan = vacuumPlanRepository.findById(id);
        ValidationUtil.isNull(vacuumPlan, "VacuumPlan", "id", id);
        return vacuumPlanMapper.toDto(vacuumPlan.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public VacuumPlanDTO create(VacuumPlan resources) {
        return vacuumPlanMapper.toDto(vacuumPlanRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(VacuumPlan resources) {
        Optional<VacuumPlan> optionalVacuumPlan = vacuumPlanRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalVacuumPlan, "VacuumPlan", "id", resources.getId());

        VacuumPlan vacuumPlan = optionalVacuumPlan.get();
        // 此处需自己修改
        resources.setId(vacuumPlan.getId());
        vacuumPlanRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        vacuumPlanRepository.deleteById(id);
    }
}
package me.zhengjie.modules.process.service.impl;

import me.zhengjie.modules.process.domain.LeakVacuum;
import me.zhengjie.modules.process.domain.VacuumPlan;
import me.zhengjie.modules.process.repository.LeakVacuumRepository;
import me.zhengjie.modules.process.repository.VacuumPlanRepository;
import me.zhengjie.modules.process.service.LeakVacuumService;
import me.zhengjie.modules.process.service.VacuumPlanService;
import me.zhengjie.modules.process.service.dto.LeakVacuumDTO;
import me.zhengjie.modules.process.service.dto.VacuumPlanDTO;
import me.zhengjie.modules.process.service.mapper.LeakVacuumMapper;
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
public class LeakVacuumServiceImpl implements LeakVacuumService {

    @Autowired
    private LeakVacuumRepository leakVacuumRepository;

    @Autowired
    private LeakVacuumMapper leakVacuumMapper;

    @Override
    public LeakVacuumDTO findById(Long id) {
        Optional<LeakVacuum> leakVacuum = leakVacuumRepository.findById(id);
        ValidationUtil.isNull(leakVacuum, "LeakVacuum", "id", id);
        return leakVacuumMapper.toDto(leakVacuum.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeakVacuumDTO create(LeakVacuum resources) {
        return leakVacuumMapper.toDto(leakVacuumRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LeakVacuum resources) {
        Optional<LeakVacuum> optionalLeakVacuum = leakVacuumRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalLeakVacuum, "LeakVacuum", "id", resources.getId());

        LeakVacuum leakVacuum = optionalLeakVacuum.get();
        // 此处需自己修改
        resources.setId(leakVacuum.getId());
        leakVacuumRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        leakVacuumRepository.deleteById(id);
    }
}
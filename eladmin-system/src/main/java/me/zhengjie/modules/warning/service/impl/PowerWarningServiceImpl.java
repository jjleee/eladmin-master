package me.zhengjie.modules.warning.service.impl;

import me.zhengjie.modules.warning.domain.PowerWarning;
import me.zhengjie.modules.warning.repository.PowerWarningRepository;
import me.zhengjie.modules.warning.service.PowerWarningService;
import me.zhengjie.modules.warning.service.dto.PowerWarningDTO;
import me.zhengjie.modules.warning.service.mapper.PowerWarningMapper;
import me.zhengjie.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
* @author jie
* @date 2019-07-23
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PowerWarningServiceImpl implements PowerWarningService {

    @Autowired
    private PowerWarningRepository powerWarningRepository;

    @Autowired
    private PowerWarningMapper powerWarningMapper;

    @Override
    public PowerWarningDTO findById(Long id) {
        Optional<PowerWarning> powerWarning = powerWarningRepository.findById(id);
        ValidationUtil.isNull(powerWarning,"PowerWarning","id",id);
        return powerWarningMapper.toDto(powerWarning.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PowerWarningDTO create(PowerWarning resources) {
        return powerWarningMapper.toDto(powerWarningRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PowerWarning resources) {
        Optional<PowerWarning> optionalPowerWarning = powerWarningRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalPowerWarning,"PowerWarning","id",resources.getId());

        PowerWarning powerWarning = optionalPowerWarning.get();
        // 此处需自己修改
        resources.setId(powerWarning.getId());
        powerWarningRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        powerWarningRepository.deleteById(id);
    }
}
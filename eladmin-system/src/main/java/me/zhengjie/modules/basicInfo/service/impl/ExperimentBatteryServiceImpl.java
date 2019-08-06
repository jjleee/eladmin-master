package me.zhengjie.modules.basicInfo.service.impl;

import me.zhengjie.modules.basicInfo.domain.ExperimentBattery;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.basicInfo.repository.ExperimentBatteryRepository;
import me.zhengjie.modules.basicInfo.service.ExperimentBatteryService;
import me.zhengjie.modules.basicInfo.service.dto.ExperimentBatteryDTO;
import me.zhengjie.modules.basicInfo.service.mapper.ExperimentBatteryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

/**
* @author jie
* @date 2019-08-02
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ExperimentBatteryServiceImpl implements ExperimentBatteryService {

    @Autowired
    private ExperimentBatteryRepository experimentBatteryRepository;

    @Autowired
    private ExperimentBatteryMapper experimentBatteryMapper;

    @Override
    public ExperimentBatteryDTO findById(Long id) {
        Optional<ExperimentBattery> experimentBattery = experimentBatteryRepository.findById(id);
        ValidationUtil.isNull(experimentBattery,"ExperimentBattery","id",id);
        return experimentBatteryMapper.toDto(experimentBattery.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ExperimentBatteryDTO create(ExperimentBattery resources) {
        return experimentBatteryMapper.toDto(experimentBatteryRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createExcel(String[] resources) {
        for (String batteryNumber:resources){
            ExperimentBattery experimentBattery=new ExperimentBattery();
            experimentBattery.setBatteryNumber(batteryNumber);
            experimentBatteryRepository.save(experimentBattery);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ExperimentBattery resources) {
        Optional<ExperimentBattery> optionalExperimentBattery = experimentBatteryRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalExperimentBattery,"ExperimentBattery","id",resources.getId());

        ExperimentBattery experimentBattery = optionalExperimentBattery.get();
        // 此处需自己修改
        resources.setId(experimentBattery.getId());
        experimentBatteryRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        experimentBatteryRepository.deleteById(id);
    }
}
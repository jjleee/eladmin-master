package me.zhengjie.modules.basicInfo.repository;

import me.zhengjie.modules.basicInfo.domain.ExperimentBattery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author jie
* @date 2019-08-02
*/
public interface ExperimentBatteryRepository extends JpaRepository<ExperimentBattery, Long>, JpaSpecificationExecutor {
}
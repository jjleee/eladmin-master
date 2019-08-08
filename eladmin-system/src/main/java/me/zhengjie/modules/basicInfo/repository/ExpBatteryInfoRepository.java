package me.zhengjie.modules.basicInfo.repository;

import me.zhengjie.modules.basicInfo.domain.ExpBatteryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-04-01
 */
public interface ExpBatteryInfoRepository extends JpaRepository<ExpBatteryInfo, Long>, JpaSpecificationExecutor {
}
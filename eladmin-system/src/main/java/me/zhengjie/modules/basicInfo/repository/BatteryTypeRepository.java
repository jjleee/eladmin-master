package me.zhengjie.modules.basicInfo.repository;

import me.zhengjie.modules.basicInfo.domain.BatteryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-03-29
 */
public interface BatteryTypeRepository extends JpaRepository<BatteryType, Long>, JpaSpecificationExecutor {
}
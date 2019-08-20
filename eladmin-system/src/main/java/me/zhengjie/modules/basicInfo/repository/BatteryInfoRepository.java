package me.zhengjie.modules.basicInfo.repository;

import me.zhengjie.modules.basicInfo.domain.BatteryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-04-01
 */
public interface BatteryInfoRepository extends JpaRepository<BatteryInfo, Long>, JpaSpecificationExecutor {

    /**
     * 根据型号查找
     * @param number
     * @return
     */
    BatteryInfo findByNumber(String number);
}
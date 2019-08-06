package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.VacuumPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-05-18
 */
public interface VacuumPlanRepository extends JpaRepository<VacuumPlan, Long>, JpaSpecificationExecutor {
}
package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.LeakVacuum;
import me.zhengjie.modules.process.domain.VacuumPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-05-18
 */
public interface LeakVacuumRepository extends JpaRepository<LeakVacuum, Long>, JpaSpecificationExecutor {
}
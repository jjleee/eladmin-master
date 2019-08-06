package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.DepartmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-03-28
 */
public interface DepartmentInfoRepository extends JpaRepository<DepartmentInfo, Long>, JpaSpecificationExecutor {
}
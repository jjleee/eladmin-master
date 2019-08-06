package me.zhengjie.modules.warning.repository;

import me.zhengjie.modules.warning.domain.PowerWarning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author jie
* @date 2019-07-23
*/
public interface PowerWarningRepository extends JpaRepository<PowerWarning, Long>, JpaSpecificationExecutor {
}
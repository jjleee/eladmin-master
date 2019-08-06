package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.GlobalProtectParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-04-25
 */
public interface GlobalProtectParamRepository extends JpaRepository<GlobalProtectParam, Long>, JpaSpecificationExecutor {
}
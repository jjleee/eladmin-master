package me.zhengjie.modules.basicInfo.repository;

import me.zhengjie.modules.basicInfo.domain.LineInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-04-10
 */
public interface LineInfoRepository extends JpaRepository<LineInfo, Long>, JpaSpecificationExecutor {
}
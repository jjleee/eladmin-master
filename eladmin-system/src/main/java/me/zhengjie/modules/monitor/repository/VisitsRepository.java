package me.zhengjie.modules.monitor.repository;

import me.zhengjie.modules.monitor.domain.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jie
 * @date 2018-12-13
 */
@Repository
public interface VisitsRepository extends JpaRepository<Visits, Long> {

    /**
     * findByDate
     *
     * @param date
     * @return
     */
    Visits findByDate(String date);

    /**
     * 获得一个时间段的记录
     *
     * @param date1
     * @param date2
     * @return
     */
    @Query(value = "select * FROM visits where " +
            "create_time between to_date(?1,'yyyy-MM-dd') and to_date(?2,'yyyy-MM-dd')", nativeQuery = true)
    List<Visits> findAllVisits(String date1, String date2);
}

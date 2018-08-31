package com.iot.officalsite.repository;

import com.iot.officalsite.entity.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 李攀 on 2018/1/13.
 */
@Repository
public interface DateRepository extends JpaRepository<Date, Long> {

    @Query("select date.start_match_time from Date date where date.id=?1")
    String findStartMatchDate(Integer id);

    @Query("select date.end_match_time from Date date where date.id=?1")
    String findEndMatchDate(Integer id);

    @Query("select date.start_join_time from Date date where date.id=?1")
    String findStartJoinDate(Integer id);

    @Query("select date.end_join_time from Date date where date.id=?1")
    String findEndJoinDate(Integer id);

    @Modifying
    @Transactional
    @Query("update Date date set date.start_match_time=?1, date.end_match_time=?2 where date.id=?3")
    void setMatchDate(String start_time, String end_time, Integer id);

    @Modifying
    @Transactional
    @Query("update Date date set date.start_join_time=?1, date.end_join_time=?2 where date.id=?3")
    void setJoinDate(String start_time, String end_time, Integer id);
}

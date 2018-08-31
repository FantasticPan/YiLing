package com.iot.officalsite.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 李攀 on 2018/1/13.
 */
@Entity
@Getter
@Setter
@Table(name = "date")
public class Date {

    @Id
    @GeneratedValue
    private Integer id;

    private String start_match_time;
    private String end_match_time;
    private String start_join_time;
    private String end_join_time;
}

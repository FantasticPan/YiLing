package com.iot.officalsite.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by 李攀 on 2017/12/3.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String mark;

    public Role(String name, String mark) {
        this.name = name;
        this.mark = mark;
    }

    public Role() {
    }
}

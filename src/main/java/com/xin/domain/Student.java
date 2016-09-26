package com.xin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

/**
 * Created by CHENXINXIN on 2016/7/4.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private int id;
    private String name;
    private String pwd;
    private int number;
    private Boolean isStudent;
}

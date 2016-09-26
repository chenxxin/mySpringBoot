package com.xin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by CHENXINXIN on 2016/6/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private String firstName;
    private int age;
    private String sex;
}

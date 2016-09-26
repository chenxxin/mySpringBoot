package com.xin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by CHENXINXIN on 2016/6/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = -5486594966231379046L;
    private String firstName;
    private String lastName;
    private int age;
    private String sex;
}

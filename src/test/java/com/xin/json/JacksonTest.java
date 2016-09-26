package com.xin.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.xin.domain.Student;
import org.junit.Test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENXINXIN on 2016/7/4.
 */
public class JacksonTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testJsonToObject() throws Exception {
        //readValue() 将json串转换为 Object对象：实体类、Array数组、List 等

        //json串转换成entity
        String json = "{\"id\":1000,\"name\":\"xiao liao\",\"pwd\":\"123\",\"number\":12.0,\"isStudent\":true}";
        Student student = mapper.readValue(json, Student.class);

        //json串转换成Array数组
        String json2 = "[{\"id\":1,\"name\":\"www\",\"number\":234,\"pwd\":\"456\"},"+
                        "{\"id\":5,\"name\":\"tom\",\"number\":344,\"pwd\":\"123\"}]";
        Student[] students = mapper.readValue(json2, Student[].class);

        //json串转换成List ，但只能是LinkedHashMap类型的
        List<LinkedHashMap<String,Object>> list = mapper.readValue(json2, List.class);

        // 也可以从文件中读取json串，转成其他对象
        File file = new File("D:\\test.txt");
        mapper.readValue(file, Student[].class);
        mapper.readValue(file, Student.class);
        mapper.readValue(file, List.class);
    }

    @Test
    public void testObjectToJson() throws Exception {
        //writeValue() 将Object对象转换为json串，输出到控制台 或 指定文件 或 输出流 等
        //writeValueAsString() 将Object对象转换为json串

        Student student = new Student(1000,"xiao liao","123",12, true); //(uid, uname, pwd, number, isStudent)
        Student student2 = new Student(1001,"xin","456",101, true);

        mapper.writeValue(System.out, student);
        String json = mapper.writeValueAsString(student);

        Student[] students = {student,student2};
        mapper.writeValue(System.out,students);
        mapper.writeValueAsString(students);

        List<Student> list = Lists.newArrayList(student, student2);
        mapper.writeValue(System.out, list);
        mapper.writeValueAsString(list);

        Map<String, Student> map = ImmutableMap.of("1", student, "2", student2);
        mapper.writeValue(System.out,map);
        mapper.writeValueAsString(map);

        // 将对象Object转换成json串，输出到指定文件
        File file = new File("D:\\write.txt");
        mapper.writeValue(file, student);
    }


}

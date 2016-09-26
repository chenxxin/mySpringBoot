package com.xin.json;

//import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by CHENXINXIN on 2016/7/4.
 */
public class JsonPathTest {
    String json;
    @Before
    public void setUp() throws Exception {
        json = "{ \"store\": {\n" +
                "    \"book\": [ \n" +
                "      { \"category\": \"reference\",\n" +
                "        \"author\": \"Nigel Rees\",\n" +
                "        \"title\": \"Sayings of the Century\",\n" +
                "        \"price\": 8.95\n" +
                "      },\n" +
                "      { \"category\": \"fiction\",\n" +
                "        \"author\": \"Evelyn Waugh\",\n" +
                "        \"title\": \"Sword of Honour\",\n" +
                "        \"price\": 12.99,\n" +
                "        \"isbn\": \"0-553-21311-3\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"bicycle\": {\n" +
                "      \"color\": \"red\",\n" +
                "      \"price\": 19.95\n" +
                "    }\n" +
                "  }\n" +
                "}";

    }

    @Test
    public void testJsonPath() throws Exception {
//        String author = JsonPath.read(json,"$.store.book[0].author");
//        System.out.println("author = " + author);

    }
}

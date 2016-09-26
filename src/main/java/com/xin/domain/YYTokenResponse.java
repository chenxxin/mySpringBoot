package com.xin.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "result",
        "result_desc"
})
@AllArgsConstructor
@NoArgsConstructor
public class YYTokenResponse {

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("result")
    private String result;

    @JsonProperty("result_desc")
    private Object resultDesc;
}

/*
@JsonInclude(JsonInclude.Include.NON_NULL)
    将该标记放在属性上，如果该属性为NULL则不参与序列化
    如果放在类上边,那对这个类的全部属性起作用

JsonInclude.Include.Include.ALWAYS 默认
JsonInclude.Include.NON_DEFAULT    属性为默认值不序列化
JsonInclude.Include.USE_DEFAULTS
JsonInclude.Include.NON_EMPTY      属性为 空（“”） 或者为 NULL 都不序列化
JsonInclude.Include.NON_NULL       属性为NULL 不序列化
JsonInclude.Include.NON_ABSENT

 */

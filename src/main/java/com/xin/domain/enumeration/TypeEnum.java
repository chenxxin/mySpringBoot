package com.xin.domain.enumeration;


public enum TypeEnum {
    download("download", 1),
    /**
     * 页面加速
     */
    web("web", 2),
    /**
     * 点播加速
     */
    vod("vod", 3),
    /**
     * 直播加速
     */
    liveVideo("live_video", 4);

    private String value;
    private Integer code;

    TypeEnum(String value, Integer code) {
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public Integer getCode() {
        return code;
    }

    public static TypeEnum getByValue(String enumValue){
        for (TypeEnum em : TypeEnum.values()){
            if (em.getValue().equals(enumValue)){
                return em;
            }
        }
        return null;
    }

    public static TypeEnum getByCode(Integer enumCode){
        for (TypeEnum em : TypeEnum.values()){
            if (em.getCode().equals(enumCode)){
                return em;
            }
        }
        return null;
    }
}

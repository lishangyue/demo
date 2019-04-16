package test;

/**
 * 我的学习枚举
 */
public enum MyStudyEnum {
    DATA_SOURCE_COURSE("0","课程"),
    DATA_SOURCE_CMS_BOOK("1","电子书"),
    DATA_SOURCE_CMS_VIDEO("2","视频"),

    OBLIGATORY_TRUE("1","必学"),
    OBLIGATORY_FALSE("0","不必学"),

    AGGREGATION_TRUE("1","是合集"),
    AGGREGATION_FALSE("0","不是合集"),

    END_TRUE("1","已学完"),
    END_FALSE("0","未学"),
    END_LOAD("2","正在学");

    private String type;
    private String desc;

    MyStudyEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}

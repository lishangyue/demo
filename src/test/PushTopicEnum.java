package test;

public enum PushTopicEnum {
    /**
     * 是否通知完成，不需要持久化
     */
    YES("已推送", false),
    NO("未推送", false),
    /**
     * 是否通知完成，需要持久化
     */
    NO_PUSH("未送达", false),
    YES_READ("已读", false),
    NO_READ("未读", false),
    EXPIRE("过期", false),
    DELETE("删除", false),
    /**
     * 通知主题编码-活动
     */
    TOPIC_CODE_DYDH("党员大会", true),
    TOPIC_CODE_ZBWYH("支部委员会", true),
    TOPIC_CODE_DXZH("党小组会", true),
    TOPIC_CODE_JDK("讲党课", true),
    TOPIC_CODE_ZTDR("主题党日", true),
    TOPIC_CODE_ZZSHH("组织生活会", true),
    TOPIC_CODE_MZSHH("民主生活会", true),
    TOPIC_CODE_QTHD("其他活动", true),
    /**
     * 主题编码-红色分享
     */
    TOPIC_CODE_HSFX("红色分享", false),
    TOPIC_CODE_RS_DISCUSS("红色分享评论", false),
    /**
     * 主题编码-体检
     */
    TOPIC_CODE_TJ("体检", false),
    TOPIC_CODE_DYHZ("党员会诊", true),
    TOPIC_CODE_ZZHZ("组织会诊", false),
    /**
     * 主题编码-转党组织关系
     */
    TOPIC_CODE_ZDZZGX("转党组织关系", false),
    /**
     * 主题编码-学习考试
     */
    TOPIC_CODE_XXKS("学习考试", true),
    /**
     * 主题编码-投票调查
     */
    TOPIC_CODE_TPDC("调查问卷", false),
    /**
     * 课时
     */
    TOPIC_CODE_LESSON("课时提醒", false),
    /**
     * 支付提醒
     */
    TOPIC_CODE_PAY("支付提醒", true),

    TOPIC_CODE_STUDIO_MB("工作室留言提醒", true),
    TOPIC_CODE_STUDIO_APP("工作室预约提醒", true),
    /**
     * 推送类型
     */
    PUSH_TYPE_HOMEPAGE("第三方极光推送", false),
    PUSH_TYPE_REMIND("内部推送", false),

    /**
     * 异常
     */
    ERROR_NO_PUSH_TYPE("通知类型错误", false),
    ERROR_NO_LIST("需通知的人员为空", false),
    ERROR_NO_TITLE("通知的标题为空", false),
    ERROR_NO_CONTENT("通知的内容为空", false);

    private String name;

    private Boolean isPersistent;

    PushTopicEnum(String name, Boolean isPersistent) {
        this.name = name;
        this.isPersistent = isPersistent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPersistent() {
        return isPersistent;
    }

    public void setPersistent(Boolean persistent) {
        isPersistent = persistent;
    }
}

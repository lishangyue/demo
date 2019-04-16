package test;

public class testSwitch {
    public static void main(String[] args) {

        switch (PushTopicEnum.valueOf("TOPIC_CODE_XXKS")) {
            case TOPIC_CODE_XXKS:
                System.out.println("hhhhhhhh");
                break;
            case TOPIC_CODE_DXZH:
                System.out.println("xxxxxxxx");
                break;
            default:
                break;
        }
    }
}

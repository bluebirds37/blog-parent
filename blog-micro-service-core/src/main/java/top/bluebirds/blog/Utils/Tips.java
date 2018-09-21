package top.bluebirds.blog.Utils;
/**
 * @description:
 * @author:         mc
 * @createDate:     2018/6/29 9:03
 * @version:        1.0
 */
public enum Tips {

    FAIL(300,"失败"),
    SUCCESS(200,"成功"),







    ;
    public Integer code;
    public String msg;


    Tips(String msg) {
        /**
         * 消息
         */
        this.msg = msg;
    }

    Tips(Integer code, String msg) {
        /**
         * 状态码
         */
        this.code = code;
        /**
         * 消息
         */
        this.msg = msg;
    }
}

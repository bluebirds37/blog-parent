package top.bluebirds.blog.Utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlipayUtils {

    public static Logger getLogger() {
        return LoggerFactory.getLogger(AlipayUtils.class);
    }

    public static void payTrade() {

        Integer integer = new Integer(new Double(Math.random() * 6).intValue());

        for (int i = 0; i < 6; i++) {
            try {
                getLogger().info("线程名" + Thread.currentThread().getName() + ":正在等待");
                Thread.sleep(5000);
                getLogger().info("线程名" + Thread.currentThread().getName() + ":等待完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i == integer) {
                getLogger().info("线程名" + Thread.currentThread().getName() + ":支付成功");
                return;
            } else {
                getLogger().info("线程名" + Thread.currentThread().getName() + ":正在支付");
            }
        }

    }

}

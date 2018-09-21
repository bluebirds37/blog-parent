public class AlipayUtils {

    public static void payTrade() {

        Integer integer = new Integer(new Double(Math.random() * 1000000).intValue());

        for (int i = 0; i < 1000000; i++) {
            if (i == integer) {
                System.out.println("线程名"+Thread.currentThread().getName()+":支付成功");
                return;
            }else {
                System.out.println("线程名"+Thread.currentThread().getName()+":正在支付");
            }
        }

    }

}

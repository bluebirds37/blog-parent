import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestDemo {

    @Test
    public void test01(){
        AlipayUtils.payTrade();
    }

    @Test
    public void test02(){
        AlipayUtils.payTrade();
    }

}

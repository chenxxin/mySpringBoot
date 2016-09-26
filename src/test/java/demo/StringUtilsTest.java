package demo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by CHENXINXIN on 2016/7/19.
 */
public class StringUtilsTest {
    @Test
    public void test() throws Exception {
        String cname = "jiangran.ksyun.8686c";
        String domain = "jiangran.ksyun.8686c.com";
        String str = StringUtils.substring(cname, domain.length()+1);
        System.out.println("str = " + str);
        String str2 = StringUtils.substringAfter(cname, StringUtils.join(domain, '.'));
        System.out.println("str2 = " + str2);
    }
}

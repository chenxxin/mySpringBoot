package demo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.net.URI;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CHENXINXIN on 2016/7/13.
 */
public class UrlTest {
    @Test
    public void testUrl() throws Exception {
        String str = "http://admain@www.balckstar.com:8080/javafaq/books/jnp/index.html?isbn=1565922069&book=java#toc";
        URL url = new URL(str);

        // 模式/协议
        url.getProtocol(); // http

        // 授权机构
        url.getAuthority(); // admain@www.balckstar.com:8080

        // 用户信息
        url.getUserInfo(); // admain

        // 主机
        url.getHost(); // www.balckstar.com

        // 端口  若url中没有端口，返回-1
        url.getPort(); // 8080

        // 返回该url协议所使用的默认端口 http:80, ftp:21 ,无默认端口，返回-1
        url.getDefaultPort();

        // 路径+查询字符串
        url.getFile(); // /javafaq/books/jnp/index.html?isbn=1565922069&book=java

        // 路径
        url.getPath(); // /javafaq/books/jnp/index.html

        // 查询字符串
        url.getQuery(); // isbn=1565922069&book=java

        // 片段标识符
        url.getRef(); // toc

        URI uri = url.toURI();
         // URI 也有上述方法
    }

    @Test
    public void testValidateIP() throws Exception {
        System.out.println(validateIP("1.qw1.1.1"));

    }

    private boolean validateIP(String ip) throws Exception {
        ip = StringUtils.trim(ip);
        if(ip.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")){
            String[] strs = StringUtils.split(ip, "\\.");
            for (String str : strs){
                if (Integer.parseInt(str)>255){
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    @Test
    public void testValidateDomain() throws Exception {
        System.out.println(validateDomain("www.baidu.com"));
    }

    private boolean validateDomain(String domain){
        /*
        if (domain.matches("[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\\.?")){
            return true;
        }
        return false;
        */
        String regex = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\\.?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(domain);
        return matcher.matches();
    }

    @Test
    public void test() throws Exception {
        String str = "12345QWE";
        //判断一个字符串是否包含字母
        //Pattern.compile("[a-zA-Z]").matcher(str).find();  或者
        boolean flag = Pattern.compile("(?i)[a-z]").matcher(str).find();
        System.out.println(flag);
    }
}

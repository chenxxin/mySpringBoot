package demo;

import org.junit.Test;

/**
 * Created by CHENXINXIN on 2016/7/8.
 */
public class ResourceLoaderTest {
    @Test
    public void getResource() throws Exception {
        // 路径为： /.../项目名/target/test-classes/当前包名/
        this.getClass().getResource("").getPath();
        ResourceLoaderTest.class.getResource("").getPath();

        // 路径为： /.../项目名/target/test-classes/
        this.getClass().getResource("/").getPath();
        ClassLoader.getSystemResource("").getPath();
    }

}
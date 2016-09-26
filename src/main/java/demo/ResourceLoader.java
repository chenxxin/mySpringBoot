package demo;

/**
 * Created by CHENXINXIN on 2016/7/8.
 */
public class ResourceLoader {
    public static void main(String[] args) {

    }
    public void getResource(){
        // 路径为： /.../项目名/target/classes/当前包名/
        ResourceLoader.class.getResource("").getPath();

        // 路径为： /.../项目名/target/classes/
        ResourceLoader.class.getResource("/").getPath();
        ClassLoader.getSystemResource("").getPath();

        //以上方法得到的是 target 路径
        // target/classes 目录可以读取 src/main 下的文件
        // target/test-classes 目录可以读取 src/test 下的文件
        // 但是，如果写入文件的话，只会写入 target 目录下，不会写入 src 目录下
    }
}

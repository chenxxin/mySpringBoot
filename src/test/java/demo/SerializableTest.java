package demo;

import com.xin.domain.Person;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Java对象的序列化和反序列化
 *
 * 序列化：把Java对象转换为字节序列的过程
 * 反序列化：把字节序列恢复为Java对象的过程
 * 用途：实现数据的持久化，即把对象的字节序列永久地保存到硬盘上，通常存放在一个文件中；
 *       利用序列化实现远程通信，即在网络上传送对象的字节序列
 *
 * static,transient后的变量不能被序列化
 */
public class SerializableTest {
    @Test
    public void testSerialize() throws Exception {
        // map 底层
        Map<String,String> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age","18");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("D://test")));
        outputStream.writeObject(map);

        outputStream.close();
    }

    @Test
    public void testDeserialize() throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("D://test")));
        Object obj = inputStream.readObject();
        System.out.println(obj);
        inputStream.close();
    }

    @Test
    public void name() throws Exception {
        // 若Person类 未实现序列化，则报错
        Person person = new Person("first","last",15,"male");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("D://test")));
        outputStream.writeObject(person);
        outputStream.close();
    }
}

package demo;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.*;

/**
 * Created by CHENXINXIN on 2016/7/14.
 */
public class MyTest {
    /**
     * List, Set, 数组 之间的转换
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        // List 转 Set
        List<String> list = ImmutableList.of("hello", "world", "hello");
        Set<String> set = new HashSet<>(list); // [hello, world]

        // Set 转 List
        ArrayList<String> list1 = new ArrayList<>(set); // [hello, world]

        // 数组 转 List
        String[] arr = new String[] {"1", "2"};
        List list2 = Arrays.asList(arr); // [1, 2]

        // List 转 数组
        String[] arrs = list.toArray(new String[list.size()]);

    }

    /**
     * 统计map中某个value值出现的次数
     * @throws Exception
     */
    @Test
    public void testMap() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("1","zhangsan");
        map.put("2","zhangsan");
        map.put("3","lisi");
        map.put("4","wangwu");
        map.put("5","wangwu");

        Collection<String> values = map.values();  // [lisi, zhangsan, zhangsan, wangwu, wangwu]

        int count = Collections.frequency(values, "zhangsan"); // 2
    }

    @Test
    public void name() throws Exception {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        // b784009c61ad4ef2b368b2a753fa0790

    }
}

//StringUtils.isNumeric(str)



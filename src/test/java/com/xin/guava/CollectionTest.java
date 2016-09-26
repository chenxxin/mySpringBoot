package com.xin.guava;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.*;
import com.xin.domain.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by CHENXINXIN on 2016/6/23.
 */

public class CollectionTest {
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    List<Person> personList;
    @Before
    public void setUp(){
        person1 = new Person("Wilma", "Flintstone", 30, "F");
        person2 = new Person("Fred", "Flintstone", 32, "M");
        person3 = new Person("Betty", "Rubble", 31, "F");
        person4 = new Person("Barney", "Rubble", 33, "M");
        personList = Lists.newArrayList(person1, person2, person3, person4);
    }
    @Test
    public void testFilter() throws Exception{
        // FluentIterable 类的 filter 方法：从迭代器中过滤出满足条件的
        Iterable<Person> persons = FluentIterable.from(personList).filter(new Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return person.getAge()>31;
            }
        });
        assertThat(Iterables.contains(persons, person1),is(false));
        assertThat(Iterables.contains(persons, person2),is(true));
        assertThat(Iterables.contains(persons, person3),is(false));
        assertThat(Iterables.contains(persons, person4),is(true));
    }
    @Test
    public void TestTransform() throws Exception{
        // FluentIterable 类的 transform()
        // 将迭代器personList中的元素通过Function处理后，生成新的list
        List<String> transformedPersonList = FluentIterable.from(personList).transform(new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                //将指定元素以#连接
                return Joiner.on('#').join(person.getLastName(),person.getFirstName(), person.getAge());
            }
        }).toList(); //toList, toSet, toMap<Person,String>, toSortedList, toSortedSet 都可以
        assertThat(transformedPersonList.get(1), is("Flintstone#Fred#32"));
    }
    @Test
    public void testList() {
        //创建一个可变的list
        List<String> list = Lists.newArrayList("hello", "world", "huohuo", "xin");//可set，可add

        // Lists.partition(lists,size)
        // 将给定的List按指定的大小size进行分割
        List<List<String>> subList = Lists.partition(list, 5);//返回 [[hello, world, huohuo], [xin]]
    }

    @Test
    public void testSet() {
        Set<String> set1 = Sets.newHashSet("1", "2", "3");
        Set<String> set2 = Sets.newHashSet("2", "3", "4");

        // difference()
        // 返回set1中有，而set2中没有的元素集合（不可变）
        Sets.difference(set1, set2); //返回[1]

        // symmetricDifference()
        // 返回两个集合中不同的元素集合（不可变）
        Sets.symmetricDifference(set1, set2);//返回[1,4]

        // intersection()
        // 交集（不可变）
        Sets.SetView<String> sv = Sets.intersection(set1, set2);

        // union()
        // 并集（不可变）
        Sets.union(set1, set2);//返回[1,2,3,4]

        //上述几种方法的返回值类型可以是 Sets.SetView<String>, Set<String>
    }

    @Test
    public void testImmutable() throws Exception {
        // 创建时初始化，不可变
        ImmutableMap<String, Integer> map = ImmutableMap.of("a", 1, "b", 2);

        ImmutableSet<Integer> numbers = ImmutableSet.of(1, 2, 3, 4, 5);
        ImmutableSet<Integer> another = ImmutableSet.copyOf(numbers);
        ImmutableSet<Integer> numbers2 = ImmutableSet.<Integer>builder().addAll(numbers).add(6).add(7).build(); //[1, 2, 3, 4, 5, 6, 7]

        ImmutableList<String> list = ImmutableList.of("hello", "world");
    }

    @Test
    public void testMap(){
        // uniqueIndex()
        // iterator()作为value，Function的结果作为key，不可变
        ImmutableMap<String, Person> map1 = Maps.uniqueIndex(personList.iterator(), new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getFirstName();
            }
        });
        /*
        //上述代码相当于，（可变）
        Map<String, Person> map = new HashMap<String, Person>();
        for(Person person : personList){
            map.put(person.getFirstName(),person);
        }
         */

        // asMap()
        // set作为key，Function的结果作为value，可变
        Map<Person,String> map2 = Maps.asMap(Sets.newHashSet(personList), new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getLastName();
            }
        });

        // toMap()
        // 同asMap() ，但不可变
        ImmutableMap<Person,String> map3 = Maps.toMap(Sets.newHashSet(personList), new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getLastName();
            }
        });

        // Maps.transformEntries()
        // 返回一个map映射，entry为给定map1的entry通过给定EntryTransformer转换后的值
        Map<String, Integer> map4 = Maps.transformEntries(map1, new Maps.EntryTransformer<String, Person, Integer>() {
            @Override
            public Integer transformEntry(String s, Person person) {
                return person.getAge();
            }
        });

        //Maps.transformValues()
        // 返回一个map映射，key为给定map1的key，value为给定map1中value通过Function转换后的值
        Map<String, Integer> map5 = Maps.transformValues(map1, new Function<Person, Integer>() {
            @Override
            public Integer apply(Person person) {
                return person.hashCode();
            }
        });

        //ArrayListMultimap
        //一个key对应多个值，key:ArrayList 格式,支持一个key对应重复的值
        ArrayListMultimap<String,String> multiMap= ArrayListMultimap.create();
        multiMap.put("Foo","1");
        multiMap.put("Foo","2");
        multiMap.put("Foo","3");
        multiMap.put("Foo","3");
        // multiMap = {Foo : [1, 2, 3, 3]} , multiMap.size()=4
        System.out.println(multiMap);

        multiMap.asMap(); // 返回一个真正的map（不可变），size()为key的个数

        TreeMultimap<String,String> treeMultimap= TreeMultimap.create();
        treeMultimap.put("Foo","1");
        treeMultimap.put("Foo","2");
        treeMultimap.put("Foo","3");
        treeMultimap.put("Foo","3");

        System.out.println(treeMultimap);


        //HashMultimap
        //一个key对应多个值，key:HashMap 格式，一个key对应的值不能重复
        HashMultimap<String,String> hashMultiMap= HashMultimap.create();
        hashMultiMap.put("Bar","1");
        hashMultiMap.put("Bar","2");
        hashMultiMap.put("Bar","3");
        hashMultiMap.put("Bar","3");
        // hashMultiMap = {Bar : [3, 2, 1]} , hashMultiMap.size()=3

        hashMultiMap.asMap(); // 返回一个真正的map（不可变），size()为key的个数

        //BiMap
        //一个value只能有一个key
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1,"Tom");
//        biMap.put(2,"Tom");// 重复添加value 会报 IllegalArgumentException 异常
        biMap.forcePut(2,"Tom"); // 替换掉具有相同value的key

        BiMap<String, Integer> biMap1 = biMap.inverse(); // key value互换
    }
}

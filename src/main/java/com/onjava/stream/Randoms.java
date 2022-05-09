package com.onjava.stream;


import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 声明式编程与命令式编程是一种风格的差别，
 * 声明式编程是声明要做什么，而不是指明每一步该如何做，同函数式编程风格。
 * 命令式编程是指明每一步该如何做，而不是声明要做什么，理解上会更难。
 */
@Slf4j
public class Randoms {

    public static void main(String[] args) {
        declarativeProgramming();
        imperativeProgramming();
    }

    /**
     * 获取随机数：声明式编程
     */
    public static void declarativeProgramming() {
        if (log.isInfoEnabled()) {
            log.info("声明式编程测试");
        }
        // seed为种子值，即随机数生成器的初始化状态，seed的作用不是用来控制生成随机数的大小，而是制造一种伪随机，在Random()函数中加入了一个固定的seed值之后，每次生成的随机序列都是相同的，即生成的随机序列中的元素值和顺序都是一致的。
        new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * 获取随机数：命令式编程
     */
    public static void imperativeProgramming() {
        if (log.isInfoEnabled()) {
            log.info("命令式编程测试");
        }
        Random random = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while (rints.size() < 7) {
            int r = random.nextInt(20);
            if (r < 5) {
                continue;
            }
            rints.add(r);
        }
        System.out.println(rints);
    }

    /**
     * StudyPoint1：SortedSet
     * 按照对象的比较函数对元素排序，而不是只元素的插入次序，插入顺序则用LinkedHashSet来保存，以Comparator comparator()自然方式排序.自然去重
     *
     * //SortedSet提供的方法：
     *
     * java.util.SortedSet.comparator()//自己定义比较器，对内部元素排序
     *
     * java.util.SortedSet.first()//第一个元素
     *
     * java.util.SortedSet.headSet(E e)//e之前的元素，不包括e
     *
     * java.util.SortedSet.last()//最后一个元素
     *
     * java.util.SortedSet.spliterator()//Java8新增，生成Spliterator接口，有点类似nio里的selector
     *
     * java.util.SortedSet.subSet(E e1, E e2)//e1和e2之间的元素，包括e1,不包括e2
     *
     * java.util.SortedSet.tailSet(E e)//e之后的元素，包括e
     */

    /**
     * StudyPoint2：SortedMap
     * 可确保键处于排序状态，键值对 键 次序排列的,TreeMap中次序是有意义的。
     *
     * java.util.SortedMap.comparator()//接收比较器，用于Map排序
     *
     * java.util.SortedMap.entrySet() //后去Map中的entrySet集合
     *
     * java.util.SortedMap.firstKey() //第一个key
     *
     * java.util.SortedMap.headMap(K k)//在k之前的键值对
     *
     * java.util.SortedMap.keySet() //获取key的set集合
     *
     * java.util.SortedMap.lastKey() //最后的key
     *
     * java.util.SortedMap.subMap(K k1, K k2)//k1，k2之间的键值对
     *
     * java.util.SortedMap.tailMap(K) //集合最后的键值对
     *
     * java.util.SortedMap.values() //集合所有的values
     */

}

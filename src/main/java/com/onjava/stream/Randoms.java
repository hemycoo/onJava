package com.onjava.stream;


import lombok.extern.slf4j.Slf4j;

import java.util.Random;

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
     *
     */
    public static void imperativeProgramming() {
        log.info("命令式编程测试");
    }

}

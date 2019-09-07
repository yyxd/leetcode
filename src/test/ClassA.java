package test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by HinTi on 2019/6/26.
 * Goal:
 */
public class ClassA {
    Class<?> clazz = ClassA.class;
    ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    ThreadPoolExecutor executor;
}
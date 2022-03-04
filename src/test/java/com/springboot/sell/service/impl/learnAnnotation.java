package com.springboot.sell.service.impl;

/**
 * @Author: jeff
 * @Date: 23/2/2022 下午 5:36
 * interface前加@，表示实现其接口Annotation，任何注解最底层都是从实现Annotation接口处理
 */
public @interface learnAnnotation {
    String value() default "我是一个实现Annotation的接口";
}

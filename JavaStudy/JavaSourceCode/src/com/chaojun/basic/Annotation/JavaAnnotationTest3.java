package com.chaojun.basic.Annotation;

import java.awt.event.ActionListener;
import java.lang.annotation.*;

//自定义重复注解
public class JavaAnnotationTest3 {
    public static void main(String[] args) {
        //获取指定注解 可以获取extends注解
//        Class myTag = TestRepeatTag.class;
//        Annotation annotation = myTag.getAnnotation(MyTag.class);
//        System.out.println(annotation);

        //获取全部注解 包括extends的注解
//        Class myTag = TestRepeatTag.class;
//        Annotation[] annotations = myTag.getAnnotations();
//        for (Annotation a : annotations) {
//            System.out.println(a);
//        }

        //获取指定注解 不能获取extends的注解
//        Class myTag = TestExtendsTag2.class;
//        Annotation annotation = myTag.getDeclaredAnnotation(ExtendsTag.class);
//        System.out.println(annotation);


        //获取全部注解 不能获取extends
//        Class myTag = TestRepeatTag.class;
//        Annotation[] annotations = myTag.getDeclaredAnnotations();
//        for (Annotation a : annotations) {
//            System.out.println(a);
//        }

        //判断是否含有ExtendsTag注解
//        Class myTag = TestExtendsTag2.class;
//        System.out.println(myTag.isAnnotationPresent(ExtendsTag.class));

        //获取重复注解
//        Class<TestRepeatTag> clazz = TestRepeatTag.class;
//        MyTag[] annotations = clazz.getAnnotationsByType(MyTag.class);
//        for (MyTag tag: annotations) {
//            System.out.println(tag);
//        }

        //获取重复注解
//        Class<TestRepeatTag> clazz = TestRepeatTag.class;
//        MyTag[] annotations = clazz.getDeclaredAnnotationsByType(MyTag.class);
//        for (MyTag tag: annotations) {
//            System.out.println(tag);
//        }
    }
}


//Repeatable注解的使用可以进行重复注解
@Repeatable(MyTags.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyTag {
    int number();

    String name();
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyTags {
    MyTag[] value();
}


@Deprecated
@MyTag(number = 123, name = "cj")
@MyTag(number = 456, name = "qc")
class TestRepeatTag {

}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface ExtendsTag{

}

@ExtendsTag
class TestExtendsTag{

}

@Deprecated
class TestExtendsTag2 extends TestExtendsTag{

}


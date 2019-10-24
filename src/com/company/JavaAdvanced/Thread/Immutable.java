package com.company.JavaAdvanced.Thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Immutable {
    private static void test(Integer i){
        synchronized (Immutable.class){
            System.out.println(Thread.currentThread().getName() + "have been accessed.");
            i--;
            if (i>0) {
                test(i);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //Immutable student = new Immutable("Test",11,Arrays.asList(1,3,5));
        Thread first_thread = new Thread(()->{test(5);},"First Thread ");
        Thread second_thread = new Thread(()->{test(5);},"Second Thread ");
        first_thread.start();
        second_thread.start();
        first_thread.join();
        second_thread.join();
    }
    private final String name;
    private final Integer age;
    private final List<Integer> courses;

    private Immutable(String name,Integer age, List<Integer> courses){
        this.name = name;
        this.age = age;
        this.courses = courses;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public List<Integer> getCourses() {
        return Collections.unmodifiableList(courses);
    }
    Immutable addCourse(Integer courseCode){
        List<Integer> list = new ArrayList<>();
        Collections.copy(list,courses);
        list.add(courseCode);
        return new Immutable(this.getName(),this.getAge(),list);
    }
}
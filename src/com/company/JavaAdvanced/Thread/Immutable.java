package com.company.JavaAdvanced.Thread;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.List;

public class Immutable {
    public void main(String[] args) {
        Immutable student = new Immutable("Oguzhan",11,Arrays.asList(1,3,5));
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
        return new Immutable(name,age,list);
    }
}
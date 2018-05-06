package com.snipe.entity;

/**
 *  学生实体类
 */
public class Student {

    private Integer id; //标识
    private String sname; //名字
    private Integer age; //年龄
    private Double weight; //体重

    public Student() {}
    public Student(Integer id, String sname, Integer age, Double weight) {
        this.id = id;
        this.sname = sname;
        this.age = age;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}

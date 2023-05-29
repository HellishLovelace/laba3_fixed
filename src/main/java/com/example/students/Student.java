package com.example.students;

public class Student {
    private String firstName;
    private String lastName;
    private String group;
    private int age;
    private String subject;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Student(String firstName, String lastName, String group, int age, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.age = age;
        this.subject = subject;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group='" + group + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                '}';
    }
}
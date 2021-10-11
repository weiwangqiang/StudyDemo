package com.example.kotlindemo;

public class Student {
    public String name = "wei";

    public static void main(String[] args) {
        Coroutines coroutines = new Coroutines();
        coroutines.test1();
        int id = coroutines.id;
        String name = coroutines.name;
        Coroutines.Singleton1.name = "qqeq";
    }
}

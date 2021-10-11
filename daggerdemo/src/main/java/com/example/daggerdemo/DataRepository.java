package com.example.daggerdemo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataRepository {

    @Inject
    public DataRepository() {
    }

    public String getData() {
        return "哈哈哈";
    }
}

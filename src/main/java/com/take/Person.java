package com.take;

import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;

class Person {
    String name;
    MonthDay birthday;
    List<Person> ancestors;

    public Person(String name, MonthDay birthday) {
        this.name = name;
        this.birthday = birthday;
        this.ancestors = new ArrayList<>();
    }

    public void addAncestor(Person person) {
        ancestors.add(person);
    }
}
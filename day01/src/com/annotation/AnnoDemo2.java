package com.annotation;

import java.util.Date;

public class AnnoDemo2 {
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1() {
        //有缺陷
    }

    @SuppressWarnings("all")
    public void show2() {
        //替代show1

    }

    @MyAnno(value = 12, per = Person.p1, anno2 = @MyAnno2, strs = {"abc"})
    public void show3() {

    }

    public void Demo() {
        show1();
        Date date = new Date();
    }
}

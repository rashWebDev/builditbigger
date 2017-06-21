package com.example;

import java.util.ArrayList;
import java.util.List;

/*returns random jokes */
public class MyClass {
    public static String getJokes(){
        List<String> stringList = new ArrayList<>();
        String jokes_1 = "Programmer : A machine that turns coffee into code.";
        String jokes_2 = "Programming is like writing a book..Except when you miss a single comma on page 126 the whole thing makes no sense.";
        String jokes_3 = "Q: How do you tell an introverted computer scientist from an extroverted computer scientist?\n" + "\n" +
                "A: An extroverted computer scientist looks at your shoes when he talks to you..";
        String jokes_4 ="How do functions break up?"+"\n"+ "\"They stop calling each other!\"";
        String jokes_5 = "When is a function a bad investment?"+"\n"+ " \"When there's no return\"";
        String jokes_6 ="When do two functions fight?"+"\n"+"\"When they have arguments\"";
        String jokes_7 ="Why do we rarely see a program with crooked teeth?"+"\n"+" \"Because most of them have braces\"";
        String jokes_8 ="In what unit do you measure a function's length?"+"\n"+" \"In Para meters...\"";

        stringList.add(0,jokes_1);
        stringList.add(1,jokes_2);
        stringList.add(2,jokes_3);
        stringList.add(3,jokes_4);
        stringList.add(4,jokes_5);
        stringList.add(5,jokes_6);
        stringList.add(6,jokes_7);
        stringList.add(7,jokes_8);
        int len = (int)(Math.random()*stringList.size());
        return stringList.get(len);
    }
}

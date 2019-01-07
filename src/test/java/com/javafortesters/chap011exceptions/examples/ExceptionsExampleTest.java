package com.javafortesters.chap011exceptions.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExceptionsExampleTest {

    @Test
    public void throwANullPointerExceptionFix() {
        Integer age=18;
        String ageAsString=age.toString();
        String yourAge="You are "+ageAsString+" years old";
        assertEquals("You are 18 years old",yourAge);
    }

    @Test
    public void throwANullPointerException() {
        Integer age=null;
        String ageAsString;
        try {
            ageAsString = age.toString();
        }catch (NullPointerException e) {
            age = 18;
            ageAsString=age.toString();
        }

        String yourAge="You are "+ageAsString+" years old";
        assertEquals("You are 18 years old",yourAge);
    }

    @Test (expected = NullPointerException.class)
    public void throwANullPointerExceptionCatchByArithmeticException() {
        Integer age=null;
        String ageAsString;
        try {
            ageAsString = age.toString();
        }catch (ArithmeticException e) {
            /*
            java.lang.NullPointerException
            at com.javafortesters.chap011exceptions.examples.ExceptionsExampleTest.
            throwANullPointerExceptionCatchByArithmeticException(ExceptionsExampleTest.java:37)
             */
            age = 18;
            ageAsString=age.toString();
        }

        String yourAge="You are "+ageAsString+" years old";
        assertEquals("You are 18 years old",yourAge);
    }

    @Test (expected = NullPointerException.class)
    public void throwANullPointerExceptionBrokenCatch() {
        Integer age=null;
        String ageAsString;
        try {
            ageAsString = age.toString();
        }catch (NullPointerException e) {
            //age = 18;
            ageAsString=age.toString();
        }

        String yourAge="You are "+ageAsString+" years old";
        assertEquals("You are 18 years old",yourAge);
    }

//    @Test //(expected = NullPointerException.class)
//    public void throwANullPointerExceptionNoSuchMethodException() {
//        Integer age=null;
//        String ageAsString;
//        try {
//            ageAsString = age.toString();
//        }catch (NoSuchMethodException e) {
//            age = 18;
//            ageAsString=age.toString();
//        }
//
//        String yourAge="You are "+ageAsString+" years old";
//        assertEquals("You are 18 years old",yourAge);
//    }

    @Test
    public void throwANullPointerExceptionAsAnObject() {
        Integer age=null;
        String ageAsString;
        try {
            ageAsString = age.toString();
        }catch (NullPointerException e) {
            age = 18;
            ageAsString=age.toString();
            System.out.println("getMessage - "+e.getMessage());
            System.out.println("getStacktrace - "+e.getStackTrace());
            System.out.println("printStackTrace");
            e.printStackTrace();
        }

        String yourAge="You are "+ageAsString+" years old";
        assertEquals("You are 18 years old",yourAge);
    }



}

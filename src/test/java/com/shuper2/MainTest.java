package com.shuper2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void getParentDirAddress() {
        String actualResult = Main.getParentDirAddress("D:\\tools\\geek.7z");
        assertEquals("D:\\tools", actualResult);
    }

    @Test
    public void handle() {
        Main mainObj = new Main();
        mainObj.handle("D:\\Work\\Java Mentoring\\Repository\\simple\\pom.xml", "D:\\");
    }
}
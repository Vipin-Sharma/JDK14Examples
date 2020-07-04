package com.vip.jdk14;

import java.util.List;

public class HelpfulNullPointerExceptionDemo {
    public static void main(String[] args) {
        List<Integer> arrayList = null;
        System.out.println(arrayList.size());
    }
}

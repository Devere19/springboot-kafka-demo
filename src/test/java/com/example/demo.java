package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author abner.guo
 * @Date 2023/9/11 15:34
 */
@SpringBootTest
public class demo {

    @Test
    void test(){
        String input = "utter_RICH_TEXT_1698931182212624384";
        String regex = "_";
        //String regex = "^(.*)_([^_]+)$";
        String[] split = input.split(regex);
        for (String s : split) {
            System.out.println(s);
        }
    }
}

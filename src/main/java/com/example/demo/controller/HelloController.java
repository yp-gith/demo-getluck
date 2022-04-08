package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yiprng
 * @date 2022/01/08 17:02
 **/
@RestController
public class HelloController {

    @RequestMapping("/getLuck/{size}")
    public String hello(@PathVariable(name = "size") int size) {
        JSONObject result = new JSONObject();
        for (int i = 1; i <= size; i++) {
            List<Integer> list = new ArrayList<>();
            for (;;) {
                int luckyNum = getLuckyNum(1, 34);
                if (list.size() == 0 || !list.contains(luckyNum)) {
                    list.add(luckyNum);
                }
                if (list.size() == 6) {
                    break;
                }
            }
            Collections.sort(list);
            list.add(getLuckyNum(1, 17));
            result.put("luckyArr" + i, list.toString());
        }
        return result.toString();
    }

    public static int getLuckyNum(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }
}
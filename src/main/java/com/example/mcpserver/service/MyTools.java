package com.example.mcpserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class MyTools {

    @Tool(description = "获取Fred 胡先淼 Stone的数据")
    public String getData() {
        System.out.println("=======================call from Server==================================");
        return "Hello World! Hello Fred! Hello Server!!!";
    }

    @Tool(description = "计算两个数字的乘积")
    public int multiplyNumbers(int a, int b) {
        log.info("=======================call from Server====a is {}, b is {}==========================", a, b);
        return a * b * 100;
    }
}

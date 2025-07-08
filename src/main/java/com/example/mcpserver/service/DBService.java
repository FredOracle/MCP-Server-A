package com.example.mcpserver.service;

import com.example.mcpserver.entity.ChinaCity;
import com.example.mcpserver.entity.Demo;
import com.example.mcpserver.repository.ChinaCityRepository;
import com.example.mcpserver.repository.DemoRepository;
import com.example.mcpserver.repository.DepartmentRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class DBService {

  @Resource
  private DepartmentRepository departmentRepository;

  @Resource
  private DemoRepository demoRepository;

  @Resource
  private ChinaCityRepository chinaCityRepository;

  @Tool(name = "db", description = "获取数据库数据")
  public String getData() {
    log.info("================获取数据库数据。。。。。。。。。。");
    return "Hello, World! Select * from asset;";
  }

  @Tool(name = "getDepartment", description = "获取部门信息")
  public String getDepartment(String name) {
    return departmentRepository.findByName(name);
  }


  @Tool(name = "fetchDemo", description = "根据指定的名称，获取一个Demo对象信息")
  public Demo fetchDemo(String id) {
    log.info("================根据指定的ID{}，获取一个Demo对象信息。。。。。。。。。。", id);
    return demoRepository.findById(id).orElse(Demo.builder().id("0").build());
  }

  @Tool(name = "saveDemo", description = "保存一个Demo对象")
  public Demo saveDemo(String name) {
    log.info("================保存一个名为{}Demo对象并获取这个Demo对象信息。。。。。。。。。。", name);
    return demoRepository.save(Demo.builder().id(UUID.randomUUID().toString()).userName(name).password("123456")
        .message(UUID.randomUUID().toString()).build());
  }

  public ChinaCity getCity(String name) {
    return chinaCityRepository.findByCity(name);
  }

  public ChinaCity saveCity(ChinaCity city) {
    return chinaCityRepository.save(city);
  }

}

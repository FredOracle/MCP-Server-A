package com.example.mcpserver.common;

import com.example.mcpserver.service.DBService;
import com.example.mcpserver.service.LocationService;
import com.example.mcpserver.service.MyTools;
import com.example.mcpserver.service.WeatherService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class MCPServerToolsRegister {

    @Bean
    ToolCallbackProvider registerTools(MyTools myTools, LocationService locationService, WeatherService weatherService, DBService dbService) {
        System.out.println(LocalDateTime.now() + "注册MCP服务列表 Tools:");
        System.out.println("                                           " + myTools.getClass().getSimpleName());
        System.out.println("                                           " + locationService.getClass().getSimpleName());
        System.out.println("                                           " + weatherService.getClass().getSimpleName());
        System.out.println("                                           " + dbService.getClass().getSimpleName());
        return MethodToolCallbackProvider.builder().toolObjects(myTools, locationService, weatherService, dbService).build();
    }

}

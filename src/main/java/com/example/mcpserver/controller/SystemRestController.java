package com.example.mcpserver.controller;

import com.example.mcpserver.entity.ChinaArea;
import com.example.mcpserver.entity.Demo;
import com.example.mcpserver.service.DBService;
import com.example.mcpserver.service.LocationService;
import com.example.mcpserver.service.WeatherService;
import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/mcp/server")
public class SystemRestController {

    @Resource
    private LocationService locationService;

    @Resource
    private DBService dbService;

    @Resource
    private WeatherService weatherService;

    private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();


    /**
     * 获取坐标
     *
     * @param city
     * @return
     */
    @GetMapping("/location")
    public ChinaArea location(@PathParam(value = "city") String city) {
        ChinaArea district = locationService.getChinaAreaByPinyin(city);
        return district;
    }

    @GetMapping("/db")
    public String db() {
        System.out.println("db");
        return dbService.getData();
    }


    @GetMapping("/see")
    public SseEmitter subscribeEvents() {
        SseEmitter emitter = new SseEmitter();
        try {
            emitter.send(SseEmitter.event().data(dbService.getData()));
            emitters.add(emitter);


            emitter.send(SseEmitter.event().data(weatherService.getWeatherForecastByLocation(39.9, 116.4)));
            emitters.add(emitter);

            emitter.onCompletion(() -> emitters.remove(emitter));
            emitter.onTimeout(() -> emitters.remove(emitter));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return emitter;
    }

    // 服务端推送消息到客户端
    @PostMapping("/push-event")
    public void pushEvent(@RequestParam(value = "message") String message) {
        System.out.println("服务端推送消息到客户端： " + message);
        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(SseEmitter.event().data(message));
            } catch (IOException e) {
                emitters.remove(emitter);
            }
        }
    }

    @PostMapping(value = "/see-message")
    public String receiveMessage(@RequestBody String name) {
        System.out.println("收到客户端消息： " + name);
        Demo demo = dbService.saveDemo(name);
        return "服务端已收到消息： 【" + demo.getUserName() + "(" + demo.getId() + "):" + demo.getPassword() + "】 已确认。";
    }

}

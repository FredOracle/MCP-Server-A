package com.example.mcpserver.service;

import com.example.mcpserver.entity.CityLocation;
import com.example.mcpserver.entity.District;
import com.example.mcpserver.repository.CityLocationRepository;
import com.example.mcpserver.repository.DistrictRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LocationService {

    @Resource
    private DistrictRepository districtRepository;

    @Resource
    private CityLocationRepository cityLocationRepository;


    @Tool(name = "getDistrictByPinyin", description = "根据城市pinyin编码获取城市信息")
    public District getDistrictByPinyin(String pinyin) {
        log.info("================根据城市拼音{}获取城市地理信息。。。。。。。。。。", pinyin);
        if (pinyin == null) {
            return District.builder().build();
        }
        if (pinyin.length() == 1) {
            return getDistrictByInitials(pinyin);
        }

        return districtRepository.findByPinyin(pinyin).orElse(District.builder().build());
    }

    @Tool(name = "getCityLocationByCode", description = "根据城市编码获取城市坐标")
    public District getCityLocationByCode(String code) {
        log.info("================根据城市编码{}获取城市地理信息。。。。。。。。。。", code);
        return districtRepository.findByCode(code).orElse(District.builder().build());
    }


    public District getDistrict(Integer id) {
        return districtRepository.findById(id).orElse(District.builder().build());
    }

    public District getDistrictByName(String name) {
        return districtRepository.findByName(name).orElse(District.builder().build());
    }


    public District getDistrictByCode(String code) {
        return districtRepository.findByCode(code).orElse(District.builder().build());
    }

    public District getDistrictByInitials(String initials) {
        return districtRepository.findByInitials(initials).orElse(District.builder().build());
    }

    public District getCityLocation(Integer id) {
        return districtRepository.findById(id).orElse(District.builder().build());
    }

    public District getCityLocationByName(String name) {
        return districtRepository.findByName(name).orElse(District.builder().build());
    }


}

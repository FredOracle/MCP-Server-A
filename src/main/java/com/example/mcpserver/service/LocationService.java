package com.example.mcpserver.service;

import com.example.mcpserver.entity.ChinaArea;
import com.example.mcpserver.entity.District;
import com.example.mcpserver.repository.ChinaAreaRepository;
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
    private ChinaAreaRepository chinaAreaRepository;


    @Tool(name = "getDistrictByPinyin", description = "根据城市pinyin编码获取城市信息")
    public ChinaArea getChinaAreaByPinyin(String pinyin) {
        log.info("================根据城市拼音{}获取城市地理信息。。。。。。。。。。", pinyin);
        if (pinyin == null) {
            return ChinaArea.builder().build();
        }
        if (pinyin.length() == 1) {
            return getChinaAreaByInitials(pinyin);
        }

        return chinaAreaRepository.findByPinyin(pinyin).stream().findFirst().orElse(ChinaArea.builder().build());
    }

    @Tool(name = "getCityLocationByCode", description = "根据城市编码获取城市坐标")
    public ChinaArea getCityLocationByCode(String code) {
        log.info("================根据城市编码{}获取城市地理信息。。。。。。。。。。", code);
        return chinaAreaRepository.findByZipCode(code).orElse(ChinaArea.builder().build());
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

    public ChinaArea getChinaAreaByInitials(String initials) {
        return chinaAreaRepository.findByInitials(initials).stream().findFirst().orElse(ChinaArea.builder().build());
    }

    public District getCityLocation(Integer id) {
        return districtRepository.findById(id).orElse(District.builder().build());
    }

    public District getCityLocationByName(String name) {
        return districtRepository.findByName(name).orElse(District.builder().build());
    }


}

package com.example.mcpserver.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Notice)实体类
 *
 * @author makejava
 * @since 2025-07-03 14:25:59
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = -27193259279763697L;

    private String id;

    private Date createTime;

    private String name;

    private Date updateTime;

    private String content;

    private Date expireDate;

    private String type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}


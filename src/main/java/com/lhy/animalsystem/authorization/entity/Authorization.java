package com.lhy.animalsystem.authorization.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
*
* @TableName authorization
*/
public class Authorization implements Serializable {

    /**
    *
    */
    @NotNull(message="[]不能为空")
    private Integer id;
    /**
    *
    */
    @Size(max= 200,message="编码长度不能超过200")
    @Length(max= 200,message="编码长度不能超过200")
    private String name;
    /**
    *
    */
    @Size(max= 100,message="编码长度不能超过100")
    @Length(max= 100,message="编码长度不能超过100")
    private String url;
    /**
    * 注释
    */
    @Size(max= 200,message="编码长度不能超过200")
    @Length(max= 200,message="编码长度不能超过200")
    private String mark;

    private Integer parentid;

    private String icon;

    public Authorization() {
    }

    public Authorization(Integer id, String name, String url, String mark, Integer parentid, String icon) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.mark = mark;
        this.parentid = parentid;
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}

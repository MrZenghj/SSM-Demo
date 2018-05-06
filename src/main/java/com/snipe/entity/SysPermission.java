package com.snipe.entity;

import java.util.Date;

/**
 *  系统权限实体
 */
public class SysPermission {
    private String permissionId; //权限id
    private String parentId; // 父类id
    private String url; //访问地址
    private String descritpt; //描述
    private Integer status; //状态
    private String  createrId; //创建者id
    private Date createTime; //创建时间
    private String modifyerId; //修改者id
    private Date modifyTime; //修改时间

    public SysPermission() {
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescritpt() {
        return descritpt;
    }

    public void setDescritpt(String descritpt) {
        this.descritpt = descritpt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyerId() {
        return modifyerId;
    }

    public void setModifyerId(String modifyerId) {
        this.modifyerId = modifyerId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "permissionId='" + permissionId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", url='" + url + '\'' +
                ", descritpt='" + descritpt + '\'' +
                ", status=" + status +
                ", createrId='" + createrId + '\'' +
                ", createTime=" + createTime +
                ", modifyerId='" + modifyerId + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}

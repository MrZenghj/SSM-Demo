package com.snipe.entity;

import java.util.Date;

/**
 * 系统用户角色
 */
public class SysUSerRole {
    private String id; // id
    private String createrId; //创建者id
    private Date createTime; //创建时间
    private String modifyerId; //修改者id
    private Date modifyTime; //修改时间
    private String userId; //用户id
    private String roleId; //角色id
    private String name; // 管理员名称

    public SysUSerRole() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysUSerRole{" +
                "id='" + id + '\'' +
                ", createrId='" + createrId + '\'' +
                ", createTime=" + createTime +
                ", modifyerId='" + modifyerId + '\'' +
                ", modifyTime=" + modifyTime +
                ", userId='" + userId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

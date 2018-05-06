package com.snipe.entity;

import java.util.Date;

/**
 *  系统角色权限实体
 */
public class SysRolePermission {
    private String id; //id
    private String roleId; //角色id
    private String permissionId; //权限id
    private String createrId; //创建者
    private Date createTime; //创建时间
    private String modifyerId; //修改者id
    private Date modifyTime; // 修改时间

    public SysRolePermission() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
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
        return "SysRolePermission{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ", createrId='" + createrId + '\'' +
                ", createTime=" + createTime +
                ", modifyerId='" + modifyerId + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}

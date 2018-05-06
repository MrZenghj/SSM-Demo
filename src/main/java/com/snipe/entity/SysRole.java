package com.snipe.entity;

import java.util.Date;

/**
 * 系统角色实体
 */
public class SysRole {

    private String roleId; //角色id
    private String roleName; //角色名
    private String descript; //描述
    private String createrId; //创建者id
    private Date createTime; //创建时间
    private String modifyer; //修改者
    private Date modifyTime; //修改时间

    public SysRole() {
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
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

    public String getModifyer() {
        return modifyer;
    }

    public void setModifyer(String modifyer) {
        this.modifyer = modifyer;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", descript='" + descript + '\'' +
                ", createrId='" + createrId + '\'' +
                ", createTime=" + createTime +
                ", modifyer='" + modifyer + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}

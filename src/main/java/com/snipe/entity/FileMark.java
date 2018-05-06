package com.snipe.entity;

/**
 *  上传的文件标记实体
 */
public class FileMark {

    private int fid;
    private String mark;
    private String reference;

    public FileMark() {
    }
    public FileMark(int fid, String mark, String reference) {
        this.fid = fid;
        this.mark = mark;
        this.reference = reference;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "FileMark{" +
                "fid=" + fid +
                ", mark='" + mark + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}

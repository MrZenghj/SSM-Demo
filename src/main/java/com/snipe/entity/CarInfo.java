package com.snipe.entity;

/**
 *   车辆信息实体
 */
public class CarInfo {
    private int carId;      // 流水id
    private String carNo;   // 车牌号
    private String type;    // 车型
    private String produceDate;   // 出厂日期
    private int price;  // 价格

    public CarInfo() {
    }

    public CarInfo(int carId, String carNo, String type, String produceDate, int price) {
        this.carId = carId;
        this.carNo = carNo;
        this.type = type;
        this.produceDate = produceDate;
        this.price = price;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarInfoDao{" +
                "carId=" + carId +
                ", carNo='" + carNo + '\'' +
                ", type='" + type + '\'' +
                ", produceDate='" + produceDate + '\'' +
                ", price=" + price +
                '}';
    }
}

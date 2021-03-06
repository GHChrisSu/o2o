package com.chane.dto;


import com.chane.enums.ShopStateEnum;
import com.chane.entity.Shop;

import java.util.List;

public class ShopExecution {
    //结果状态
    private int state;

    //状态标示
    private String stateInfo;

    //店铺数量
    private int count;

    //操作的shop（增删改店铺的时候用到）
    private Shop shop;

    //shop列表（查询店铺列表时用到）
    private List<Shop> shopList;

    public ShopExecution(){

    }

    //店铺操作失败时使用的构造器
    public ShopExecution(ShopStateEnum shopStateEnum){
        this.state  = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
    }

    //店铺操作成功时使用的构造器
    public ShopExecution(ShopStateEnum shopStateEnum,Shop shop){
        this.state  = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shop = shop;
    }

    //店铺操作成功时使用的构造器
    public ShopExecution(ShopStateEnum shopStateEnum,List<Shop> shopList){
        this.state  = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}

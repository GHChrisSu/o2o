package com.chane.service.Impl;

import com.chane.dao.ShopDao;
import com.chane.dto.ShopExecution;
import com.chane.entity.Shop;
import com.chane.enums.ShopStateEnum;
import com.chane.exception.ShopOperationException;
import com.chane.service.ShopService;
import com.chane.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;

/**
 * Created by fucheng on 2018/5/19.
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, File shopImg) {
        //空值判断
        if(shop == null ){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
            //给店铺信息附初始值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectNum = shopDao.insertShop(shop);
            if(effectNum <= 0){
                throw new ShopOperationException("店铺创建失败");
            }else {
                if(shopImg != null){
                    //存储图片
                    try{
                        addShopImg(shop,shopImg);
                    }catch (Exception e){
                        throw new ShopOperationException("addShopImg error"+e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectNum = shopDao.updateShop(shop);
                    if(effectNum <= 0){
                        throw new ShopOperationException("更新图片地址失败");
                    }

                }
            }

        }catch (Exception e){
            throw new ShopOperationException("addShop error"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, File shopImg) {
        //获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImage(shop.getShopId());
       // String shopImgAddr = ImageUtil.generateThumbnail(shopImg,dest);
        //TODO
        String shopImgAddr = "test";
        shop.setShopImg(shopImgAddr);
    }
}
package com.chane.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fucheng on 2018/5/21.
 */
@Controller
@RequestMapping(value="shopadmin",method= {RequestMethod.GET})
public class ShopAdminController {

    @RequestMapping(value="shopoperation")
    public String shopOperation() {
        return "shop/shopoperation";
    }

    @RequestMapping(value="shoplist")
    public String shopList() {
        return "shop/shoplist";
    }

    @RequestMapping(value="shopmanagement")
    public String shopManagement() {
        return "shop/shopmanagement";
    }

}
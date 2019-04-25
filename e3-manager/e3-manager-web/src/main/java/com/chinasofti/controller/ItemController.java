package com.chinasofti.controller;

import com.chinasofti.EasyUIDataGridResult;
import com.chinasofti.entity.TbItem;
import com.chinasofti.entity.TbItemDesc;
import com.chinasofti.service.ItemDescService;
import com.chinasofti.service.ItemService;
import com.chinasofti.util.E3Result;
import com.chinasofti.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;
    private ItemDescService itemDescService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult list(@RequestParam(name = "page") Integer page, @RequestParam(name = "rows")Integer rows){
        EasyUIDataGridResult easyUIDataGridResult = itemService.queryByPageBean(page, rows);

        return easyUIDataGridResult;
    }
    @RequestMapping("/save")
    @ResponseBody
    public E3Result save(TbItem item, String desc){
        // 1、生成商品id
        long itemId = IDUtils.genItemId();
        System.out.println(itemId);
        // 2、补全TbItem对象的属性
//        item.setId(itemId);
        //商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        // 3、向商品表插入数据
        itemService.save(item);
        // 4、创建一个TbItemDesc对象
        TbItemDesc itemDesc = new TbItemDesc();
        // 5、补全TbItemDesc的属性
//        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        // 6、向商品描述表插入数据
        itemDescService.save(itemDesc);
        // 7、E3Result.ok()
        return E3Result.ok();
    }
}

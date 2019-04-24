package com.chinasofti.controller;

import com.chinasofti.EasyUIDataGridResult;
import com.chinasofti.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult list(@RequestParam(name = "page") Integer page, @RequestParam(name = "rows")Integer rows){
        EasyUIDataGridResult easyUIDataGridResult = itemService.queryByPageBean(page, rows);

        return easyUIDataGridResult;
    }


}

package com.chinasofti.service;

import com.chinasofti.EasyUIDataGridResult;
import com.chinasofti.entity.TbItem;

public interface ItemService {

    public EasyUIDataGridResult queryByPageBean(int pageIndex,int pageCount);
    public void save(TbItem tbItem);
}

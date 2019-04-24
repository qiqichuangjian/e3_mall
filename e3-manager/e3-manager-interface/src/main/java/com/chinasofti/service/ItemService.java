package com.chinasofti.service;

import com.chinasofti.EasyUIDataGridResult;

public interface ItemService {

    public EasyUIDataGridResult queryByPageBean(int pageIndex,int pageCount);
}

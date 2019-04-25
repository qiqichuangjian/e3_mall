package com.chinasofti.dao;

import com.chinasofti.framework.BaseDao;

import java.util.List;

public interface ItemCatDao<TbItemCat> extends BaseDao<TbItemCat> {
    //pid是parent_id的缩写，父类目ID=0时，代表的是一级的类目
    public List<TbItemCat> queryByPid(Integer pid);
}
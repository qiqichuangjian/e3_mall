package com.chinasofti.service;

import com.chinasofti.dao.ItemDescDao;
import com.chinasofti.entity.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ItemDescServiceImpl implements ItemDescService {

    @Autowired
    ItemDescDao itemDescDao;

    @Override
    public void save(TbItemDesc tbItemDesc) {
        itemDescDao.add(tbItemDesc);
    }
}

package com.chinasofti.dao.impl;

import com.chinasofti.dao.ItemCatDao;
import com.chinasofti.entity.TbItemCat;
import com.chinasofti.framework.BaseDaoImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemCatDaoImp extends BaseDaoImpl<TbItemCat> implements ItemCatDao<TbItemCat> {

    @Autowired
    HibernateTemplate hibernateTemplate;
    
    @Override
    //商品类目表集合
    public List<TbItemCat> queryByPid(final Integer pid) {
        //匿名内部类
        List<TbItemCat> itemCatList = hibernateTemplate.execute(new HibernateCallback<List<TbItemCat>>() {
            @Override
            public List<TbItemCat> doInHibernate(Session session) throws HibernateException {
                //parent_id父类目ID=0时，代表的是一级的类目
                List list = session.createQuery("from TbItemCat where parent_id =:pid")
                        .setParameter("pid", pid)
                        .list();
                return list;
            }
        });
        return itemCatList;
    }
}

package com.chinasofti.framework;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> clz;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public BaseDaoImpl() {
        Type baseDaoClass = this.getClass().getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType) baseDaoClass;
        Type[] types = ptype.getActualTypeArguments();
        clz = (Class<T>) (types[0]);
    }

    @Override
    public void add(T t) {
        hibernateTemplate.save(t);
    }

    @Override
    public void update(T t) {
        hibernateTemplate.update(t);
    }

    @Override
    public void delete(Integer id) {
        //得到类的id
        T t = hibernateTemplate.get(clz, id);
        if (t != null)
            hibernateTemplate.delete(t);
    }

    @Override
    public T query(Integer id) {
        //得到类的id
        return hibernateTemplate.get(clz, id);
    }

    @Override
    public List<T> queryByPageBean(T t, final int firstResult, final int maxResults, Object... params) {
        // 一个接口中只有一方法时就可以采用lamda 表达式（参数名）->{ 方法体 }    有参数写参数，没参数不写
        //        (session)->{
        //            return session.createQuery("from " + entityClass.getSimpleName()).list();
        //        }
        List<T> list = hibernateTemplate.execute(new HibernateCallback<List<T>>() {
            @Override
            public List<T> doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from " + clz.getSimpleName())
                        .setFirstResult(firstResult)
                        .setMaxResults(maxResults)
                        .list();
            }
        });
        return list;
    }


    @Override
    public List<T> queryAll() {
        return hibernateTemplate.execute(new QueryHibernateCallback());
    }

    class QueryHibernateCallback implements HibernateCallback<List<T>> {
        @Override
        public List<T> doInHibernate(Session session) throws HibernateException {
            return session.createQuery("from " + clz.getSimpleName()).list();
        }
    }

    @Override
    public long getCounts() {
        //得到有多少条数据
        String hql = "select count(*) from " + clz.getSimpleName();
        return ((Long) hibernateTemplate.iterate(hql).next()).intValue();
    }

    public DetachedCriteria createDetachedCriteria(T t, Object... param) {
        return null;
    }

}

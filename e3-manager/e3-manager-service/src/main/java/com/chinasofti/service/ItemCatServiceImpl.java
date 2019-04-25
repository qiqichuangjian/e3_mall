package com.chinasofti.service;

import com.chinasofti.EasyUITreeNode;
import com.chinasofti.dao.ItemCatDao;
import com.chinasofti.entity.TbItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    ItemCatDao itemCatDao;


    @Override
    public List<EasyUITreeNode> queryAction(Integer p_id) {
        // 通过pid 拿到节点集合
        List<TbItemCat> list = itemCatDao.queryByPid(p_id);
        // 将节点放入TreeNode
        List<EasyUITreeNode> easyUITreeNodeList =  new ArrayList<>();
        //遍历商品类目
        for (TbItemCat cat:list) {
            EasyUITreeNode  easyUITreeNode  =  new EasyUITreeNode();
            easyUITreeNode.setId(cat.getId()); // 节点id
            easyUITreeNode.setText(cat.getName()); // 类目名称
            //如果是父类目就进行closed ，不是就是open
            //父类目开始直接显示，所以要关闭；而子类目刚开始关闭状态，需要打开
            easyUITreeNode.setState(cat.getIsParent()?"closed":"open");  //状态
            // 将节点加入集合中，形成页面中的树状节点显示
            easyUITreeNodeList.add(easyUITreeNode);
        }
        return easyUITreeNodeList;
    }
}


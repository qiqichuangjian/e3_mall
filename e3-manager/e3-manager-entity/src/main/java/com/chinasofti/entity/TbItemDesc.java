package com.chinasofti.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="tb_item_desc")//商品描述表
public class TbItemDesc implements Serializable {
    private Long itemId;//商品ID

    private Date created;//创建时间

    private Date updated;//更新时间

    private String itemDesc;//商品描述
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native" ,strategy = "native")
    @Column(name = "item_id")
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    @Column(name = "item_desc")
    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}
package com.chinasofti.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="tb_item_param_item")//商品规格和商品的关系表
public class TbItemParamItem implements Serializable {
    private Long id;

    private Long itemId;//商品ID

    private Date created;//创建时间

    private Date updated;//更新时间

    private String paramData;//参数数据，格式为json格式

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native" ,strategy = "native")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name="item_id")
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
    @Column(name="param_data")
    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }
}
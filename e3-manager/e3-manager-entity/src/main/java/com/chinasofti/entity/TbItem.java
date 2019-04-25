package com.chinasofti.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name="tb_item")//商品表
public class TbItem implements Serializable {
    private Long id;//商品id，同时也是商品编号

    private String title;//商品标题

    private String sellPoint;//商品卖点

    private Long price;//商品价格，单位为：分

    private Integer num;//库存数量

    private String barcode;//商品条形码

    private String image;//商品图片

    private Long cid;//所属类目，叶子类目

    private Byte status;//商品状态，1-正常，2-下架，3-删除

    private Date created;//创建时间

    private Date updated;//更新时间
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native" ,strategy = "native")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "sell_point")
    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
}
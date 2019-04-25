package com.chinasofti.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="tb_order_item")//
public class TbOrderItem implements Serializable {
    private String id;

    private String itemId;//商品id

    private String orderId;//订单id

    private Integer num;//商品购买数量

    private String title;//商品标题

    private Long price;//商品单价

    private Long totalFee;//商品总金额

    private String picPath;//商品图片地址
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native" ,strategy = "native")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column(name="item_id")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    @Column(name="order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
    @Column(name="total_fee")
    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }
    @Column(name="pic_path")
    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
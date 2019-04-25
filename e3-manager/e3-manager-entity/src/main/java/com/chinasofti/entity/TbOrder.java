package com.chinasofti.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="tb_order")
public class TbOrder implements Serializable {
    private String orderId;//订单id

    private String payment;//实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分

    private Integer paymentType;//支付类型，1、在线支付，2、货到付款

    private String postFee;//邮费。精确到2位小数;单位:元。

    private Integer status;//状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭

    private Date createTime;//订单创建时间

    private Date updateTime;//订单更新时间

    private Date paymentTime;//付款时间

    private Date consignTime;//发货时间

    private Date endTime;//交易完成时间

    private Date closeTime;//交易关闭时间

    private String shippingName;//物流名称

    private String shippingCode;//物流单号

    private Long userId;//用户id

    private String buyerMessage;//买家留言

    private String buyerNick;//买家昵称

    private Integer buyerRate;//买家是否已经评价

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native" ,strategy = "native")
    @Column(name="order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    @Column(name="payment_type")
    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }
    @Column(name="post_fee")
    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @Column(name="create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Column(name="update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    @Column(name="payment_time")
    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
    @Column(name="consign_time")
    public Date getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }
    @Column(name="end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    @Column(name="close_time")
    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
    @Column(name="shipping_name")
    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }
    @Column(name="shipping_code")
    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }
    @Column(name="user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Column(name="buyer_message")
    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }
    @Column(name="buyer_nick")
    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }
    @Column(name="buyer_rate")
    public Integer getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(Integer buyerRate) {
        this.buyerRate = buyerRate;
    }
}
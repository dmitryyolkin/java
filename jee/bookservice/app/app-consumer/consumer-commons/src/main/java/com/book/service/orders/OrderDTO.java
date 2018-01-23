package com.book.service.orders;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (23.01.18)
 */
public class OrderDTO implements Serializable{
    private Long orderId;
    private Date creationDate;
    private String customerName;
    private Float totalAmount;

    public OrderDTO() {
    }

    public OrderDTO(Long orderId, Date creationDate, String customerName, Float totalAmount) {
        this.orderId = orderId;
        this.creationDate = creationDate;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }
}

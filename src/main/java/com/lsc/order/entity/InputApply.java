package com.lsc.order.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class InputApply {

    private int inputId;
    private int sneakersId;
    private String color;
    private float size;
    private int num;
    private String numUnit;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date applyTime;

    private BigDecimal price;
    private BigDecimal totalPrice;
    private double netWeight;
    private String invoiceNumber; //发票号码
    private int applicantId;
    private int supplierId;
    private String position;
    private String status;

    @Transient
    private int sumNum;
    @Transient
    private String sneakersName;
    @Transient
    private String applicant;
    @Transient
    private String supplier;


}

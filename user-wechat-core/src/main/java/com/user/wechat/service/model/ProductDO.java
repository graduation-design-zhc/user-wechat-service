package com.user.wechat.service.model;

import com.sun.org.glassfish.gmbal.Description;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zhanghuachang
 * @date 2019-05-09
 */
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
@Table(name = "product_info")
public class ProductDO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private String productPrice;
    @Description(value = "库存")
    @Column(name = "product_stock")
    private String productStock;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_img")
    private String productImg;
    @Column(name = "product_status")
    private String productStatus;
    @Description(value = "类目编号")
    @Column(name = "category_type")
    private String categoryType;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;

}

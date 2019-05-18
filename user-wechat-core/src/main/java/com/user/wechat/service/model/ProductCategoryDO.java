package com.user.wechat.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zhanghuachang
 * @date 2019-05-08
 */
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
@Table(name = "product_category")
public class ProductCategoryDO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_id")
    private String categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "category_type")
    private Integer categoryType;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;


}

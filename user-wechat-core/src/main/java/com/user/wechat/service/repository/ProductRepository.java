package com.user.wechat.service.repository;

import com.user.wechat.service.model.ProductDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhanghuachang
 * @date 2019-05-09
 */
public interface ProductRepository extends JpaRepository<ProductDO, String> {

    ProductDO findProductDOByProductId(String productId);

    List<ProductDO> findAllByProductIdIsIn(List<String> productIdList);

    List<ProductDO> findAllByCategoryType(Integer cateGoryType);

}

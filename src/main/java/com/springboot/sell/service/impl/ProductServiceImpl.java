package com.springboot.sell.service.impl;

import com.springboot.sell.DTO.CartDTO;
import com.springboot.sell.Exception.SellException;
import com.springboot.sell.dataObject.ProductInfo;
import com.springboot.sell.emuns.ProductStatusEnum;
import com.springboot.sell.emuns.ResultEnum;
import com.springboot.sell.repository.ProductInfoRepository;
import com.springboot.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: jeff
 * @Date: 2022/1/6 11:31
 * TODO:库存增减在多人（多线程）执行时，容易出现同时访问一个商品，库存返回的结果都是一样的，并不是按顺序执行，解决方法可以用synchronized来进行同步处理，但性能很低。第二种用redis分布式锁来解决，性能高，企业应用普遍。
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
//        return repository.findOne(productId);
        return repository.findById(productId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }


    /*加库存*/
    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
//            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).orElse(null);
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //增加
            Integer beforeStock = productInfo.getProductStock();
            Integer result = beforeStock + cartDTO.getProductQuantity();
            if (result <= beforeStock) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }

    /*减库存*/
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList
        ) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).orElse(null);
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //扣取
            Integer beforeStock = productInfo.getProductStock();
            int result = beforeStock - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = repository.findById(productId).orElse(null);
        if (productInfo == null)
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

//        不是上架才修改
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP)
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);

//        更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        repository.save(productInfo);

        return productInfo;
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = repository.findById(productId).orElse(null);
        if (productInfo == null)
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

//        不是下架才修改
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN)
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);

//        更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        repository.save(productInfo);

        return productInfo;
    }


    /**
     * 校验商品名称
     */
//    public void checkoutProductName(String productName){
//        Boolean result = repository.exists();
//    }


}

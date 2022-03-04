package com.springboot.sell.controller;

import com.springboot.sell.dataObject.ProductCategory;
import com.springboot.sell.dataObject.ProductInfo;
import com.springboot.sell.service.CategoryService;
import com.springboot.sell.service.ProductService;
import com.springboot.sell.VO.ProductInfoVO;
import com.springboot.sell.VO.ProductVO;
import com.springboot.sell.VO.ResultVO;
import com.springboot.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: jeff
 * @Date: 2022/1/7 9:20
 * RestController(功能：Controller+ResponseBody) 默认输出controller为json模式
 * BeanUtils.copyProperties 是Spring自带拷贝对象的方法
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    /**
     * Cacheable接口为redis缓存查询或新增，key的参数对同一个查询和修改必须一致，如果不传key会默认获取方法中第一个参数的值成为key，如果自己指定参数则通过Spring 表达式语言 (简称SpEL），通过#符号来注入。
     * 如果想获取方法返回的对象，通过Spel会给予以小写的参数名来代替
     */
//    @Cacheable(cacheNames = "product", key = "123")
    @Cacheable(cacheNames = "product", key = "#sellerId",
            condition = "#sellerId.length() > 3", unless = "#result.getMsg()!='成功'")
    @GetMapping("/list")
    public ResultVO list(@RequestParam(value = "sellerId", defaultValue = "123") String sellerId) {

        //1、查询所有的上架商品(如果redis已有对应key的数据，则越过数据库操作）
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2、查询类目（一次性查询，性能高）
        // 传统方法
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
//        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        /** 精简方法（java8，lambda)表达式
         * 自行翻译. 列表调用stream接口变成字节，
         * 然后调用map接口将字节导入map中参数（e），e在筛选具体内容，二次赋值给自身e，
         * 然后调用收集接口，通过内置对象收集者调用toList方法，把e参数内容收集起来，并返回*/
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        //3、数据拼装（外到内） Data Assembled
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            /*foods*/
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList
            ) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //Copy productInfo to productInfoVO if column same
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        //返回data
        return ResultVOUtil.success(productVOList);

    }


    /**
     * 测试假数据
     * @return
     *  @GetMapping("/list")
     *     public ResultVO<List<ProductVO>> list() {
     *         ResultVO<List<ProductVO>> resultVO = new ResultVO<List<ProductVO>>();
     *         resultVO.setCode(0);
     *         resultVO.setMsg("成功");
     *
     *         ProductVO productVO = new ProductVO();
     *         productVO.setCategoryName("热榜");
     *         productVO.setCategoryType(1);
     *
     *         ProductInfoVO productInfoVO = new ProductInfoVO();
     *         productInfoVO.setProductId("123456");
     *         productInfoVO.setProductName("皮蛋粥");
     *         productInfoVO.setProductPrice(new BigDecimal("1.2"));
     *         productInfoVO.setProductDescription("好吃的皮蛋粥");
     *         productInfoVO.setProductIcon("http://xxx.com");
     *
     *         productVO.setProductInfoVOList(Collections.singletonList(productInfoVO));
     *         resultVO.setData(Collections.singletonList(productVO));
     *         return resultVO;
     *     }
     */

}

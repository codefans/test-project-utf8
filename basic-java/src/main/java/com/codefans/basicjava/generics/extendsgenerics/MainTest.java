package com.codefans.basicjava.generics.extendsgenerics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:
 * @date: 2019-01-10 10:16:48
 */
public class MainTest {

    public static void main(String[] args) {

        ExtendsGenericsService extendsGenericsService = new ExtendsGenericsServiceImpl();
        List<ProductInfo> productInfoList = new ArrayList<ProductInfo>();
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductNo("10001");
        productInfo.setProductName("productName001");
        productInfoList.add(productInfo);
        List<? extends InfoBase> resultProductList = extendsGenericsService.toList(productInfoList);
//        List<ProductInfo> resultProductList = extendsGenericsService.toList(productInfoList);

        List<ProductInfo> productResultList = (List<ProductInfo>)resultProductList;
        for(ProductInfo productInfo1 : productResultList) {
            System.out.println(productInfo1.getProductNo());
            System.out.println(productInfo1.getProductName());
        }


    }

}

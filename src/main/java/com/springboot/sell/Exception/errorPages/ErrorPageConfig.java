//package com.springboot.sell.Exception;
//
//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
//import org.springframework.boot.web.servlet.ErrorPage;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//
///**
// * @Author: jeff
// * @Date: 30/1/2022 4:16 PM
// * 配置错误页面跳转
// */
//@Configuration
//public class ErrorPageConfig {
//
//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//            return new EmbeddedServletContainerCustomizer() {
//                @Override
//                public void customize(
//                        ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
//                    ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,
//                            "/errorPages/error-500.html");
//                    ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND,
//                            "/errorPages/error-404.html");
//                    configurableEmbeddedServletContainer.addErrorPages(errorPage500,errorPage404);
//                }
//            };
//    }
//}

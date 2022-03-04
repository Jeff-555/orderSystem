package com.springboot.sell.handler;

import com.springboot.sell.Exception.SellException;
import com.springboot.sell.Exception.SellerAuthorizeException;
import com.springboot.sell.VO.ResultVO;
import com.springboot.sell.config.ProjectUrlConfig;
import com.springboot.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: jeff
 * @Date: 30/1/2022 5:02 PM
 * ResponseStatus改变返回到前端的HTTP状态码
 * 注意：错误处理仅限当前sell项目（路径），nginx识别其他项目则不会调用该错误处理
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //    @ResponseStatus(HttpStatus.USE_PROXY)
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    /**
     * 如果越过权限，弹出登录界面
     * 拦截状态码：403
     *
     * @return
     */
    @ExceptionHandler(value = SellerAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorizeException() {
        //借用开放账号路径，因为得到随机openid无法与数据库所以无法扫码成功
//        return new ModelAndView("redirect:"
//                .concat("https://open.weixin.qq.com/connect/qrconnect?appid=wx6ad144e54af67d87&redirect_uri=http%3A%2F%2Fsell.springboot.cn%2Fsell%2Fqr%2FoTgZpwQWA7ip6eEge1OJ_P_-bGu0&response_type=code&scope=snsapi_login&state=")
//                .concat(projectUrlConfig.getWechatOpenAuthorize())
//                .concat("/sell/seller/login")
//                .concat("?openid=")
//                .concat("随机openid"));

//          有开放账号正常跳转到login在扫码跳到list
//        return new ModelAndView("redirect:"
//                .concat(projectUrlConfig.getWechatOpenAuthorize())
//                .concat("/sell/wechat/qrAuthorize")
//                .concat("?returnUrl=")
//                .concat(projectUrlConfig.getSell())
//                .concat("/sell/seller/login"));
        return null;
    }


    /**
     * 处理Http（400、500等）异常信息，进行优化（除了404)
     * //TODO:处理异常码与信息识别相等，取消默认返回200码
     * * ResponseStatus里的code和value对应指定的code码值，这个值后面可以通过服务器来获得不需要手动写死，
     * * 具体操作百度
     */
//    @ExceptionHandler(value = {Exception.class})
//    @ResponseBody
//    public Object error() {
//        Map<String, String> map = new HashMap<>();
//        map.put("error", "出错了，请检查参数是否正确");
//        return map;
//    }

    /**
     * 处理404异常信息
     */
//    @Controller
//    public static class NotFoundException implements ErrorController {
//
//        @Override
//        public String getErrorPath() {
//            return "/error";
//        }
//
//        @RequestMapping(value = {"/error"})
//        @ResponseBody
//        public Object error404() {
//            Map<String, Object> body = new HashMap<>();
////            body.put("code", "404");
//            body.put("error", "出错了，请检查路径是否正确");
//            return body;
//        }
//    }
}

/**
 * //TODO:处理异常码与信息识别相等，取消默认返回200码
 * * ResponseStatus里的code和value对应指定的code码值，这个值后面可以通过服务器来获得不需要手动写死，
 * * 具体操作百度
 */
//    @ExceptionHandler(value = ResponseBankException.class)
//    @ResponseStatus(code = HttpStatus.FORBIDDEN,value = HttpStatus.FORBIDDEN)
//    @ResponseBody
//    public void handleResponseBankException() {
//    }


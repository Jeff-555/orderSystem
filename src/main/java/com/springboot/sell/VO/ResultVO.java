package com.springboot.sell.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 *
 * @Author: jeff
 * @Date: 2022/1/7 9:31
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 9007573070969276744L;


    /* 错误码 */
    private Integer code;

    /* 提示信息 */
    private String msg = "";

    /* 具体内容 */
    /* 注意：最终返回是个集合 */
    private T data;
}

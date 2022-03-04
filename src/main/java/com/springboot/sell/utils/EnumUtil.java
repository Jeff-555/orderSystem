package com.springboot.sell.utils;

import com.springboot.sell.emuns.CodeEnum;

/**
 * <T extends CodeEnum>不可以省略，带有说明继承哪种泛型
 * 通过继承CodeEnum接口的实现类（自动寻找实现类）
 * 让外部通过enumCode获得Enum对象
 * @Author: jeff
 * @Date: 19/2/2022 上午 11:57
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                /*返回enum对象，输出会自动返回对象的value值*/
                return each;
            }
        }
        return null;
    }

}

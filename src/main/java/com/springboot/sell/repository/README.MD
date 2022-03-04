有关jpa知识。
https://coding.imooc.com/lesson/328.html#mid=23566。

让实体注入@entity，继承JpaRepository接口后，自动拥有了按“实例”进行查询的诸多方法。jpa利用jpa封装的sql方法来实现基本需求
注意：1、写方法一定要根据IDEA给的提示去定义，不然JPA不会生成对应方法
        比如 find （提示） By （提示） 对应字段。
     2、如果大项目或者很复杂项目必须用mybatis来细分
#项目部署：
目前部署方式，大多用容器Docker（详见微服务课程）
或者公司自己构建的部署容器。并且大多数由公司的运维去实现，无需开发人员。
如需了解些基础的部署请看：https://coding.imooc.com/lesson/117.html#mid=6413


#虚拟机
账号：root
密码：123456
配置文件路径
index.js 文件
/opt/code/sell_fe_buyer/config


nginx.conf文件（设置完刷新 nginx -s reload）
/usr/local/nginx/conf/


项目build之后复制的目录
cp -r dist/* /opt/data/wwwroot/sell/



#数据库sell_myself
由于版本问题引入sql会出现错误，还是导入源码sql
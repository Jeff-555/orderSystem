.ftl配合freemarker使用（固定搭配）
技巧：修改freemarker文件的View文件（.ftl)后，直接按build project（ctrl+F9）即可刷新，无需手动重启。提高效率

freemarker字段默认操作：map属性增加叹号后，
叹号后面的值就是map属性的默认值，默认值以字符串形式书写。
例如${url!"我是默认值"}   叹号后面就是默认值。
freemarker判断属性、列表
<#List> 列表
<#if><#else> 判断语句
属性?? 判断属性是否存在



bootstrap：
控制表格样式：col-md-段数

css文件是从源码获取（10-2）
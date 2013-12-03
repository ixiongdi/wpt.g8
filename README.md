wpt.g8
======

A web project template.

```
curl https://raw.github.com/n8han/conscript/master/setup.sh | sh

cs n8han/giter8

g8 ixiongdi/wpt
```
1. 精简mvc架构， play的那种route单独配置会让人经常两头看代码  
2. mvc都有个基类，提供基本的add, del, set, get操作
3. web frame性能测试前10有7个jvm,其余的是c++, lua, go  
4. 地成集成undertow性能表现最好  
5. 抛弃servlet，因为有时候需要额外的配置，不符合零配置的需求哦  
6. 模板用ssp，因为其他的模板不太好移植，而且结构不好看  
7. model用avro，原生json格式，和mongodb集成  
8. 自动代码重组  
9. 一键发布，压缩js，css，html  
10. 高薪能   

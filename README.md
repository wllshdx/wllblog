## 简介
这是一个基于Springboot2.x，vue2.x的前后端分离的开源博客系统，提供 前端界面+管理界面+后台服务 的整套系统源码。响应式设计，手机、平板、PC，都有良好的视觉效果！

这个项目是在本人计算思维实训（2）课程的课程项目，当然，这也会是个人

## 使用技术
- SpringBoot 2.x 后台基本框架
- Vue 2.x 前端基本框架
- ElementUI：后台管理页面UI库
- IView：前端UI库
- ElasticSearch 搜索层
- RabbitMQ 消息队列
- Shiro 鉴权层
- Redis 缓存层
- Swagger 文档
- Mybaits-Plus 好用的mybatis框架
- lombox getter setter插件
- druid 数据库连接池
- jasypt 加密
- 七牛云 图床

## 项目部署
### 服务端
项目后端环境
- JDK1.8
- Mysql5.7
- Redis
- IDEA编译器
- Lombox插件
- ElasticSearch 6.x
- RabbitMQ
- IDEA编译器


部署步骤：
1. 创建数据库wllblog，并导入wllblog-backend -> db里的所有sql文件
2. 修改wllblog-backend -> wllblog里的application.的数据库连接、redis连接、ElasticSearch连接、RabbitMQ连接
3. 本机安装并启动好
4. 导入项目，并且运行wllblog-backend里的main方法

### 前端
前端环境：
- Node.js 8.0+
- WebStorm编辑器

部署步骤：
1. 导入项目，运行 npm install（如果失败，清空包后试试cnpm install）
2. 启动项目：npm run dev
3. 前端地址：localhost:8002 管理界面地址：localhost:8888  账号admin，密码123456


# 高等软件工程大作业
高等软件工程大作业

部件介绍：
Middleground：中台，服务注册中心
ProducerDemo：服务生产者
ConsumerDemo：服务消费者
MGGateway：中台的网关


Middleground使用eureka server来搭建服务注册中心
ProducerDemo提供一个Hello World服务，并将其挂载在Middleground上
ConsumerDemo根据服务名称从Middleground中调用Hello World服务，并使用此服务的结果来实现自己的服务
MGGateway为使用地址进行服务请求进行路由

运行效果：http://127.0.0.1:8081/ 服务注册中心的管理页面
http://127.0.0.1:8082/index 消费者本身提供的服务
http://127.0.0.1:8084/service-client/index 此地址经过MGGateway路由，由service-client转到消费者提供的服务
http://127.0.0.1:8085/callHello 此地址为消费者提供的服务，该服务的实现中从Middleground处根据服务名称调用了消费者提供的服务


如果在程序中使用eureka consumer来调用服务，只需要通过Middleground即可实现路由和负载均衡；如果想要用浏览器从链接调用服务，则需要通过MGGateway进行路由；ProducerDemo的地址不会暴露给用户
Middleground中附加了日志记录功能，在logs文件夹中即为运行日志

关于要求中的各点：
RBAC：通过在Middleground中的spring security来实现，使用spring security来对服务注册中心进行访问控制，保证USER权限可以挂载服务，管理员权限可以管理用户数据

系统安全：同上，只有ADMIN用户可以访问后台相关
缓存：没有，不知道怎么弄
日志：在Middleground中进行了日志记录
异常处理：也不知道怎么弄

后台管理：目前可以看eureka的后台，关于用户的管理还在实现中

业务场景：需要实现具体的生产者和消费者

自动化表单：还没有

微服务架构：显然保证
前后端完全分离：这些完全都是后端
兼容性：这部分要前端去考虑，对CSS自动加前缀处理下就可以
网络安全：应该能保证吧，大概
性能：Middleground和MGGateway都开启了负载均衡，虽然没测试过但应该问题不大
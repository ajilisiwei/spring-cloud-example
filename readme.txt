项目模块说明：
1.eureka-server : 服务注册中心(高可用)
2.server-provider : 服务提供者
3.ribbon-consumer : ribbon实现的服务消费者
4.hystrix-dashboard : Hystrix仪表盘
5.turbine : Turbine集群监控
6.feign-consumer : Feign声明式服务调用实现的服务消费者
7.server-provider-api:服务提供者与消费者客户端接口层
8.api-gateway : spring-cloud-zuul实现的路由
9.api-gateway2 : spring-cloud-zuul实现的路由
10.config-server : spring-cloud-config实现的分布式配置中心

各个模块都是相互独立的,可阅读每个模块下的readme.txt文档启动相关模块进行测试

例子一:
1.eureka-server : 服务注册中心(高可用)
2.server-provider : 服务提供者
3.ribbon-consumer : ribbon实现的服务消费者
4.hystrix-dashboard : Hystrix仪表盘
5.turbine : Turbine集群监控
6.feign : Feign声明式服务调用实现的服务消费者

例子二:
1.新建server-provider-api项目，创建api接口类和相关的底层类
2.在服务生产者server-provider项目中依赖server-provider-api项目，并实现api接口类
3.在服务消费者feign-consumer项目中依赖server-provider-api项目来绑定服务

例子三:
1.使用spring-cloud-zuul实现网关服务功能
    --api-gateway
    --api-gateway2

例子四:
1.spring-cloud-config实现分布式配置中心
    --config-server

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
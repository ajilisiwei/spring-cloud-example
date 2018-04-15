1.通过引入Spring Cloud Stream实现对RabbitMQ的支持,Stream通过Binder绑定器的概念对应用程序和消息中间件起到
    隔离作用，使得不同消息中间件的实现细节对应用程序来说是透明的。
2.例子中使用RabbitMQ的默认自动化设置
3.通过RabbitMQ的channel发布消息给应用程序消费，而应用程序启动的时候会在RabbitMQ的Exchange中创建一个input
    的Exchange交换器,但由于Binder的隔离作用，应用程序不知道它的存在,它只知道自己指向的Binder输入或输出通道。
4.启动多个不同端口的应用实例，查看RabbitMQ中channel信息,见图1,2,3
5.为不同应用实例设置消费组,防止消息的重复消费;效果见图4,5
6.另外,stream还可是设置消息分区功能

测试方法:
1.启动RabbitMQ服务(按默认设置即可)
2.启动多个Stream-hello的实例
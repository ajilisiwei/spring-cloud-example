1.网关服务--面向服务的路由方式
2.服务路由配置
   (1).简写
        zuul.routes.hello-service=/hello-service/**
        等效于：
        zuul.routes.hello-service.path=/hello-service/**
        zuul.routes.hello-service.serviceId=hello-service
   (2).服务路由的默认规则
        zuul.routes.hello-service.path=/hello-service/**
        zuul.routes.hello-service.serviceId=hello-service
        这是Eureka服务注册机制为每个已注册服务添加的一个默认路由规则，此时所有的服务均被添加了映射关系，如不希望服务被外界访问，
        可添加zuul.ignored-services参数来忽略它，如zuul.ignored-services=*则表示所有的注册服务均不创建默认路由映射规则
3.增加请求过滤
   (1).增加AccessFilter类并继承ZuulFilter类
   (2).重写run方法,并实现对请求的拦截和过滤
   (3).改写应用主类，为过滤类创建具体的Bean
4.测试:
    (1).启动eureka-server
    (2).启动server-provider
    (3).启动feign-consumer
    (3).启动api-gateway2

    请求url分别为：
        api-a: http://desktop-flis9e6:5555/api-a/hello
        api-b: http://desktop-flis9e6:5555/api-b/feign-consumer
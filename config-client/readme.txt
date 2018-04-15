1.测试
    (1).启动config-server项目
    (2).启动config-client项目
    测试url : http://localhost:7002/from

2.除了通过@Value注解绑定注入之外，还可通过Environment对象来获得配置属性
    @RefrshScope
    @RestController
    public class TestController{
        @Autowired
        private Enviroment env;

        @RequestMapping("/from")
        public String from(){
            return env.getProperty("from","undefined")
        }
    }
3.引入eureka依赖，进行服务注册
4.快速失败响应和重试
    (1).引入spring-retry和spring-boot-starter-aop
    (2).增加相应配置(见配置文件)
5.动态刷新配置
    (1).引入spring-boot-starter-actuator依赖
    (2).修改git仓库配置文件,以POST方式请求http://localhost:7002/refresh进行刷新,并重新请求配置信息
6.引入spring-cloud-bus使用RabbitMQ消息代理来实现高可用配置中心多个实例配置信息动态刷新
    (0).安装好RabbitMQ服务并启动
    (1).添加spring-cloud-bus-amqp
    (2).增加RabbitMQ服务器配置信息(见配置文件)
    (3).启动不同客户端实例，通过POST请求向其中一个实例发送/bus/refresh请求，查看其它实例配置信息是
        否变化;另外,优化方案可以改用将config-server也加入bus中,通过向config-server
        (比如/bus/refresh?destination=指定的服务或实例)发送刷新配置的post请求来实现配置刷新(也可以通
        过Git仓库的Web Hook来自动触发)
7.在config-server和config-client工程引入spring-cloud-starter-bus-kafka模块实现kafka消息代理机制,
    将spring-cloud-starter-bus-amqp换成spring-cloud-starter-bus-kafka;均采用默认配置实现。确认
    本地的kafka和zookeeper服务已安装并可正常使用,启动完成可看到springCloudBus的Topic
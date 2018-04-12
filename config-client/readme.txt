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
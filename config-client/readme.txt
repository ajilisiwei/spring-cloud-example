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
1.准备一个存放配置文件的git仓库
    这里用:https://github.com/ajilisiwei/configserver.git
2.准备的配置文件如下
    configserver.properties
    configserver-dev.properties
    configserver-test.properties
    configserver-prod.properties
    配置内容分别为:
    from=git-default-1.0
    from=git-dev-1.0
    from=git-test-1.0
    from=git-prod-1.0
3.新建一个配置文件的分支:config-lable-test
    配置文件信息如下:
        configserver.properties
        configserver-dev.properties
        configserver-test.properties
        configserver-prod.properties
        配置内容分别为:
        from=git-default-2.0
        from=git-dev-2.0
        from=git-test-2.0
        from=git-prod-2.0
4.访问配置信息的url与配置文件的映射关系如下:
    1./{application}/{profile}[/{label}]
    2./{application}-{profile}.yml
    3./{label}/{application}-{profile}.yml
    4./{application}-{profile}.properties
    5./{label}/{application}-{profile}.properties
5.测试
  启动项目,进行测试:http://localhost:7001/configserver/prod/config-label-test
  测试结果见configserver1;由configserver2中的打印信息可以看出,spring-cloud-config还会在本地暂存一个配置仓库
6.增加安全保护
    spring-boot-starter-security
7.服务化配置中心;引入eureka,将config-server注册为服务
8.另外还可以实现配置中心的加密解密和高可用配置
# seata-mp-spring-boot-starter
自动使用seata代理数据源后让mybatisplus注入被代理的数据源

yml类似配置入下:

```yaml
spring:
   datasource:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://127.0.0.1:3306/test?userSSL=true&useUnicode=true&characterEncoding=UTF8&serverTimezone=Asia/Shanghai
      username: root
      password: 123456   
```


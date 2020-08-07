# 微服务

<a name="0cNXj"></a>
# 基础

---

<a name="JHYhd"></a>
## 一、搭建环境
<a name="tBJXN"></a>
### 1.1 安装Nacos
> 下载解压启动
> bin/startup.sh -m standalone
> 访问
> ip:8848/nacos/#/login

<a name="PXxZ2"></a>
### 1.2 构建环境
创建环境，引入依赖
```xml
    <!--  只声明依赖，不引入依赖  -->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>2.2.0.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```
<a name="YB8KD"></a>
## 二、开始
<a name="l5GOV"></a>
### 2.1 服务注册
<a name="XnGCm"></a>
#### 2.1.1 引入依赖
```xml
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
    </dependencies>
```
<a name="HYf1u"></a>
#### 2.1.2 启动nacos 客户端
```java
@SpringBootApplication
@EnableDiscoveryClient
public class UserManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserManagerApplication.class,args);
    }
}
```
<a name="HPGEO"></a>
#### 2.1.3 配置文件
位置在:src\main\resources\application.yml
```yaml
spring:
  cloud:
    nacos:
      discovery:
        server-addr: 192.168.88.51:8848
  application:
    name: ordermanager
server:
  port: 8080
```
<a name="eOKEu"></a>
### 2.2 配置中心
<a name="E9Hmh"></a>
#### 2.2.1 引入依赖
```xml
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
```
<a name="Hw7Zc"></a>
#### 2.2.2 配置
在src\main\resources创建配置文件 bootstrap.yml
```yaml
spring:
  application:
    name: ordermanager
  cloud:
    nacos:
      config:
        server-addr: 192.168.88.51:8848
```
<a name="qLXFC"></a>
#### 2.2.3 发布配置
在nacos 中发布 Data Id 为**`${appllication-name}`.`${file-extension}`**   的配置文件
```java
user.id=1
user.name=james
user.age=23
```
<a name="1wvVt"></a>
#### 2.2.4 注入配置
```java
@RestController
@RefreshScope //实时刷新
public class SampleCroller {
    @Value("${user.name}")
    String userName;
    @Value("${user.age}")
    int age;

    @RequestMapping("/user")
    public String simple() {
        return "Hello Nacos Config!" + "Hello " + userName + " " + age ;
    }
}
```
<a name="Dz1LB"></a>
### 2.3 服务调用
<a name="s0uX2"></a>
#### 2.3.1 引入依赖
```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
            <version>2.2.2.RELEASE</version>
        </dependency>
```
<a name="qf7HE"></a>
#### 2.3.2 启用openfien 客户端
```java
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserManagerApplication.class,args);
    }
}
```
<a name="TcMvF"></a>
#### 2.3.3 服务调用
客户端代码
```java
@Component
@FeignClient("ordermanager")
public interface OrderManager {
    @RequestMapping("/user")
    public String getConfig();
}
```
服务端代码
```java
@RestController
@RefreshScope
public class SampleCroller {
    @Value("${user.name}")
    String userName;
    @Value("${user.age}")
    int age;

    @RequestMapping("/user")
    public String simple() {
        return "Hello Nacos Config!" + "Hello " + userName + " " + age ;
    }
}
```
<a name="8tCs0"></a>
### 2.4 服务网关


<a name="nAVLE"></a>
#### 2.4.1 引入依赖
```xml
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
            <version>2.2.2.RELEASE</version>
            <exclusions>
                <exclusion>
                    <artifactId>spring-web</artifactId>
                    <groupId>org.springframework</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>spring-boot-starter-webflux</artifactId>
                    <groupId>org.springframework.boot</groupId>
                </exclusion>
            </exclusions>
        </dependency>
```
<a name="QLvbV"></a>
#### 2.4.2 配置路由
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: test_route
          uri: https://www.baidu.com
          predicates:
            - Query=url,baidu

        - id: qq_route
          uri: https://www.qq.com
          predicates:
            - Query=url,qq
```

<br />


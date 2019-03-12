# tode-cloud

## Introduction
tode-cloud，基于Spring Boot、Spring Cloud框架的微服务，用于服务管理的config、service管理、路由、熔断等服务。 

``` 
  tode-cloud-config 
  config管理服务，为其他微服务提供配置项
```
```
  tode-cloud-register 
  服务注册server，基于eureka server,为其他微服务提供服务注册与发现服务，配置从tode-cloud-config服务获取
```

```
  tode-cloud-demoservice 
  微服务service demo，用来提供service
```
```
  tode-cloud-democlient 
  微服务client demo，用来模拟请求微服务的客户端
  使用Hystrix组件实现熔断、输出/hystrix.stream到dashboard
  增加了使用Netflix Ribbon的api进行LoadBalancer调用servcie的功能。
```
```
  tode-cloud-hystrixdashboard
  微服务hystrix-dashboard组件，用于展示hystix-client提供的/hystrix.stream流。
```
```
  tode-cloud-demoservice2
  微服务service demo，复制自tode-cloud-demoservice，用于提供与tode-cloud-demoservice同名的service
  在client中，使用Netflix Ribbon的api进行LoadBalancer调用
```
```
  Spring Cloud integrates Ribbon and Eureka to provide a load balanced http client when using Feign.
  1. tode-cloud-democlient 增加 spring-cloud-starter-feign 依赖
  2. client服务中增加 @FeignClient 注解的接口，接口中的方法请求服务提供方的接口
  3. client服务调用 @FeignClient 接口中的方法，Feign创建Ribbon load balancer，调用Eureka中对应的服务。
  4. 若要即成Hystrix Fallbacks，需要增加feign.hystrix.enabled=true，同时实现@FeignClient注解的接口，增加fallback的方法。
```

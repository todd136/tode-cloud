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
``'
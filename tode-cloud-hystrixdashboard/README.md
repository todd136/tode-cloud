# tode-cloud-hystrixdashboard

## Introduction
tode-cloud-hystrixdashboard，基于spring-cloud-netflix组件，使用hystrix-dashboard构建本地dashboard。 

监听Hystrix client提供出来的的/hystrix.stream

When connecting to a /hystrix.stream endpoint which uses HTTPS the certificate used by the server must be 
trusted by the JVM. If the certificate is not trusted you must import the certificate into the JVM in order for the 
Hystrix Dashboard to make a successful connection to the stream endpoint.

## 
// todo 增加turbine，集中管理相关服务的 /hystrix.stream
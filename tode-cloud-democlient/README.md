# tode-cloud-democlient

## Introduction
tode-cloud-democlient，基于spring-cloud-config、spring-cloud-netflix组件，模拟服务调用方。 

使用hystrix增加熔断功能，使用actuator输出/hystrix.stream到dashboard

Hystrix command and fallback方法应该同一个类中，同样的方法签名，仅可加异常处理的额外参数。
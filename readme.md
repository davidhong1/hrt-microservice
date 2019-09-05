# 在开始项目之前
先准备如下环境和工具
- Git
- Java8
- maven
- docker、docker-compose
- IDEA

# 基础服务

|服务|服务名|端口|地址|账号和密码|备注
|-----|-----|------|------|-----|-----|
|数据库|MySQL|3307|http://127.0.0.1|用户: root 密码: 123456|cloud.app.user使用hrt_user数据库;cloud.app.device使用hrt_device数据库;
|KV缓存|Redis|6380|http://127.0.0.1|密码: 123456|共用
|消息中间件|RabbitMq|5673|http://127.0.0.1:15672|用户: rabbitmq 密码: 123456|共用

# 项目说明

|项目分类|项目名|依赖基础服务|简介|应用地址|文档
|-----|-----|-----|-----|-----|-----|
|common|core|无|通用的bean和工具类|jar包导入|[core公共项目](https://github.com/HYUANT/hrt-microservice/tree/master/common/core)
| |web|core|web相关的通用bean、通用常量类、通用异常处理代码处理、拦截器、通用feign provider等|jar包导入|[web公共项目](https://github.com/HYUANT/hrt-microservice/tree/master/common/web)
|cloud.center|eureka|无|注册中心|http://127.0.0.1:9000/login 账号: hrt-eureka 密码: 123456|[注册中心文档](https://github.com/HYUANT/hrt-microservice/tree/master/cloud/center/eureka)
| |bus|无|消息中心|http://127.0.0.1:9005|[消息中心文档](https://github.com/HYUANT/hrt-microservice/tree/master/cloud/center/bus)
| |config|无|消息中心|http://127.0.0.1:9010|[配置中心文档](https://github.com/HYUANT/hrt-microservice/tree/master/cloud/center/config)
|cloud.gateway|gateway|无|网关|http://127.0.0.1:8443|[网关中心文档](https://github.com/HYUANT/hrt-microservice/tree/master/cloud/gateway)
|cloud.monitor|admin|RabbitMq|总体监控|http://127.0.0.1:9015/login 账号: admin 密码: 123456|[监控中心文档](https://github.com/HYUANT/hrt-microservice/tree/master/cloud/monitor)
| |hystrix-dashboard|RabbitMq|性能指标展示|http://127.0.0.1:9016|
| |turbine|RabbitMq|性能指标收集|http://127.0.0.1:9016|
|app|user|MySQL、Redis|用户权限处理|http://127.0.0.1:9020|[权限中心文档](https://github.com/HYUANT/hrt-microservice/tree/master/cloud/app/user)
| |device|MySQL、Redis|设备服务-普通服务|http://127.0.0.1:9021|[设备服务文档](https://github.com/HYUANT/hrt-microservice/tree/master/cloud/app/device)

# 快速开始
## 安装common项目依赖
项目目录下执行命令
```
cd common && mvn clean install && cd ../docker-compose`
```

## 启动基础服务 MySQL、Redis、RabbitMq
```
docker-compose up -d
```

## 编译和启动center服务
### 打包center服务
```
sh package.center.sh
```

详见package.center.sh脚本

### 启动center docker服务
eureka、config、bus
```
docker-compose -f docker-compose.center.yml up -d
```

## 编译和启动monitor服务
### 打包monitor服务
```
sh package.monitor.sh
```

### 启动monitor docker服务
admin、hystrix-dashboard、turbine
```
docker-compose -f docker-compose.monitor.yml up -d
```

## 编译和启动gateway服务
### 打包gateway服务
```
sh package.gateway.sh
```

### 启动gateway docker服务
```
docker-compose -f docker-compose.gateway.yml up -d
```

# 测试
## 注册测试
![注册测试](https://github.com/HYUANT/hrt-microservice/tree/master/doc/signUp.png)
![注册测试结果](https://github.com/HYUANT/hrt-microservice/tree/master/doc/signUpResult.png)
## 登录测试
![登录测试](https://github.com/HYUANT/hrt-microservice/tree/master/doc/login.png)
![登录测试结果](https://github.com/HYUANT/hrt-microservice/tree/master/doc/loginResult.png)

# 停止和删除docker

## 停止和删除docker容器

```
docker-compose -f docker-compose.center.yml -f docker-compose.monitor.yml -f docker-compose.gateway.yml down
```

### 删除基础服务(慎用)
```
docker-compose -f docker-compose.yml down
```

## 删除所有docker镜像
```
docker rmi $(docker images -q)
```

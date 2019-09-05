## 安装common依赖
`cd common && mvn clean install && cd ../docker-compose`

## 启动基础服务
MySQL、Redis、rabbitmq

`docker-compose up -d`

## 编译和启动center服务
### 打包center服务
`sh package.center.sh`

### 启动center docker服务
eureka、config、bus

`docker-compose -f docker-compose.center.yml up -d`

## 编译和启动monitor服务
### 打包monitor服务
`sh package.monitor.sh`

### 启动monitor docker服务
admin、hystrix-dashboard、turbine

`docker-compose -f docker-compose.monitor.yml up -d`

## 编译和启动gateway服务
### 打包gateway服务
`sh package.gateway.sh`

### 启动gateway docker服务
`docker-compose -f docker-compose.gateway.yml up -d`


## 停止和删除docker容器

`docker-compose -f docker-compose.center.yml -f docker-compose.monitor.yml -f docker-compose.gateway.yml down`

### 删除基础服务(慎用)
`docker-compose -f docker-compose.yml down`

## 删除所有docker镜像(慎用)
`docker rmi $(docker images -q)`

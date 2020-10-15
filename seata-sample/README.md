# spring-cloud-alibaba-samples
## 准备环境
* 启动 Nacos server <br>
[Nacos Server 下载地址](https://github.com/alibaba/nacos/releases)
>下载最新版本Nacos Server, 本地启动Nacos

* 启动Seata Server <br>
[Seata Server 下载地址](https://github.com/seata/seata/releases)
> 下载最新版本Seata Server, 本地启动Seata

## 使用组件介绍
* Nacos 注册中心
* Nacos 配置中心
* Dubbo RPC 服务调用
* Open Feign REST 服务调用
* Sentinel 限流熔断
* Seata 分布式事务解决方案
## 项目目录介绍
* sca-common <br>
`项目公用模块（实体类，Dubbo Api等）`
* sca-customer 消费者
* sca-provider 服务提供者

## 容器内部脚本说明(/seata-server/resources/README-zh.md)
## client [文档地址](https://github.com/seata/seata/tree/develop/script/client) 

> 存放用于客户端的配置和SQL

- at: AT模式下的 `undo_log` 建表语句
- conf: 客户端的配置文件
- saga: SAGA 模式下所需表的建表语句
- spring: SpringBoot 应用支持的配置文件

## server [文档地址](https://github.com/seata/seata/tree/develop/script/server)

> 存放server侧所需SQL和部署脚本

- db: server 侧的保存模式为 `db` 时所需表的建表语句
- docker-compose: server 侧通过 docker-compose 部署的脚本
- helm: server 侧通过 Helm 部署的脚本
- kubernetes: server 侧通过 Kubernetes 部署的脚本

## config-center [文档地址](https://github.com/seata/seata/tree/develop/script/config-center)

> 用于存放各种配置中心的初始化脚本，执行时都会读取 `config.txt`配置文件，并写入配置中心

- nacos: 用于向 Nacos 中添加配置
- zk: 用于向 Zookeeper 中添加配置，脚本依赖 Zookeeper 的相关脚本，需要手动下载；ZooKeeper相关的配置可以写在 `zk-params.txt` 中，也可以在执行的时候输入
- apollo: 向 Apollo 中添加配置，Apollo 的地址端口等可以写在 `apollo-params.txt`，也可以在执行的时候输入
- etcd3: 用于向 Etcd3 中添加配置
- consul: 用于向 consul 中添加配置
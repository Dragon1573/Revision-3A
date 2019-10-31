# 第八章　OpenStack开源虚拟化平台

1. **OpenStack**是什么？
   > **OpenStack**是一个管理计算、存储和网络资源的云计算开放平台。
2. 总结**OpenStack**的主要组件及其功能。
   > |   组件   |                    功能                     |
   > |:--------:|:-----------------------------------------:|
   > |   Nova   |                提供计算服务                 |
   > |  Swift   |              提供对象存储服务               |
   > |  Glance  |    提供一个虚拟硬盘镜像的目录和存储仓库     |
   > | KeyStore | 为**OpenStack**上所有服务提供身份认证和授权 |
   > |  Cinder  |               提供块存储服务                |
   > | Horizon  |                 提供Web界面                 |
3. 请根据学过的知识总结以下个服务模块之家如何协同工作。
   > **OpenStack**各组件之间是松耦合的，通过一个符合*AMOP*协议的消息队列*RabbitMQ*进行组件之间的通信。*RabbitMQ*是**OpenStack**的信息交换中枢，有交换器、队列等概念，实现组件间信息的存储和转发。
4. 请通过学过的知识概括一下**OpenStack**与**AWS**的异同。
   > <table style="text-align: center;">
   > <tr><th>OpenStack</th><th>AWS</th></tr>
   > <tr><td>开源</td><td>闭源</td></tr>
   > <tr><td>私有云</td><td>公有云</td></tr>
   > <tr><td colspan="2">架构和功能相似</td></tr>
   > </table>

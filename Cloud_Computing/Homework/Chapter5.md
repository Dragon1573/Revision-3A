# 第五章　Hadoop 2.0：主流开源云架构

1. 简述**Hadoop 1.0**和**Hadoop 2.0**的优缺点，并比较二者区别与联系。
   > *Hadoop 1.0*由*HDFS*和*MapReduce*组成，其中*HDFS*由一个*NameNode*和多个*DataNode*组成，*MapReduce*由一个*JobTracker*和多个*TaskTracker*组成。
   >
   > *Hadoop 2.0*针对*Hadoop 1.0*单*NameNode*制约*HDFS*拓展性问题，提出*HDFS Federation*，让多个*NameNode*分管不同的目录进而实现访问隔离和横向拓展，同时彻底解决*NameNode*单点故障的问题。
2. 简述解压包方式部署**Hadoop**的弊端。
   > 要求用户对*Linux*较为熟悉，在逐个解压、配置*Hadoop*组件的过程中，步骤较多、繁琐且易出错。
3. 简述**Hadoop 2.0**安全机制，试分析其优缺点。
   > 系统安全机制由**认证**和**授权**两部分组成，*Hadoop 2.0*认证采用*Kerbero*和*Token*两种方案，二授权则通过访问控制列表实现。
4. 简述**Yarn编程**过程，再简述**MR编程**过程，说明二者有何关系。
   > *Yarn*由*RM*和*NM*组成，*RM*、*NM*不参与计算逻辑，计算逻辑代码由*Application Master*和*Client*实现，具体计算则由*Application Master*和*Container*完成。在资源框架中，*RM*负责资源分配、*NM*管理本地资源；在计算框架中，*Client*负责提交任务，*RM*启动任务对应的*Application Master*，*Application Master*在向*RM*申请资源，并与*NM*协商启动*Container*任务。
   >
   > *Yarn*是资源框架，*MR*是旗下的编程模板。
5. 试从架构上分析**Hadoop**的优缺点。
   > |   优点   |                缺点                |
   > |:------:|:----------------------------------:|
   > | 高可靠性 | 主从结构并发访问较多时存在性能问题 |
   > | 高扩展性 |          存在单点故障问题          |
   > |  高效性  |                                    |
   > | 高容错性 |                                    |

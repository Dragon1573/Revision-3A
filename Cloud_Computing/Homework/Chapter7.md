# 第七章　虚拟化技术

1. 虚拟化技术在云计算的哪些地方发挥了关键作用？
   > 在数据中心虚拟化，通过服务器虚拟化、存储虚拟化和网络虚拟化实现的。
2. 比较 *VMWare*、*Xen* 等虚拟化产品的关键技术，以及对云计算体术提供的支持。
   > *VMWare* 的网络虚拟化技术主要是通过 *VMWare VSphere* 中的 *VNetwork* 网络实现的。
   >
   > *Xen* 可保证所有的物理内存可任意分配给不同的 *LuestVs*。
3. 服务器虚拟化、存储虚拟化和网络虚拟化都有哪些实现方式？
   > 服务器虚拟化的实现方法有：**寄居虚拟化**、**裸机虚拟化**。
   >
   > 存储虚拟化实现方法有基于**主机**、**存储设备**、**网络**三种。
4. 讨论桌面虚拟化的实现和作用。

   > | 实现                                               | 作用                                   |
   > |:--------------------------------------------------:|:--------------------------------------:|
   > | 利用虚拟化技术将用户桌面的镜像文件才能放到数据中心 | 用户获得完整的PC使用体验               |
   > | 终端用户通过虚拟显示协议访问他们的桌面系统         | 管理员仅维护部署在中心服务器的系统即可 |
# 基于成本的优化
## 条查询语句的执行成本是由下边这两个方面组成的
### I/O成本
查询表中的记录时，需要先把数据或者索引加载到内存中然后再操作。这个从磁盘到内存这个加载的过程损耗的时间称之为I/O成本。
### CPU成本
读取以及检测记录是否满足对应的搜索条件、对结果集进行排序等这些操作损耗的时间称之为CPU成本。

### 查询成本
查询成本=I/O成本+CPU成本

### Innodb引擎的成本常数
- 对于InnoDB存储引擎来说，页是磁盘和内存之间交互的基本单位，设计MySQL的大叔规定读取一个页面花费的成本默认是1.0，读取以及检测一条记录是否符合搜索条件的成本默认是0.2。
- 1.0、0.2这些数字称之为成本常数

## 基于成本的优化步骤
1. 根据搜索条件，找出所有可能使用的索引
2. 计算全表扫描的代价
3. 计算使用不同索引执行查询的代价
4. 对比各种执行方案的代价，找出成本最低的那一个


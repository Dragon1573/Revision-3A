# 第1课

## 习题

1. 设有3个传教士和3个野人来到河边，打算乘一条船从右岸渡到左岸去。该船的负载能力为2人。在任何时候，如果野人人俗超过传教士人数，那么野人就会把传教士吃掉。如何用状态空间法来表示该问题？给出具体的状态表示和算符。

   > 状态由一个三元组$(a, b, c)$表示，其中：
   > - $a$表示右岸的传教士人数，$a \in \\\{ 1,2,3 \\\}$
   > - $b$表示右岸的野人数量，$b \in \\\{ 1,2,3 \\\}$
   > - $c$表示船的方位，当船在右岸时$c=1$，当船在左岸时$c=0$
   >
   > 根据定义，初始状态为$(3,3,1)$，目标状态为$(0,0,0)$。
   >
   > 定义10种算符，分别是：`aHumanGo()`、`aHumanBack()`、`twoHumanGo()`、`twoHumanBack()`、`bothGo()`、`bothBack()`、`twoMonsterGo()`、`twoMonsterBack()`、`aMonsterGo()`、`aMonsterBack()`。
   >
   > 要求`go()`与`back()`必须交替执行。
   >
   > 具体状态空间表示为：
   >
   > ```text
   > (3, 3, 1)
   > -> twoMonsterGo() -> (3, 1, 0) -> aMonsterBack()
   > -> (3, 2, 1)
   > -> twoMonsterGo() -> (3, 0, 0) -> aMonsterBack()
   > -> (3, 1, 1)
   > -> twoHumanGo() -> (1, 1, 0)  -> bothBack()
   > -> (2, 2, 1)
   > -> twoHumanGo() -> (0, 2, 0) -> aMonsterBack()
   > -> (0, 3, 1)
   > -> twoMonsterGo() -> (0, 1, 0) -> aMonsterBack()
   > -> (0, 2, 1)
   > -> twoMonsterGo() -> (0, 0, 0)
   > ```

package com.nielsen.chapterfour

import scala.collection.mutable

object MapAndTuple {

  //映射和元组
  def main(args: Array[String]): Unit = {
    //构造映射
    val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)//不可变映射
    val score  = Map(("Alice", 10),("Bob", 3),("Cindy", 8))

    var score2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)//可变映射
    val score3 = new mutable.HashMap[String, Int]//空映射 给出类型参数

    //获取映射中的值
    var bobsScore = scores("Bob")//类似java中的scores.get("Bob")
    println(bobsScore)
    bobsScore = if(scores.contains("Bob")) scores("Bob") else 0//检查映射中是否有某个指定的键
    println(bobsScore)
    bobsScore = scores.getOrElse("Bob", 0)//快捷写法
    println(bobsScore)

    //更新映射中的值
    score2("Bob") = 10//更新Bob对应的值
    score2("Fred") = 7

    //+=添加多个关系
    score2 += ("Bob" -> 10, "Fred" -> 7)
    //-=移除键和值
    score2 -= "Alice"

    val newScores = scores + ("Bob" -> 10, "Fred" -> 7)//更新过的新映射

    //迭代映射
    scores.keySet
    for (v <- scores.values) println(v)

    //元组 各组元从1开始, 而不是0. 用方法 _1, _2, _3访问其组元
    val t = (1, 3.14, "Fred")

    val second = t._2
    val second1 = t _2

    //元祖可以用于函数需要返回不止一个值得情况。分别包含了满足某个条件和不满足该条件的字符
    val a = "New York".partition(_.isUpper)
    println(a)

    //拉链操作：多值绑定，一起处理
    val symbol = Array("<","-",">","=")
    val counts = Array(2, 10, 2)
    val pairs = symbol.zip(counts)
    println(pairs.toMap)

    for((s,n) <- pairs) print(s * n)//会打印：<<---------->>

    println("<" * 2)

    //toMap方法可以将对偶的集合转换成映射

    //如果有一个键的集合，以及一个与之平行对应的值的集合
    //那就可以用拉链操作将它们组合成一个映射
    //keys.zip(values).toMap

  }

}

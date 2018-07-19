package com.nielsen.chapter.three

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Buffer
import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.JavaConversions.asScalaBuffer

object ArrayLearning {

  def main(args: Array[String]): Unit = {

    //----------------遍历数组-------------------//
    val arr1 = Array(1,2,3,4,5,6,7,8)
//    for(i <- 0 until arr1.length) println(i + ":" + arr1(i))

    //for(i <- 0 to arr1.length - 1) println(i + ":" + arr1(i))

//    for(i <- 0 until (arr1.length , 2)) println(i + ":" + arr1(i))

//    for(i <- (0 until arr1.length).reverse) println(i + ":" + arr1(i))

//    for(i <- (0 until (arr1.length,2) ).reverse) println(i + ":" + arr1(i))

//    for(i <- arr1.reverse) println(i)  //类似java的增强for循环



    //----------------数组转换-------------------//
    val arr2 = Array(3,5,6,8,9,10)
//    val result = for(elm <- arr2) yield elm * 2

//    val result = for(elm <- arr2 if elm % 2 == 0) yield elm * 2     //守卫

//    val result = arr2.filter(_ % 2 == 0).map(2 * _)
//    val result = arr2.filter { _ % 2 == 0 } map { 2 * _ }
//    for(i <- result) println(i)


    //--------------移除数组中除了第一个负数外的所有的负数-------------//
    //方法一
    /*val arr3 = ArrayBuffer(2,-8,-2,4,6,3,-7,9,-11,13)
    var first = true
    var i = 0
    var n = arr3.length
    while(i < n) {
      if(arr3(i) >=0 ) i += 1
      else {
        if(first) { first = false ; i += 1}
        else { arr3.remove(i) ; n -= 1}
      }
    }
    for(i <- arr3) println(i)*/

    //方法二
    /*val arr3 = ArrayBuffer(2,-8,-2,4,6,3,-7,9,-11,13)
    var first = true
    val indexs = for(i <- 0 until arr3.length if first || arr3(i) >= 0) yield {
      if(arr3(i) < 0) first = false ; i
    }
      println(indexs.mkString(","))

    for(j <- 0 until indexs.length) arr3(j) = arr3(indexs(j))
    arr3.trimEnd(arr3.length - indexs.length)
    for(i <- arr3) println(i)*/

    //--------------常用算法-------------//
    /*val res1 = Array(2,4,6,8).sum
    val res2 = ArrayBuffer(3,5,7,3,5).sum
    println("res1 = " + res1 + ", res2 = " + res2)

    val arr4 = ArrayBuffer("Tom","Mike","Big","Small","Little","Scala")
    val res3 = arr4.max
    val res4 = arr4.min
    println("res3 = " + res3 + ", res2 = " + res4)

    val arr5 = ArrayBuffer(3, 2, 1, 4)
//    val res5 = arr5.sorted
    val res5 = Array(2,4,6,8).sortWith(_ > _)

    println(res5.mkString(","))


    val arr6 = Array(5,7,3,1)
    scala.util.Sorting.quickSort(arr6)
    for(i <- arr6) println(i)

    //区别sorted 和 sortWith不改变数组   quickSort改变了原来的数组


    println(arr6.mkString(" and "))   // print(arr6)
    println(arr5.mkString("<" , "," , ">"))  //print(arr5)*/

    //--------------多维数组-------------//
//    val matrix = new Array[Array[Double](3)](4)   不能这么写
    val matrix = Array.ofDim[Double](3,4)  //定义一个3行4列的多维数组
    println(matrix(2)(1))

    val triangle = new Array[Array[Int]](10)   //定义一个不规则数组  每行的长度不想通
    for(i <- 0 until triangle.length) triangle(i) = new Array[Int](i + 1)
//      println(triangle(0)(1))

    //   1
    //   1 2
    //   1 2 3
    //  .......

    //--------------与java互操作-------------//
    val command = ArrayBuffer("aa","bb","cc","dd")

    val pb = new ProcessBuilder(command)     //scala到java的转换

    val cmd: Buffer[String] = pb.command()    //java到scala的转换
    //ProcessBuilder构造需要java.util.List对象，我们通过导入隐式转换，ArrayBuffer对象会自动转换为java.util.List对象，
    // 反之pb.command()返回的是java.util.List对象，通过隐式转换，自动转换为Buffer对象。


  }

}

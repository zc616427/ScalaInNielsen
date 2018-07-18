package com.nielsen.method

object CollectAndMap {
  def main(args: Array[String]): Unit = {
    List(1, 3, 5, "seven").filter(_ == 1). map { case i: Int => i + 1 }
    println(List(1, 3, 5, "seven") collect { case i: Int => i + 1 })
  }

}

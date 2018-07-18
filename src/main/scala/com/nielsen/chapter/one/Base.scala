package com.nielsen.chapter.one

import java.text.MessageFormat

object Base extends App {
  def testApply(): Unit = {
    val a = "Hello"(1)
    val b =BigInt("15643513456")
  }

  def testSymbol(): Unit = {
    var a = 10
    val b = 20
    var c = 0

    c = a + b
    println("c = a + b  = " + c)

    c += a
    println("c += a  = " + c)

    c -= a
    println("c -= a = " + c)

    c *= a
    println("c *= a = " + c)

    a = 10
    c = 15
    c /= a
    println("c /= a  = " + c)

    a = 10
    c = 15
    c %= a
    println("c %= a  = " + c)

    c <<= 2
    println("c <<= 2  = " + c)

    c >>= 2
    println("c >>= 2  = " + c)

    c >>= 2
    println("c >>= a  = " + c)

    c &= a
    println("c &= 2  = " + c)

    c ^= a
    println("c ^= a  = " + c)

    c |= a
    println("c |= a  = " + c)
  }

  def testFor(): Unit ={
//    for(a<-1 to 10){
//      print(a)
//    }
//
//    for(b<- "HELLO WORLD"){
//      println(b)
//    }
//
//    val c=Array(1,2,3,4,5,6)
//    for(d <- 0 until c.length){
//      println(d)
//    }

    for(i <- 1 to 3; j<- 1 to 3 if i==j) {
      print((10*i+j)+" ")
    }
  }

  def abs(x : Double) = if(x > 0) x else -x
//  testFor()

  val mes = MessageFormat.format("The answer to {0} is {1}","everything",42.asInstanceOf[AnyRef])
  print(mes)



}
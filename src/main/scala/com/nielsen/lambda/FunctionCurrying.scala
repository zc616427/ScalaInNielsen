package com.nielsen.lambda

object FunctionCurrying {

  /**
    * 函数柯里化的变化过程
    * @param a
    * @param b
    * @param c
    * @param d
    * @return
    */
  def func(a:Int,b:Int,c:Int,d:Int)=1
  def func1(a:Int)(b:Int)(c:Int)(d:Int)=a+b+c+d

  //1+b+c+d
  def funca = func1(1)_
  //1+2+c+d
  def funcab = func1(1)(2)_
  //1+2+3+d
  def funcabc = func1(1)(2)(3)_

  def func2=(a:Int)=>(b:Int)=>(c:Int)=>(d:Int)=>1

//  def sum(a:Int):(Int,Int)=>Int={
//    def sumb(b:Int,c:Int)=a+b+c
//    sumb
//  }

  def sum(a:Int):Int=>(Int=>Int)={
    def sumb(b:Int):Int=>Int={
      def sumc(c:Int)={
        a+b+c
      }
      sumc
    }
    sumb
  }

  def test1(a:Double,b:Double):Double={
    val next = (a+b/a)/2
    if(b-next*next>0.01|| next*next-b > 0.01) test1(next,b)
    next
  }

  def test2(f:(Double,Double)=>Double)(a:Double,b:Double):Double={
    val next = f(a,b)
    if(b-next*next>0.01|| next*next-b > 0.01) test2(f)(next,b)
    next
  }

  def testx(x:Double)=test(x,1)

  def test(a:Double,b:Double)={

    def f(guss:Double)={
      (guss+a/guss)/2
    }

    def checkAcc(next:Double)={
      (a-next*next)*(a-next*next) >= 0.00000001
    }

    def inTest(x:Double):Double={
      val next = f(x)
      if(checkAcc(next)) inTest(next)
      else next
    }

    inTest(b)

  }

  def sqrt(x:Double)={
    def isGoodEnough(guess:Double, x:Double)=
      ((guess * guess -x) < 0.0001*x) && ((guess * guess -x ) > -0.0001*x)

    def improve (guess:Double, x:Double)=
      (guess+ x/guess)/2

    def sqrtIter(guess:Double):Double=
      if(isGoodEnough(guess,x)) guess
      else sqrtIter(improve(guess,x))

    sqrtIter(1.0)
  }


  def main(args: Array[String]): Unit = {
    println(sum(1)(2)(3))
    println(sqrt(5))
    println(testx(5))

  }

}

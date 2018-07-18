package com.nielsen.contest

/**
  * //////////////////////
  * ///   2018-07-11   ///
  * ///    Tonny Wu    ///
  * //////////////////////
  *
  * You're given strings J representing the types of stones that are jewels,
  * and S representing the stones you have.
  * Each character in S is a type of stone you have.
  * You want to know how many of the stones you have are also jewels.
  *
  * The letters in J are guaranteed distinct,
  * and all characters in J and S are letters.
  * Letters are case sensitive,
  * so "a" is considered a different type of stone from "A".
  *
  * Example 1:
  *
  * Input: J = "aA", S = "aAAbbbb"
  * Output: 3
  * Example 2:
  *
  * Input: J = "z", S = "ZZ"
  * Output: 0
  * Note:
  *
  * S and J will consist of letters and have length at most 50.
  * The characters in J are distinct.
  * Entry Point:
  * object Solution {
  * def numJewelsInStones(J: String, S: String): Int = {
  *
  * }
  * }
  */
object JewelCount extends App{
  import scala.util.Properties
  Properties.setProp("scala.time","true")

//  342ms 376ms
//  println(Solution.numJewelsInStones("aA","aAAbbbbbbbbbbbbbbbbbbbbbb"))
//  452ms 506ms
//  println(Solution.numJewelsInStonesByPattern("aA","aAAbbbb"))
//  351ms 448ms
//  println(Solution.numJewelsInStonesByLoop("aA","aAAbbbb"))

  println(Solution.numJewelsInStonesByPattern2("aA","aAAbbbbbbbbbbbbbbbbbbbbbb"))

}

object Solution  {

  def numJewelsInStones(J: String, S: String): Int = {
    S.count(J.contains(_))
  }

  def numJewelsInStonesByPattern(J: String, S: String): Int = {
    val pattern = J.toSet.mkString("|").r
    (pattern findAllIn S).size
//    pattern.findAllIn(S).size
  }

  def numJewelsInStonesByPattern2(J: String, S: String): Int = {
    J.toSet
      .mkString("|")
      .r
      .findAllIn(S)
      .size
  }

  def numJewelsInStonesByLoop(J: String, S: String): Int = {

    var result = 0
    for(i <- J;j <- S if i == j)
      result += 1
    result
  }


}
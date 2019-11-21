package priv.cxs.study.nlp.maxmatch

import org.scalatest.FunSuite

/**
  * @author cuixiaoshuang
  * @date 2019-11-21
  **/
class MaxPostMatchTest extends FunSuite {

  test("testCut") {
    println(MaxPostMatch.cut("计算机科学",4))
  }

  test("testCut empty") {
    println(MaxPostMatch.cut("",4))
  }

  test("testCut right") {
    println(MaxPostMatch.cut("计算机科学",5))
  }

  test("testCut set = 0") {
    println(MaxPostMatch.cut("计算机科学",0))
  }

  test("testCut set = 1") {
    println(MaxPostMatch.cut("计算机科学是真的有点意思",1))
  }

  test("testCut long") {
    println(MaxPostMatch.cut("计算机科学是真的有点意思",5))
  }

  test("testCut chaos") {
    println(MaxPostMatch.cut("这简直是牛头不对马嘴",5))
  }

}

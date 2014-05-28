package org.zeus.scala.lesson1

/**
 * first lesson
 * 变量
 */
object FirstLesson {
  def main(args: Array[String]) {
    val answer = 8*5+2;
    println(answer);
    //不能给val类型的赋值
    //answer=3;
    var count = 0;
    println(count);
    count=1;
    println(count);
  }
}

package org.zeus.scala.lesson4

import scala.collection.mutable

/**
 * Mapping and Tuple
 * Created by Administrator on 2014/6/5.
 */
object LessonFourth {

	//构造映射 不可变集合
	val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
	//可变集合
	val scores2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
	//构造一个空的集合
	val scores3 = new mutable.HashMap[String,Int]
	//也可以这样构造
	val scores4 = Map(("Alice",10),("Bob",3),("Cindy",8))

	val bobscore = scores("Bob")//类似java中的get

	val bobscore2 = if (scores.contains("Bob")) scores("Bob") else 0//判断有没有这个key

	val bobscore3 = scores.getOrElse("Bob",0)//快捷写法

	val bobscore4 = scores.get("Bob") //调用返回一个Option对像

	scores2("Bob") = 10//更新Bob的值，必须是可变的
	scores2("Fred") = 7//增加新的key->value对偶到scores2
	scores2 += ("Bob" -> 10, "Fred" -> 7)//也可以这样来增加多个关系

	scores2 -= "Alice"


}

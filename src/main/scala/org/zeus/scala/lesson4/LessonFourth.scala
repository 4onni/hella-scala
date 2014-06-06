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
	//获得一个新的集合，并更新Bob的值，增加Fred的对偶
	val newScores = scores + ("Bob" -> 10, "Fred" -> 7)
	//也可以更新var变量
	var scores5 = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
	scores5 = scores5 + ("Bob" -> 10, "Fred" -> 7)
	//这样的效率并不低，老的和新的共享大部份结构。因为它们是不可变的。书上是如此说，但还是有些不太理解。
	scores5 = scores5 - "Alice"

	//迭代Map for ((k,v) <- Map) 处理k,v
	scores.keySet
	for(v <- scores.values) println(v)
	for((k,v) <- scores) yield (v,k)//反转k

	//scala默认实现Map是哈希表，如下得到一个不可变的树形Map,scala没有可变的树形Map(最接近的是java的TreeMap)
	var scores6 = scala.collection.immutable.SortedMap("Alice" -> 10, "Fred" -> 7,"Bob" -> 3, "Cindy" -> 8)

	//一个Tuple k-v是Tuple最简单的形式
	val t = (1,3.14,"Fred")
	//用_1 _2 _3这样访问 可以写成t._2和t _2，但是不能写成t_2 应该又是一个方法吧。
	val second = t._2
	//使用模式匹配来获取元组的值，模式匹配是啥？
	val (first,second2,third) = t
	//不是所有的部件都需要的话，可以写为_,其实不太能理解，这么写要干嘛?
	val (first1,second3,_) = t

	//zip操作
	val symbols = Array("<","-",">")
	val counts = Array(2,10,2)
	val pairs = symbols.zip(counts);
	//输出对偶的数组
	for((s,n) <- pairs) Console.print(s * n)
}

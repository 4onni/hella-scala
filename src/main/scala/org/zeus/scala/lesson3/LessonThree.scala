package org.zeus.scala.lesson3

/**
 *数组相关操作
 */
object LessonThree {

	def main(args: Array[String]) {
		//生成一个10个整数数组，所有元素初始为0
		val nums = new Array[Int](10);
		//字符串初始是null
		val a = new Array[String](10);
		//已提供初始值就不需要new 类型为推断出来的，其实是用了伴生对像的apply方法
		var s = Array("Hello", " World");
		//使用()而不是[]来访问元素
		s(0) = "Goodbye"
		import scala.collection.mutable.ArrayBuffer;
		//一个空的数据缓冲，准备存放整数 也可以new ArrayBuffer[Int]
		val b = ArrayBuffer[Int]();
		//+=在未尾加元素
		b += 1;
		//在未尾加多个用()括起来的元素
		b += (1,2,3,5)
		//用++=追加任何集合 当然也可以加入ArrayBuffer
		b ++= Array(8,13,21)
		//移除最后5个元素
		b.trimEnd(5)
		//在ArrayBuffer的未尾加或移除元素是一个高效的操作
		//在下标2之前插入数字6，操作不高效，所有在这个位置之后的元素必须被平移
		b.insert(2,6)
		b.insert(2,7,8,9)
		b.remove(2)
		b.remove(2,3)
		//转换成数组如果不知道数组的大小，可先构建ArrayBuffer再转换。
		b.toArray

		//用循环遍历数组 until产生一个不包含上限的Range
		for (i <- 0 until a.length) println(i+": " + a(i))

		0 until (a.length, 2) //Range(0,2,4)
		(0 until a.length).reverse//Range(....,3,2,1,0)

		//类型于java中foreach
		for( elem <- a) println(elem)

		//用for推导式遍历一个集合来产生一个新的集合
		val a1 = Array(2,3,5,7,11)
		//result is Array(4,6,10,14,22) 返回类型与遍历类型是一样的。
		var result = for (elem <- a1) yield 2*elem
		//满足特定条件可以用守卫比如去掉奇数结果是新集合，原始集合不会受到影响
		for(elem <- a1 if elem % 2 == 0) yield 2*elem
		//函数数编程风格。
		a1.filter(_ % 2 == 0).map(2 * _)
		a1.filter(_ % 2 == 0).map{2 * _}

		Array(1,2,3,5).sum
		ArrayBuffer("Mary","had","a","little","lamb").max
		val b1 = ArrayBuffer(1,7,2,9)
		val bSorted = b1.sorted(_ < _)//不知道为什么这里会报错。b1不变，bSorted是排过的
		val bDescending = b1.sorted(_ > _)
		var a2  = Array(1,7,2,9)
		scala.util.Sorting.quickSort(a);

		a2.mkString(" and ")//像是java中的join
		a2.mkString("<",",",">")//重载方式

		val matrix = Array.ofDim[Double](3,4)//3行4列(行)(列)

		//每个数组可以不一致
		val triangle = new Array[Array[Int]](10)
		for (i <- 0 until triangle.length)
			triangle(i) = new Array[Int](i + 1)


	}

}

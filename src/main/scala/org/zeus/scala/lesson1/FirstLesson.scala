package org.zeus.scala.lesson1
import scala.math._;
/**
 * first lesson
 * 变量
 */
object FirstLesson {
	def main(args: Array[String]) {
		val answer = 8 * 5 + 2;
		println(answer);
		//不能给val类型的赋值
		//answer=3;
		var count = 0;
		println(count);
		count = 1;
		println(count);
		//类型写在后面
		val geeting : String = null;
		val geeting1 : Any = "hello";
		println(1.toString);
		println(1.to(10));
		println("hello".intersect("World"));//输出lo

		1+2//算术操作符 a + b
		1.+(2)//实际上是一个方法 a.+(b) 上面例子中的1.to(10) 可以写为1 to 10
		1 to 10
		count+=1;
		count-=1;//scala没有++和--操作.

		val x: BigInt = 1234567890;
		println(x*x*x)//bigint也可以用常规方式使用操作符。

		println(sqrt(2));//scala提供的函数 需要导入scala.math._  符号_表示通配符，和java中的*差不多
		//scala没有静态方法，有个类似的特性叫单例对像singleton object,通常一个类具有一个伴生对像companion object
		//难到说有点类似javascript中的prototype对像?
		println("hello"(4));//相当于"hello".apply(4)方法，将输出o在StringOps类中有一个 def apply(n: Int): Char定义
		//越来越有点像javascript中的prototype了，难到暗示着伴生对像的方法在这个类的实例中都会具有？
		//apply方法又表示什么呢?


	}
}

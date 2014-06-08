package org.zeus.scala.lesson6

/**
 * Object
 * Created by Administrator on 2014/6/8.
 */
//单例对像，对像的成员相当于静态变量和方法
object Accounts{
	private var lastNumber = 0
	def newUniqueNumber() = {lastNumber +=1; lastNumber}
}
//一个类
class Account(val id: Int,initialBalance: Double) {
	private var balance = 0.0
	def deposit(amount: Double){balance += amount}
}
//Account类的伴生对像 可以和类相互访问私有特性。它们必须在同一个源文件中
object Account{
	private var lastNumber = 0
	private def newUniqueNumber() = {lastNumber +=1; lastNumber}
	//定义对像的apply方法
	def apply(initialBalance: Double){
		new Account(newUniqueNumber(),initialBalance)
	}
}

//一个抽像类
abstract class UndoableAction(val desc: String){
	def undo(): Unit
	def redo(): Unit
}

//object可以扩展一个类和多个特质
object DoNothingAction extends UndoableAction("Do Nothing"){
	override def undo(){}
	override def redo(){}
}

class Posts{

	var replyCount = 0;

	def replyIncrease() {replyCount+=1;replyCount}

}

class FinalPosts(val replyCount: Int = 0){


}

object Posts{
	def replyIncrease(oldPost: FinalPosts){
		var count = oldPost.replyCount
		count +=1;
		val newPost = new FinalPosts(count)
	}
}

object TrafficLightColor extends Enumeration{
	val Red,Yellow,Green = Value

	//Value方法返回Value内部类的实例,可以传入id和名称。
	val Red1 = Value(0,"Stop")
	val Yellow1 = Value(10)
	val Green1 = Value("Go")
	//枚举的类型。 TrafficLightColor.Value
	import TrafficLightColor._
	//定义一个type,这个目前还不知道是干啥用的。
	type TrafficLightColor = Value;

	TrafficLightColor(0)//调用Enumeration.apply()
	TrafficLightColor.withName("Red")
}

object LessonSix {
	//每个程序应该从一个对像的main方法开始，类型为Array[String] => Unit
	def main(args: Array[String]) {
		//这样写实际上是调用的Account.apply(1000.0)
		val acct = Account(1000.0)
	}
}
//或者扩展app特质，把程序代码放到构造器方法体内
object Hello extends App{
	println("Hello App!")
}

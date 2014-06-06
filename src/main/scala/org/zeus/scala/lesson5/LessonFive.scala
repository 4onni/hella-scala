package org.zeus.scala.lesson5

import scala.beans.BeanProperty
import java.util.Properties
import java.io.FileReader
import scala.collection.mutable.ArrayBuffer

/**
 * 类
 * Created by zhangqinghua on 14-6-6.
 */
//最简单形式的类定义 scala的类都具有公有可见性，在一个源文件中可以定义多个类
class Counter{
	private var value = 0;//必须初始化字段

	def increment(){ value += 1}//方法默认是公有的
	def current() = value
	//之所以可以访问private的字段是因为other也是Counter类型的
	//可以用private[this] var value = 0来定义更严格的访问
	def isLess(other: Counter) = value < other.value
}

class Person{
	//生成面向jvm的类时，有一个私有的age字段和相应的getter和setter方法是公有的，因为age不是private的
	//getter和setter分别叫age 和 age_=
	var age = 0
	private var privateAge = 0

	//这个_经常出现了，这里是什么意思呢?加了@BeanProperty会生成java风格的getter和setter
	@BeanProperty var name: String = _

	def age2 = privateAge
	def age2_=(newValue: Int){
		if(newValue > privateAge) privateAge = newValue
	}

}

class Message{
	//只会生成getter
	val timeStamp = new java.util.Date
}

class People{

	private var name = "";
	private var age = 0

	//一个辅助构造器,名称是this,方便改类名?辅助构造器必须要以另一个辅助构造器或主构造器开始
	def this(name: String){
		this();//调用主构造器
		this.name = name
	}

	//另一个辅助构造器，调用前一个辅助构造器
	def this(name: String, age: Int){
		this(name);
		this.age = age;
	}

}

//()中的参数就是主构造器的参数
class User(val name: String,val age: Int){
	//主构造器会执行类定义中的所有语句
	println("Just constructed another User")
	def desc = name + " is " + age + " years old"
	private val props = new Properties()
	props.load(new FileReader("myConfig.properties"))
}
//默认参数
class Author(val name: String = "", val age: Int = 0){}

//如果是普通方法参数的定义，如果至少被一个方法使用，这个参数升格为字段
class Employee(name: String, age: Int){
	def desc = name + " is " + age + " years old"
}

//scala中，几乎可以在任何语法结构中嵌套任何语法结构，可以在函数中定义函数，在类中定义类
//outter=>相当于Networ.this
class Network{ outter=>

	//嵌套类
	class Member(val name: String){
		val contracts = new ArrayBuffer[Member]

	}

	private val members = new ArrayBuffer[Member]

	def join(name: String) = {
		val m = new Member(name)
		members += m
		m
	}

}

object LessonFive {

	def main(args: Array[String]) {
		val myCounter = new Counter//或者new Counter()
		myCounter.increment()
		println(myCounter.current())//println(myCounter.current)也可以这样写，可以在定义里用def current = value来强制这种风格

		val person = new Person
		println(person.age)
		//这里有点不理解，不是说生成的方法叫age_=么？
		person.age = 21
		println(person.age)

		val fred = new Person
		fred.age2 = 30
		fred.age2 = 21
		println(fred.age2)

		fred.setName("fred")

		val p1 = new People()//主构造器
		val p2 = new People("Fred")//第一个辅助构造器
		val p3 = new People("Fred",32)//第二个辅助构造器

		val chatter = new Network
		val myFace = new Network
		val fred1 = chatter.join("Fred")
		val wilma = chatter.join("Wilma")
		fred1.contracts += wilma//ok
		val barney = myFace.join("Barney")
		//不可以这么做
		//fred1.contracts += barney
		//两种解决方案，一种是把Member移动到伴生对像中，一种是用类型投影Network#Member,意思是任何Network和Member

	}

}

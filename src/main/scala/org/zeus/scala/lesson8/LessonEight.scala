package org.zeus.scala.lesson8

/**
 * extends
 * Created by Administrator on 2014/6/8.
 */

abstract class Person( name: String, age: Int){}

//继承也是使用extends关键字,只有主构造器才能调用超类的主构造器
class Employee( name: String, age: Int,val salary2: Double) extends Person(name,age){
	//和java一样，给出超类没有的字段和方法
	var salary = 0.0
	//子类可以访问,对于类所属包不可见,protected[this]书上说是将访问权限定在当前对像，不太明白
	protected var protectedVar: Int = 0;
	//重写必须要override修饰符
	override def toString = super.toString+getClass.getName + "[name="//调用超类使用super关键字

	def convert(obj: Any){
		if(obj.isInstanceOf[Employee]){
			if(obj.getClass == classOf[Employee]) {//判断它不是Employee的子类
				val s = obj.asInstanceOf[Employee]//类型转换
			}
		}
		//更好的方式使用模式匹配
		obj match {
			case s: Employee => s.salary +=1000
			case _ => obj.getClass
		}
	}

}

class LessonEight {

}

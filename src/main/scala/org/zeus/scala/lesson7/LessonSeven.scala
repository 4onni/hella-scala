//顶部包定义，不带{}
package org.zeus.scala.lesson7
import java.awt.Color
//相当于java中的import java.util.*
import java.util._
//选取器
import java.awt.[Color,Font]
//重命名
import java.util.[HashMap => JavaHashMap]
import scala.collection.mutable._

package object pepole{
	val defaultName="John "
}

package people{
	class Person{
		//任何地方都可以加入引入
		import java.beans._

		//people包可见
		private[people] def desc = "A person with name:" + name
		//lesson7包可见
		private[lesson7] def desc2 = "A person with name:" + name
		import _root_.org.zeus.scala.lesson7.people._
		var name = defaultName
	}
}

/**
 * 包和引入
 * Created by Administrator on 2014/6/8.
 */
//将条目包含在包定义中
package com{
	package horstmann{
		object Utils{
			def percentOf(value: Double, rate: Double) = value * rate/100
		}
		package impl{
			//串联包定义
			package zeus.model.impatient{

			}
			class Employee{

				def giveRaise(rate: Double){
					var salary = 0.0
					//可以访问上层包中的定义
					salary +=Utils.percentOf(salary,rate)
					//绝对路径
					val subbordinates = new _root_.scala.collection.mutable.ArrayBuffer[Employee]
				}
			}
		}
	}
}
//可以在一个源文件中为多个包贡献内容
package org{
	package bigjava{
		class Counter{}
	}
}

object LessonSeven {


}

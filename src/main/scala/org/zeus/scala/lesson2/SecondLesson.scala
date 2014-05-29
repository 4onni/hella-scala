package org.zeus.scala.lesson2
import scala.math._

/**
 * 控制结构和函数
 * Created by Administrator on 2014/5/29.
 */
object SecondLesson {

    def main(args: Array[String]) {
	    val x=1;
		val s = if(x>0) 1 else -1;//if表达式有值 类似java中x>0 ?1 :-1 比起if x>0 s =1 else s=-1更简洁了
	    println(s);
	    if(x>0) "positive" else -1;//返回Any类型
	    if(x>0) 1;//不写else返回Unit类，scala中每个表达式都应该有某种值。Unit在这里可以写做()相当于if(x>0) 1 else ()
	    var r,n=10;
	    if(n>0) {r= r*n; n -= 1}//;号表示结束，在} else类似的位置不必要写分号
	    //表达式太长需要用操作符当做行尾。表达式太长一般用函数或方法调用。
	    var distance={ val dx=x-n;var dy=r-n;sqrt(dx*dx+dy*dy)}//块的返回值是最后一个语句。话说idea不能用快捷键导入包啊。-_-!!
	    {r=r*x;n-=1}//赋值动作本身没有值，严格的说是Unit类型。这个值写作()所以不能写作x=y=1 y=1的值是()
	    println("输出并换行");
	    print("输出");
	    printf("Hello %s, %d","Fred",42);//有点像java的String.format()
	    readLine("You name:");//读字符串
	    readInt();//读数字。
     }

}

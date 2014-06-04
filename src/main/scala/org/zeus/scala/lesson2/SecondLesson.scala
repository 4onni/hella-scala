package org.zeus.scala.lesson2
import scala.math._
import java.net.{MalformedURLException, URL}
import java.io.{InputStream, IOException}

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

	    while(n>0){
			r=r*n;
		    n-=1;
	    }//while循环

	    //scala没有java式的for 如下方法1 to n产生一个区间
	    for(i <- 1 to n)
		    r=r*i;

	    //until产生一个不包含上限的区间，顺便一提，书中此例把until写成了util，如果直接写util会报错。
	    val sStr = "hello";
	    var sum=0;
	    for(i <- 0 until sStr.length)
		    sum += sStr(1);
	    sum=0;

	    //也可以直接这么写。就可以遍历每个字符。
	    for(ch <- "Hello") sum+=ch;

	    //关于break是抛出异常来完成的，所以对于响应时间有要求的话还是不要用了。可以使用控制变量

		for(i <- 1 to 3; j <- 1 to 3) print((10*i+j)+" ");

	    for(i <- 1 to 3; j <- 1 to 3 if i != j) print((10*i+j)+" ");

	    for(i <- 1 to 3; from = 4 - i ; j <- from to 3) print((10*i+j)+" ");

	    //循环以yield 开始，该 循环会构造出一个集合，每次循环会生成集合中的一个值 下例生成Vector(1,2,0,1,2,0,1,2,0) 这类循环叫for推导式
	    for(i <- 1 to 10) yield 1 % 3
	    // for推导式生成的集合与它的第一个生成器是类型兼容的
	    for(c <- "hello"; i <- 0 to 1) yield (c + i).toChar//生成"hieflmlmop"

		for(i <- 0 to 1; c <- "hello") yield (c + i).toChar//生成Vector('h','i','e','f','l','m','l','m','o','p')

	    //定义在花括号中，以换行的方式,但不知道为什么在idea里最后会报错。
//	    for {
//		    i <- 1 to 3
//	        from = 4 -i
//	        j <- from to 3
//	    }
		//函数定义
	    def abs(x: Double) = if (x>0) x else -x

	    //多个表达式可以用{}块，最后一个表达式就是返回值
	    def fac(n: Int) = {
		    var r = 1;
		    for(i <- 1 to n) r = r * i
		    r
	    }
	    //递归函数需要指定返回值
	    def fac1(n: Int): Int = if (n<=0) 1 else n*fac1(n-1)

	    //带名参数和默认值
	    def decorate(str: String, left: String = "[", right: String = "]") =
	        left + str + right

	    decorate("hello")//[hello]

	    decorate("hello","<<",">>")//<<hello>>

	    decorate("hello","<<[")//<<[hello]

	    decorate(left = "<<",str= "hello", right=">>" )//<<hello>>

	    decorate("hello",right=">>")//[hello>>

	    //变长参数
		def sumFn(args: Int*) = {
			var result = 0;
			for(arg <- args) result += arg;
			result;
		}
	    //函数得到的是一个类型为Seq的参数,如果已经有一个值的序列，不能直接将它传入 val s = sumFn(1 to 10)
	    val sInt = sumFn(1,4,9,16,25);

	    //如果只传一个参数，该参数必须是单个整数，解决这个问题的办法是加入:_*让这个参数当做参数序列
	    val ssInt = sumFn(1 to 5: _*);

	    def recursiveSum(args: Int*): Int = {
		    if(args.length == 0) 0
		    else args.head + recursiveSum(args.tail: _*)
	    }

	    //没有返回值就是过程
	    def box(s: String){
		    var border = "-" * s.length + "--\n";
		    println(border + "|" + s + "|\n" + border)
	    }

	    //有的人更喜欢写明确的返回值Unit
	    def box1(s: String): Unit = {
		    var border = "-" * s.length + "--\n";
		    println(border + "|" + s + "|\n" + border)
	    }

	    //首次使用words时加载
		lazy val words = scala.io.Source.fromFile("/usr/share/dict/words").mkString

	    //scala的异常和java差不多
	    //throw new IllegalArgumentException("x should not be negative");

	    //if分支的类型是Double else分支是Noting 所以表达式的值是Double
	    if (x >= 0) {sqrt(x)} else new IllegalArgumentException("x should not be negative");

		def process(url: URL): Unit =  println(URL)

		def processStream(in: InputStream): Unit = println(in)

		//捕获异常的语法采用的是模式匹配的语法,更通用的异常应该排在具体的异常之后。
	    try{
		    process(new URL("http://www.google.com.hk"))
	    }catch{
		    case _:MalformedURLException => println("Bad URL: ")
			case ex: IOException => ex.printStackTrace();
	    }

		//使用finally来释放资源
		val in = new URL("www.google.com.hk").openStream();
		try{
			processStream(in);
		}finally{
			in.close();
		}


     }

}

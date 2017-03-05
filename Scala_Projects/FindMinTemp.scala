val Temp = sc.textFile("/tmp/hemant/Temperature")
val a = Temp.map(x=>x.split(",")).map(x=>(x(0),x(2),x(3))
val b = a.filter(x=>x._3.contains("TMIN"))
val c = b.map(x=>(x._1,x._3*0.1*(9.0/5.0)+32.0))
import scala.math._
val result = c.reduceByKey((a,b)=>min(a,b)).map(x=>x.swap).sortByKey()
result.collect()

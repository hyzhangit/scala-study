import java.util
import scala.annotation.tailrec
import scala.io.Source

object Test {
  def main(args: Array[String]): Unit = {
    // 数组切片
    val source = Source.fromFile("C:\\Users\\hyzhangj\\Desktop\\tmp\\wordCount.txt").getLines()
    val temp = source.slice(0, 2).toList.flatMap(_.split(" "))
      .groupMapReduce(str => str)(_ => 1)(_ + _)
    temp.foreach(println)

    // 柯里化
    def kali1(op: (Int, Int) => Int): Int = List(1, 2, 3, 4, 5, 6).foldLeft(1)(op)

    println(kali1(_ + _))
    println(kali2(0))

    // 函数
    val week = WeeklyWeatherForecast(Seq(1, 2, 3))
    val forCast = week.forecastInFahrenheit
    println(forCast)

    val list = new java.util.ArrayList[Number]()
    list.add(1)
  }

  def kali2(x: Int): Int = List(1, 2, 3, 4, 5, 6).foldLeft(x)(_ + _)

  case class WeeklyWeatherForecast(temperatures: Seq[Double]) {
    private def convertCtoF(temp: Double) = temp * 1.8 + 32

    def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF
  }
}


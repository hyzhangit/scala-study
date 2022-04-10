import scala.annotation.tailrec

/**
 * 递归
 *
 * @author
 */
class Recursive {
  /**
   * factorial序列，尾递归
   *
   * @param x 数值
   * @return 结果
   */
  def factorial(x: Int): Int = {
    @tailrec
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }

    fact(x, 1)
  }
}

object Recursive {
  def main(args: Array[String]): Unit = {
    val tailrec: Recursive = new Recursive()
    println("Factorial of 3 is " + tailrec.factorial(3))
  }
}

package chapter2.chapter2

import scala.annotation.tailrec

object Fibonacci extends App {

  def fibonacci(n: Int): Int = {
    def go(n: Int, acc: Int): Int = {
      if (n < 2) 0

      else go(n - 1, n + acc)
    }

    go(n, 0)
  }

  def fib(n: Int): Int = {

    @tailrec
    def loop(n: Int, prev: Int, cur: Int): Int = {
      if (n == 0) prev
      else loop(n - 1, cur, prev + cur)
    }

    loop(n, 0, 1)
  }

  println(fib(0))
}

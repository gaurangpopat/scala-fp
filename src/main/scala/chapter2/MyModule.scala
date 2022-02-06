package chapter2

import scala.annotation.tailrec

object MyModule {

  def abs(x: Int) = if (x < 0) x * -1 else x

  def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n - 1, acc * n)
    }

    go(n, 1)
  }

  private def formatMsgAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  private def formatMsgFactorail(x: Int): String = {
    val msg = "The Factorial of %d is %d"
    msg.format(x, factorial(x))
  }

  def formatResult(x: Int, name: String, f: Int => Int) = {
    val msg = "%s of %d is %d"
    msg.format(name, x, f(x))
  }


  def main(args: Array[String]): Unit = {
    println(formatMsgAbs(-5))
    println(formatMsgFactorail(5))

    /*Using HOF */
    println(formatResult(-5, "abs", abs))
    println(formatResult(5, "Factorial", factorial))


  }


}

/*
--> Scala code has to be in an object or a class
--> object keyword creates a new singleton type, which is like a class that only have single named instance.
--> scala has no equivalent of java's static keyword. an object is often used in scala where you might use class with static members in java
--> Here MyModule is singleton class and its the only instance of its own.
--> abs takes an Integer and returns an Integer and that's why its pure function.
--> private method can only be called by other members of MyModule.
--> Note that return statement and return type are not needed in formatMsg method
--> val is immutable variable that means you cannot assign any other value to msg.
--> main method is impure function as it has side effects.
--> signature and return type of main must be the same for scala to look for exact method from our code.
--> We can compile MyModule.scala using scalac MyModule.scala , it will generate .class file
--> For simple program like this , we can also run directly scala MyModule.scala in scala interpreter
--> Scala has no special notation of operators, its simply the case that + is valid method in scala.
--> *****  Higher Order Functions  *******
--> Functions are value
--> Just like other values of other types such as Integer, String etc , it can be assigned to variable,
     stored in data structure and passed as an arguments to other functions
--> Function that accepts other functions as arguments that's called higher order function.
-->

 */

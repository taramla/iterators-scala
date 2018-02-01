package imperative.modular

/**
  * Provides main method for reading lines and printing line count along with line itself.
  * Depends on suitable Input and Output provider traits.
  */
trait CountLines extends Input with Output[(Int, String)] {

  def main(args: Array[String]): Unit = {
    var count = 0
    for (line <- getInput) {
      count += 1
      doOutput((count, line))
    }
  }
}

/** Concrete main application object. */
object LineCountImperativeModular extends InputFromStdIn with CountLines with OutputToStdOut[(Int, String)]
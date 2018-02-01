package imperative.modular

trait CountLines extends Input with Output[(Int, String)] {

  def main(args: Array[String]): Unit = {
    var count = 0
    for (line <- getInput) {
      count += 1
      doOutput((count, line))
    }
  }
}

object LineCountImperativeModular extends InputFromStdIn with CountLines with OutputToStdOut[(Int, String)]
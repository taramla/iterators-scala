package imperative.modular

/**
  * Provides main method for reading lines and printing
  * cumulative length of all lines so far along with most recent line itself.
  * Depends on suitable Input and Output provider traits.
  */
trait AccumulateLength extends Input with Output[(String, Int)] {

  def main(args: Array[String]): Unit = {
    var length = 0
    for (line <- getInput) {
      length += line.length
      doOutput((line, length))
    }
  }
}

/** Concrete main application object. */
object CumulativeLengthImperativeModular extends InputFromStdIn with AccumulateLength with OutputToStdOut[(String, Int)]
package imperative.modular

trait AccumulateLength extends Input with Output[(String, Int)] {

  def main(args: Array[String]): Unit = {
    var length = 0
    for (line <- getInput) {
      length += line.length
      doOutput((line, length))
    }
  }
}

object CumulativeLength extends AccumulateLength with InputFromStdIn with OutputToStdOut[(String, Int)]
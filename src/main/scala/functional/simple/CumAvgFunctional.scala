package functional.simple

object CumAvgFunctional extends App {
  val lines = scala.io.Source.stdin.getLines
  val values = lines.map(_.toDouble)
  val countsWithSums = values.scanLeft((0, 0.0)) {
    case ((count, sum), value) => (count + 1, sum + value)
  }
  val countsWithAvgs = countsWithSums.map {
    case (count, sum) => (count, sum / count)
  }
  countsWithAvgs.drop(1).foreach {
    case (count, avg) => println(count + ": " + avg)
  }
}

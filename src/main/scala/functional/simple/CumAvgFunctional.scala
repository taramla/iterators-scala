package functional.simple

object CumAvgFunctional extends App {
  val lines = scala.io.Source.stdin.getLines
  val values = lines.map(_.toDouble)
  val results = values.scanLeft((0, 0.0)) {
    case ((count, sum), value) =>
      (count + 1, sum + value)
  }
  results.drop(1).foreach {
    case (count, sum) =>
      println(count + ": " + (sum / count))
  }
}

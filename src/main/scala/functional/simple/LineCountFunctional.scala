package functional.simple

object LineCountFunctional extends App {

  val lines = scala.io.Source.stdin.getLines

  val counts = Iterator from 1
  val results = counts zip lines

  results foreach println
}

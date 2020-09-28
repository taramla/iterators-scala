package imperative.modular
import imperative.simple.CumAvgImperative.sum
import sun.misc.Signal

import scala.collection.mutable.Queue
import scala.util.Try
/**
 * Provides a main method for reading lines and printing line count along with line itself.
 * Depends on a suitable Output provider.
 */

object movingStats {
  type Stat = (Double, Double, Double, Double)
  type OptionalStat = Option[Stat]
  type Stats = (Double, Int, Seq[OptionalStat])
}

trait movingStats extends Task[String] with Output[movingStats.Stats] {

  var squaredSum = 0.0

  def show(x: movingStats.OptionalStat) = x match {
    case Some(s) => s
    case None => println("?")
  }

  def run(input: Iterator[String], args: Array[String]) = {
    var count = 0
    var windowSize = Try(args(0).toInt).getOrElse(3)
    //var maxLength = 3
    val queue: Queue[Double] = Queue.empty[Double]
    val words = input.flatMap(_.split("\\W"))
    val num = words.map(_.toDouble)

    for (n <- num) {
      if (n <= 0) {
        System.err.println("Input must be a natural number ")
        System.exit(1)
      }
      count += 1
//      if (queue.length <= windowSize){
//        doOutput((n, count, Seq(Option("?", "?", "?", "?"))))
//              }
      if (queue.length >= windowSize) {
        queue.dequeue()
      }
      queue.enqueue(n)
      if (!System.getProperty("os.name").contains("Windows"))
        Signal.handle(new Signal("PIPE"), _ => scala.sys.exit())

      //println(queue)
      val min = queue.min
      val max = queue.max
      val sum = queue.sum
      val avg = sum / count

      val squared = ((n-avg)*(n-avg))*((n-avg)*(n-avg))
      squaredSum += squared
      val variance = squaredSum * (1/sum)
      val stdDev = math.sqrt(variance)

      //print(queue.length)
      doOutput((n, count, Seq(Option(min, avg, max, stdDev))))
    }
  }

}

/** A concrete main application object. */
object LineCountImperativeModular extends Main[movingStats.Stats] with movingStats {
}
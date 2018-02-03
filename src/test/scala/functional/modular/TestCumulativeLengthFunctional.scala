package functional.modular

import org.scalatest.WordSpec

class TestCumulativeLengthFunctional extends WordSpec {

  /** Refers to the existing immutable SUT instance. */
  val sut = CumulativeLengthFunctionalModular

  "The functional CumulativeLength calculator" when {
    "given an empty iterator" should {
      "produce an empty output" in {
        // exercise SUT
        val result: Iterator[(String, Int)] = sut.run(Iterator.empty)
        // check effect on output observer
        assert(result.isEmpty)
      }
    }

    "given a nonempty iterator" should {
      "produce the correct nonempty output" in {
        // input data for this test case
        val data = Seq("hello", "world", "what", "up")
        val expected = data.scanLeft(("dummy", 0)) { case ((_, n), l) => (l, n + l.length) }.drop(1)
        // exercise SUT
        val actual: Iterator[(String, Int)] = sut.run(data.iterator)
        // check effect on output observer
        assert(actual.toSeq === expected)
      }
    }
  }
}
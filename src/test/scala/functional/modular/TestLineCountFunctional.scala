package functional.modular

import org.scalatest.WordSpec

class TestLineCountFunctional extends WordSpec {

  /** Refers to the existing immutable SUT instance. */
  val sut = LineCountFunctionalModular

  "The functional LineCounter" when {
    "given an empty iterator" should {
      "produce an empty output" in {
        // exercise SUT
        val result: Iterator[(Int, String)] = sut.run(Iterator.empty)
        // check effect on output observer
        assert(result.isEmpty)
      }
    }

    "given a nonempty iterator" should {
      "produce the correct nonempty output" in {
        // input data for this test case
        val data = Seq("hello", "world", "what", "up")
        // exercise SUT
        val result: Iterator[(Int, String)] = sut.run(data.iterator)
        // check effect on output observer
        assert(result.toSeq === (1 to data.length).zip(data))
      }
    }
  }
}
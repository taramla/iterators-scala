package imperative.modular

import org.scalatest.wordspec.AnyWordSpec

class TestLineCountImperative extends AnyWordSpec {

  /** Creates a (mutable!) SUT instance. */
  def createSUT() = new CountLines with OutputToBuffer[(Int, String)]

  "An imperative LineCounter" when {
    "given an empty iterator" should {
      "produce an empty output" in {
        // create SUT instance for this test case
        val sut = createSUT()
        // exercise SUT
        sut.run(Iterator.empty)
        // check effect on output observer
        assert(sut.getResults.isEmpty)
      }
    }

    "given a nonempty iterator" should {
      "produce the correct nonempty output" in {
        // input data for this test case
        val data = Seq("hello", "world", "what", "up")
        // create SUT instance for this test case
        val sut = createSUT()
        // exercise SUT
        sut.run(data.iterator)
        // check effect on output observer
        assert(sut.getResults === (1 to data.length).zip(data))
      }
    }
  }

  "given a nonempty iterator" should {
    "exhibit the correct interactive behavior" in {
      // input data for this test case
      val input = Iterator("hello", "world", "what", "up")
      // create SUT instance for this test case
      val sut = new CountLines with Tracing[String, (Int, String)]
      // exercise SUT
      sut.run(input)
      // check correctness of resulting interactions
      import sut.{ InputEvent => i, OutputEvent => o }
      assert(sut.trace === Seq(
        i("hello"), o((1, "hello")),
        i("world"), o((2, "world")),
        i("what"), o((3, "what")),
        i("up"), o((4, "up"))))
    }
  }
}
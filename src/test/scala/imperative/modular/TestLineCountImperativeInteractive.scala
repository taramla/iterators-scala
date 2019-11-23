package imperative.modular

import org.scalatest.WordSpec

class TestLineCountImperativeInteractive extends WordSpec {

  "given a nonempty iterator" should {
    "exhibit the interactive behavior" in {
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
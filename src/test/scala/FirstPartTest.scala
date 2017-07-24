/**
  * Created by knoldus on 22/7/17.
  */
class FirstPartTest extends org.scalatest.FunSuite {

  val objFirstPart = new FirstPart()

  test("testing writeResultTofile of FirstPart") {
    assert(objFirstPart.writeResultToFile("src/test/testResources", ".scala"))
  }

  test("testing writeResultTofile of FirstPart exception thrown") {
    intercept[java.lang.NullPointerException] {
      assert(objFirstPart.writeResultToFile("src/test/vdsgwrg", ".scala"))
    }

  }
}

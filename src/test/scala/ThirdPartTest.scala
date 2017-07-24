import org.scalatest.FunSuite

/**
  * Created by knoldus on 24/7/17.
  */
class ThirdPartTest extends FunSuite {

  val obj =  new ThirdPart()
  test("testing writeResultToFile of ThirdPart"){
    assert(obj.writeResultToFile("src/test/testResources/abc/url.txt"))
  }

  test("testing writeResultToFile of ThirdPart throwing exception"){
    intercept[java.io.FileNotFoundException] {
      assert(obj.writeResultToFile("src/test/vdsgwrg"))
    }
  }

}

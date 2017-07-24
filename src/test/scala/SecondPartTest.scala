import org.scalatest.FunSuite

/**
  * Created by knoldus on 24/7/17.
  */
class SecondPartTest extends FunSuite {

  val obj =  new SecondPart()
  test("testing writeResult of SecondPart"){
    assert(obj.writeResult("src/test/testResources/abc/cc.txt"))
  }

  test("testing writeResult of SecondPart throwing exception"){
    intercept[java.io.FileNotFoundException] {
      assert(obj.writeResult("src/test/vdsgwrg"))
    }
  }

}

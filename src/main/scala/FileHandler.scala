import java.io._

import scala.io.Source

/**
  * Created by knoldus on 22/7/17.
  */
abstract class FileHandler {
  val OUTPUT_DIR = "src/testoutput/"
//  def createFile(filePath: String): Boolean = new File(filePath).createNewFile()

  def readFile(filePath: String): Iterator[String] = Source.fromFile(new File(filePath)).getLines

  def writeFile(filePath: String, content: String) = {

    new File(OUTPUT_DIR).mkdir()

    val file: File = new File(filePath)


    file.createNewFile()


    val bw = new BufferedWriter(new FileWriter(file))

    bw.write(content)
    bw.close()

  }


}

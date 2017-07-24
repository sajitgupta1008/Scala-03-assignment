import java.io.File


class SecondPart extends FileHandler {

  private def readWords(file: File): Iterator[String] = {

    val content = readFile(file.getPath).mkString(" ").toLowerCase

    val regex = """[a-zA-Z]+""".r

    for (s <- regex findAllIn content)
      yield s

  }

private  def countWords(str: Iterator[String]): Map[String, Integer] = str.toList.groupBy(identity).mapValues(_.size)

  def writeResult(filePath: String): Boolean = {
    try {
      val file = new File(filePath)
      val words = readWords(file)
      val mapString = countWords(words).mkString("\n")
      writeFile(OUTPUT_DIR + file.getName, mapString)
      true
    }

    catch {
      case ex: Exception => throw ex
    }
  }
}

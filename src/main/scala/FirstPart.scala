import java.io.File


class FirstPart extends FileHandler {


  private def getAllFiles(dir: File): List[File] = {

    val listOfFiles = dir.listFiles().toList

    listOfFiles.filter(_.isFile) ::: listOfFiles.filter(_.isDirectory).flatMap(x => getAllFiles(x))

  }

private  def filterFiles(dir: File, extn: String): List[File] = getAllFiles(dir).filter(_.getName.contains(extn))


 private def processContent(file: File): String = readFile(file.getPath).mkString("\n").toUpperCase

 private def getResult(dir: File, extn: String): List[(File, String)] = {

    val listOfFiles: List[File] = if (extn == "all") getAllFiles(dir) else filterFiles(dir, extn)

    val listofString: List[String] = listOfFiles.map(processContent)

    listOfFiles.zip(listofString)

  }


  def writeResultToFile(dirPath: String, extn: String): Boolean = {
    try {
      val dir = new File(dirPath)
      println(dir)

      val zipp = getResult(dir, extn)

      zipp.foreach(x => writeFile(OUTPUT_DIR + x._1.getName, x._2))
      true
    }
    catch {
      case ex: Exception => {
       throw ex
      }
    }
  }
}



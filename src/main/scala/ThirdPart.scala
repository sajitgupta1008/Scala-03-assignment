import java.io.File
import java.net.URL

class ThirdPart extends FileHandler {

private  def getResults(inputFilePath: String) = {

    val urls = getAllURLS(inputFilePath)

    val result = urls.map(x=>splitURL(x)).mkString("\n")

    result
  }

 private def splitURL(urlString: String): String = {

    val url:URL  =  new URL(urlString.trim())


   url match {
      case URLParser(protocol, host, domain, params) => s"Protocol -> $protocol, Host -> $host, Domain -> $domain, " +
        s"Query params -> $params"
    }
  }

 private def getAllURLS(filePath: String): Iterator[String] = readFile(filePath)

  def writeResultToFile(inputFilePath: String): Boolean = {

    try {
      val fileName = inputFilePath.substring(inputFilePath.lastIndexOf("/") + 1)

      val result = getResults(inputFilePath)

      writeFile(s"$OUTPUT_DIR$fileName", result)

      true
  }
    catch{
      case ex : Exception => throw ex
    }
  }


}

object URLParser {

  def unapply(url: java.net.URL): Option[(String, String, String, Map[String, String])] = {
    val protocol = url.getProtocol
    val hostName = url.getHost
    val regex = "[a-z]+\\.([a-z]+)\\.(.*)".r
    val regex(host, domain) = hostName
    val query = url.getQuery

    if (query == null)
      Some(protocol, host, domain, null)
    else {


      def splitKey_Value(str: String): (String, String) = {
        val z = str.split("=")
        (z(0), z(1))
      }

      val map: Map[String, String] = {
        val parts = query.split("&")
        parts.map(x => splitKey_Value(x)).toMap
      }

      Some(protocol, host, domain, map)
    }
  }
}


package info.raack.sailingcruisechecker

class Http {
  def get(url: String): String = {
    scala.io.Source.fromURL(url).mkString
  }
}
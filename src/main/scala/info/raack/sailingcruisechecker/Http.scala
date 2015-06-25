package info.raack.sailingcruisechecker

import javax.inject.Named

@Named
class Http {
  def get(url: String): String = {
    scala.io.Source.fromURL(url).mkString
  }
}

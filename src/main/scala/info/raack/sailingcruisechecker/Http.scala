package info.raack.sailingcruisechecker

import javax.inject.Inject
import javax.inject.Named

@Named
// see the Bootstrap class for how non-DI annotated (JSR 330) objects make their way into the object graph
class Http @Inject() (val externalNonDIEnabledObject: NonDIEnabledClass) {
  def get(url: String): String = {
    scala.io.Source.fromURL(url).mkString
  }
}

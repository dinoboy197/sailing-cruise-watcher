package info.raack.sailingcruisechecker

import net.codingwell.scalaguice.ScalaModule
import com.google.inject.AbstractModule
import com.google.inject.Guice
 
class GuiceModule extends AbstractModule with ScalaModule {
  def configure() {
    bind[Http]
  }
}

object Bootstrap extends App {
  Guice.createInjector(new GuiceModule).getInstance(classOf[SailingCruiseChecker])
}
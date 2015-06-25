package info.raack.sailingcruisechecker

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean

// configuration class
// used for advanced configuration
// such as to create DI-enabled instances of classes which do not have DI (JSR 330) annotations
class Bootstrap {
  // use @Bean to annotate a method which returns an instance of the class that you want to inject and of which
  // Spring should manage the lifecycle
  @Bean(initMethod = "init", destroyMethod = "close")
  def externalNonDIEnabledObject() = new NonDIEnabledClass()
}

// main entry point for command line operation
object Bootstrap extends App {
  // start up the Spring DI/IOC context with all beans in the info.raack.sailingcruisechecker namespace
  val context = new AnnotationConfigApplicationContext()
  // include all custom class instances which are not DI enabled
  context.register(classOf[Bootstrap])
  // include all DI annotated classes in this project's namespace
  context.scan("info.raack.sailingcruisechecker")
  context.refresh()

  // start up the app - run all JSR250 @PostConstruct annotated methods
  context.start()

  // ensure that all JSR250 @PreDestroy annotated methods are called when the process is sent SIGTERM
  context.registerShutdownHook()
}

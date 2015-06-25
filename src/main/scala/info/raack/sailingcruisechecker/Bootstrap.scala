package info.raack.sailingcruisechecker

import org.springframework.context.annotation.AnnotationConfigApplicationContext

/** main entry point for command line operation */
object Bootstrap extends App {
  // start up the Spring DI/IOC context with all beans in the info.raack.sailingcruisechecker namespace
  val context = new AnnotationConfigApplicationContext()
  context.scan("info.raack.sailingcruisechecker")
  context.refresh()

  // start up the app - run all JSR250 @PostConstruct annotated methods
  context.start()

  // ensure that all JSR250 @PreDestroy annotated methods are called when the process is sent SIGTERM
  context.registerShutdownHook()
}

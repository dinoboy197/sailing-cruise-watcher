package info.raack.sailingcruisechecker

import javax.annotation.PostConstruct
import javax.annotation.PreDestroy
import javax.inject.Named

@Named
class SampleProcessor {
  private val someLargeResourceToOnlyLoadOnce = "sample"

  // if your singleton has some state which must be initialized only *after* the object graph is constructed
  // (ie, it calls other objects in the object graph which might not yet be fully constructed)
  // use this method
  @PostConstruct
  def start() {
    // some initialization that is guaranteed to only happen once
  }

  def doProcess(): String = {
    someLargeResourceToOnlyLoadOnce
  }

  @PreDestroy
  def stop() {
    // if your singleton has some state which must be shut down to cleanly stop your app
    // (ex: database connections, background threads)
    // use this method
  }
}

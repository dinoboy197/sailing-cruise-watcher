package info.raack.sailingcruisechecker

// it is common to use objects from external libraries which must be retained in singletons inside
// an existing DI-managed class
// for example, usage of a class instance that would normally be created with "private val instance = new NonDIEnabledClass"

// this is a fictitious example of such an external class which must be started with init() and stopped with close()
class NonDIEnabledClass {
  def init {}
  def close {}
}

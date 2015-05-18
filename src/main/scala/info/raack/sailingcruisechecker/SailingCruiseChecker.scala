package info.raack.sailingcruisechecker

import javax.inject.Inject

class SailingCruiseChecker @Inject() (http: Http) {
 
  println("initialized sailing cruise checker")
  
  println(s"http is $http")
  
}
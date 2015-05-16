name := "sailingcruisewatcher"

organization := "info.raack.sailingcruisewatcher"

version := "1.0.x-SNAPSHOT"

scalaVersion := "2.11.6"

// libraries
libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "[4.0,5.0)",
  "javax.inject" % "javax.inject" % "[1]",
  "net.codingwell" %% "scala-guice" % "4.0.0-beta5"
)

// main class
mainClass in (Compile, packageBin) := Some("info.raack.sailingcruisechecker.Bootstrap")
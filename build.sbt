name := "sailingcruisewatcher"

organization := "info.raack.sailingcruisewatcher"

version := "1.0.x-SNAPSHOT"

scalaVersion := "2.11.6"

// libraries
libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "[4.0,5.0)",
  "javax.inject" % "javax.inject" % "[1]",
  "net.codingwell" %% "scala-guice" % "[4.0.0,5.0.0)",
  // logging: log4s -> slf4j -> logback
  "org.log4s" %% "log4s" % "1.1.5",
  "ch.qos.logback" % "logback-classic" % "1.1.3"
)

// main class
mainClass in (Compile, packageBin) := Some("info.raack.sailingcruisechecker.Bootstrap")

// use pack plugin to pack all libraries for easy deployment with roller deploytool and no nasty uberjar file collissions
packAutoSettings

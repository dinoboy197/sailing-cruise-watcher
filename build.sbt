name := "sailingcruisewatcher"

organization := "info.raack.sailingcruisewatcher"

version := "1.0.x-SNAPSHOT"

scalaVersion := "2.11.6"

// libraries
libraryDependencies ++= Seq(
  "org.springframework" % "spring-context" % "4.1.6.RELEASE" exclude ("commons-logging", "commons-logging"),
  // spring uses commons-logging, so redirect these logs to slf4j
  "org.slf4j" % "jcl-over-slf4j" % "1.7.12",
  "org.springframework" % "spring-beans" % "4.1.6.RELEASE",
  "javax.inject" % "javax.inject" % "[1]",
  // logging: log4s -> slf4j -> logback
  "org.log4s" %% "log4s" % "1.1.5",
  "ch.qos.logback" % "logback-classic" % "1.1.3"
)

// main class
mainClass in (Compile, packageBin) := Some("info.raack.sailingcruisechecker.Bootstrap")

// use pack plugin to pack all libraries for easy deployment with roller deploytool and no nasty uberjar file collissions
packAutoSettings

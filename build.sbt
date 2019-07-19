name := """scala-play-swagger"""
organization := "com.brevitaz"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.0"

libraryDependencies += guice
libraryDependencies += "io.swagger" %% "swagger-play2" % "1.7.1"
libraryDependencies += "org.webjars" % "swagger-ui" % "3.23.0"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test



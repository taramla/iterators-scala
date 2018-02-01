name := "iterators-scala"

version := "0.1"

scalaVersion := "2.12.4"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1"  % Test

enablePlugins(JavaAppPackaging)

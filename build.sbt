name := "iterators-scala"

version := "0.3"

scalaVersion := "2.12.5"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies ++= Seq(
  "org.scalatest"     %% "scalatest"  % "3.0.5" % Test,
  "org.scalamock"     %% "scalamock"  % "4.0.0" % Test,
  "com.storm-enroute" %% "scalameter" % "0.9"   % Test
)

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

logBuffered := false

parallelExecution in Test := false

enablePlugins(JavaAppPackaging)

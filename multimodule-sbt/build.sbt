ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "multimodule-sbt"
  )


lazy val core = (project in file("core"))
  .settings(
    name := "core",
    version := "1.0.0",
    scalaVersion := "2.13.8",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test
    )
  )
  .dependsOn(utils)
  .aggregate(utils)

lazy val utils = (project in file("utils"))
  .settings(
    name := "utils",
    version := "1.0.0",
    scalaVersion := "2.13.8"
  )

libraryDependencies += "joda-time" % "joda-time" % "2.12.2"
libraryDependencies += "org.joda" % "joda-convert" % "2.2.2"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.32" //JDBC
updateOptions := updateOptions.value.withCachedResolution(true) //cached resolution
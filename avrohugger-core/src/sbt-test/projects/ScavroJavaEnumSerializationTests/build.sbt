organization := "com.julianpeeters"

name := "datatype-scavro-serializaton-tests"

version := "0.5-SNAPSHOT"

scalaVersion := "2.10.6"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Ywarn-value-discard")

scalacOptions in Test ++= Seq("-Yrangepos")

sbtavro.SbtAvro.avroSettings

version in sbtavro.SbtAvro.avroConfig := "1.8.0"

sourceGenerators in Compile += (avroScalaGenerateScavro in Compile).taskValue

avroScalaScavroCustomTypes in Compile := Map("array"-> classOf[List[_]])

avroScalaScavroCustomEnumStyle in Compile := Map("enum"-> "java enum")

avroScalaCustomNamespace in Compile := Map("SCAVRO_DEFAULT_PACKAGE$" -> "scavro")

libraryDependencies ++= Seq(
  "org.oedura" %% "scavro" % "1.0.1",
  "org.apache.avro" % "avro-ipc" % "1.7.7",
  "org.specs2" %% "specs2-core" % "3.7.2" % "test"
)

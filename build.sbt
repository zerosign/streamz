name := "streamz"

organization in ThisBuild := "com.github.krasserm"

version in ThisBuild := "0.4-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.8"

resolvers in ThisBuild += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in ThisBuild ++= Seq("-feature", "-language:higherKinds", "-language:implicitConversions", "-deprecation")

libraryDependencies in ThisBuild ++= Seq(
  "org.scalaz.stream" %% "scalaz-stream" % Version.ScalazStream,
  "com.typesafe.akka" %% "akka-testkit"  % Version.Akka          % "test",
  "org.scalatest"     %% "scalatest"     % Version.Scalatest     % "test"
)

lazy val root = project.in(file("."))
  .settings(scalaVersion := "2.11.8")
  .aggregate(akkaCamel, akkaPersistence, akkaStream)

lazy val akkaCamel = project.in(file("streamz-akka-camel"))
  .settings(scalaVersion := "2.11.8")

lazy val akkaPersistence = project.in(file("streamz-akka-persistence"))
  .settings(scalaVersion := "2.11.8")

lazy val akkaStream = project.in(file("streamz-akka-stream"))
  .settings(scalaVersion := "2.11.8")

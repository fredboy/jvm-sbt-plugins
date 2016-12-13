organization  := "org.toktok"
name          := "sbt-plugins"
version       := "0.1.1"
scalaVersion  := "2.10.6"

sbtPlugin := true

resolvers += Classpaths.sbtPluginReleases
resolvers += Resolver.bintrayRepo("toktok", "maven")

// Code style.
addSbtPlugin("com.etsy" % "sbt-checkstyle-plugin" % "3.0.0")
addSbtPlugin("org.scalastyle" % "scalastyle-sbt-plugin" % "0.8.0")
addSbtPlugin("org.wartremover" % "sbt-wartremover" % "1.1.1")

// Code formatting.
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

// Scala protobuf support.
addSbtPlugin("com.trueaccord.scalapb" % "sbt-scalapb" % "0.5.43")

// Test coverage.
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.4.0")
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.1.0")

// Proguard.
addSbtPlugin("com.typesafe.sbt" % "sbt-proguard" % "0.2.2")

// Publishing to bintray.
addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0")

// Build dependencies.
libraryDependencies ++= Seq(
  "com.github.os72" % "protoc-jar" % "3.0.0",
  "commons-io" % "commons-io" % "2.5",
  "org.ow2.asm" % "asm-all" % "5.1",
  "org.javassist" % "javassist" % "3.20.0-GA"
)

// Test dependencies.
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0"
) map (_ % Test)

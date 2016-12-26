organization  := "org.toktok"
name          := "sbt-plugins"
version       := "0.1.2"
scalaVersion  := "2.10.6"

sbtPlugin := true

resolvers += Classpaths.sbtPluginReleases
resolvers += Resolver.bintrayRepo("toktok", "maven")

// Code style.
addSbtPlugin("com.etsy" % "sbt-checkstyle-plugin" % "3.0.0")
addSbtPlugin("org.scalastyle" % "scalastyle-sbt-plugin" % "0.8.0")
addSbtPlugin("org.wartremover" % "sbt-wartremover" % "1.2.1")

// Code formatting.
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

// Scala protobuf support.
addSbtPlugin("com.trueaccord.scalapb" % "sbt-scalapb" % "0.5.43")

// Test coverage.
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.0")
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.1.0")

// Proguard.
addSbtPlugin("com.typesafe.sbt" % "sbt-proguard" % "0.2.2")

// Publishing to bintray.
addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0")

// For the dependency graph.
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")

// Build dependencies.
libraryDependencies ++= Seq(
  "com.github.os72" % "protoc-jar" % "3.1.0",
  "commons-io" % "commons-io" % "2.5",
  "org.ow2.asm" % "asm-all" % "5.1",
  "org.javassist" % "javassist" % "3.21.0-GA"
)

// Test dependencies.
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0"
) map (_ % Test)

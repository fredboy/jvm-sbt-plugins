organization  := "org.toktok"
name          := "sbt-plugins"
version       := "0.1.3"
scalaVersion  := "2.10.7"

sbtPlugin := true

resolvers += Classpaths.sbtPluginReleases
resolvers += Resolver.bintrayRepo("toktok", "maven")

// Code style.
addSbtPlugin("com.etsy" % "sbt-checkstyle-plugin" % "3.0.0")
addSbtPlugin("org.scalastyle" % "scalastyle-sbt-plugin" % "1.0.0")
addSbtPlugin("org.wartremover" % "sbt-wartremover" % "2.2.1")

// Code formatting.
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.2")

// Scala protobuf support.
addSbtPlugin("com.trueaccord.scalapb" % "sbt-scalapb" % "0.5.43")

// Test coverage.
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.2.2")

// Proguard.
addSbtPlugin("com.typesafe.sbt" % "sbt-proguard" % "0.2.3")

// Publishing to bintray.
addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0")

// For the dependency graph.
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.0")

// Build dependencies.
libraryDependencies ++= Seq(
  "com.github.os72" % "protoc-jar" % "3.5.0",
  "commons-io" % "commons-io" % "2.6",
  "org.ow2.asm" % "asm-all" % "5.2",
  "org.javassist" % "javassist" % "3.22.0-GA"
)

// Test dependencies.
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.0-SNAP5"
) map (_ % Test)

organization  := "org.toktok"
name          := "sbt-plugins"
version       := "0.1.5"
scalaVersion  := "2.10.7"

sbtPlugin := true

resolvers += Classpaths.sbtPluginReleases
resolvers += Resolver.bintrayRepo("toktok", "maven")

// Code style.
addSbtPlugin("com.etsy" % "sbt-checkstyle-plugin" % "3.0.0")
addSbtPlugin("org.scalastyle" % "scalastyle-sbt-plugin" % "1.0.0")

// Code formatting.
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.2")

// Test coverage.
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.2.2")

// Publishing to bintray.
addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0")

// For the dependency graph.
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.0")

// Build dependencies.
libraryDependencies ++= Seq(
  "commons-io" % "commons-io" % "2.6"
)

// Test dependencies.
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.0-SNAP5"
) map (_ % Test)

package im.tox.sbt

import sbt.Keys._
import sbt._
import sbt.plugins.{ IvyPlugin, JvmPlugin }

object Java7Plugin extends AutoPlugin {

  override def trigger: PluginTrigger = allRequirements
  override def requires: Plugins = JvmPlugin

  override def projectSettings: Seq[Setting[_]] = Seq(
    // All TokTok projects must be compatible with Java 7 so they work on
    // Android devices.
    javacOptions ++= Seq("-source", "1.7", "-target", "1.7")
  )

}

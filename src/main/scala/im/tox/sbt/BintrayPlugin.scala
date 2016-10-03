package im.tox.sbt

import bintray.BintrayKeys._
import sbt.Keys._
import sbt._
import sbt.plugins.{ IvyPlugin, JvmPlugin }

object BintrayPlugin extends AutoPlugin {

  override def trigger: PluginTrigger = allRequirements
  override def requires: Plugins = IvyPlugin && JvmPlugin

  override def projectSettings: Seq[Setting[_]] = Seq(
    bintrayOrganization := Some("toktok"),
    bintrayVcsUrl := Some("https://github.com/TokTok/jvm-" + name.value),
    licenses += (("AGPL-V3", url("http://opensource.org/licenses/AGPL-V3")))
  )

}

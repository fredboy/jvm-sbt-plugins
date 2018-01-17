package im.tox.sbt

import org.scalastyle.sbt.ScalastylePlugin.autoImport.scalastyleConfigUrl
import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform.autoImport.scalariformPreferences
import sbt._
import sbt.plugins.JvmPlugin

object Scalastyle extends AutoPlugin {

  override def trigger: PluginTrigger = allRequirements
  override def requires: Plugins = JvmPlugin

  def config(suffix: String): Some[URL] = Some(getClass.getResource(s"scalastyle$suffix-config.xml"))

  override val projectSettings = Seq(
    scalastyleConfigUrl := config(""),
    scalastyleConfigUrl in Test := config("-test"),
    scalariformPreferences := scalariformPreferences.value
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(DoubleIndentConstructorArguments, true)
      .setPreference(DanglingCloseParenthesis, Preserve)
      .setPreference(NewlineAtEndOfFile, true)
      .setPreference(DanglingCloseParenthesis, Force)
  )

}

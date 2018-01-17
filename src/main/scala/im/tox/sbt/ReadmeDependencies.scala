package im.tox.sbt

import scala.collection.immutable.ListMap
import scala.collection.JavaConverters._
import net.virtualvoid.sbt.graph.ModuleGraph
import net.virtualvoid.sbt.graph.DependencyGraphPlugin
import net.virtualvoid.sbt.graph.DependencyGraphKeys._
import net.virtualvoid.sbt.graph.rendering.FlatList
import org.apache.commons.io.FileUtils
import sbt.Keys._
import sbt._

object ReadmeDependencies extends AutoPlugin {

  override def trigger: PluginTrigger = allRequirements
  override def requires: Plugins = DependencyGraphPlugin

  object Keys {
    val updateReadmeDependencies: TaskKey[Unit] = TaskKey[Unit]("updateReadmeDependencies")
  }

  import Keys._

  private def replaceDepList(
    sections: ListMap[String, Seq[String]],
    section: String,
    comment: String,
    depList: Set[String]
  ): ListMap[String, Seq[String]] = {
    val markdownList = Seq("", comment, "") ++ depList.map("- " + _).toSeq.sorted :+ ""
    sections.map {
      case (k, v) =>
        if (k == s"## Dependencies: $section") {
          k -> markdownList
        } else {
          k -> v
        }
    }
  }

  private def updateReadmeDependenciesTask(
    readmeFile: File,
    compileDeps: ModuleGraph,
    testDeps: ModuleGraph
  ): Unit = {
    val sections0 = FileUtils.readLines(readmeFile, "UTF-8")
      .asScala
      .foldLeft(ListMap.empty[String, Seq[String]]) {
        case (res, line) =>
          if (line.startsWith("#")) {
            res + (line -> Nil)
          } else {
            res.lastOption match {
              case None =>
                res.updated(line, Nil)
              case Some((k, buf)) =>
                res.updated(k, buf :+ line)
            }
          }
      }

    val compileDepList = FlatList.render(compileDeps, _.id.idString).split("\n").toSet
    val testDepList = FlatList.render(testDeps, _.id.idString).split("\n").toSet

    val sections1 = replaceDepList(
      sections0, "compile",
      "To build the package itself, the following dependencies are required:",
      compileDepList
    )
    val sections2 = replaceDepList(
      sections1, "test",
      "For testing, the following additional dependencies are required:",
      testDepList -- compileDepList
    )

    val newReadme = sections2.toSeq.flatMap {
      case (k, v) => k +: v
    }.reverse.dropWhile(_.isEmpty).reverse
    FileUtils.writeLines(readmeFile, newReadme.asJava, "\n")
  }

  override val projectSettings: Seq[Setting[_]] = {
    updateReadmeDependencies := updateReadmeDependenciesTask(
      baseDirectory.value / "README.md",
      (moduleGraph in Compile).value,
      (moduleGraph in Test).value
    )
  }

}

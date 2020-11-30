package scalafix.sbt

import sbt.File
import scalafix.interfaces.ScalafixDiagnostic

trait DiagnosticsWriter {

  def write(targetFolder: File, diagnostic: Seq[ScalafixDiagnostic]): Unit

}

object DiagnosticsWriter {
  val noop: DiagnosticsWriter = (_: File, _: Seq[ScalafixDiagnostic]) => ()
}

package scalafix.sbt

import sbt.File
import scalafix.interfaces.ScalafixDiagnostic

class DiagnosticsCacheWriter {

  private val diagostics = List.newBuilder[ScalafixDiagnostic]

  def add(diagnostic: ScalafixDiagnostic): Unit = {
    diagostics += diagnostic
  }

  def write(file: File, writer: DiagnosticsWriter): Unit = {
    val diagnosticsResult = diagostics.result()
    diagostics.clear()
    writer.write(file, diagnosticsResult)
  }
}

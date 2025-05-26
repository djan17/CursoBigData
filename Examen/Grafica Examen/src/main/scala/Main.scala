import scala.io.Source
import scala.jdk.CollectionConverters._
import org.knowm.xchart.{CategoryChart, CategoryChartBuilder, SwingWrapper}
import org.knowm.xchart.VectorGraphicsEncoder
import org.knowm.xchart.VectorGraphicsEncoder.VectorGraphicsFormat

object Graficaexamen extends App {
  val filename = "examengrf.csv"
  val lines = Source.fromFile(filename).getLines().drop(1).toList

  val agencias = lines.map(_.split(",")(0))
  val casos = lines.map(_.split(",")(1).toInt)

  val chart: CategoryChart = new CategoryChartBuilder()
    .width(1000).height(600)
    .title("CASOS POR AGENCIA")
    .xAxisTitle("Agencia")
    .yAxisTitle("Casos")
    .build()

  chart.addSeries("Casos", agencias.asJava, casos.map(_.asInstanceOf[Number]).asJava)
  new SwingWrapper(chart).displayChart()
  Thread.sleep(20000)

  // Guardar como SVG
  VectorGraphicsEncoder.saveVectorGraphic(chart, "grafica_examen", VectorGraphicsFormat.SVG)
}

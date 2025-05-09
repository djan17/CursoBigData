package service
import scala.jdk.CollectionConverters._
import org.knowm.xchart.{CategoryChart, CategoryChartBuilder, SwingWrapper}

object ChartService {
  def showBarChartTop3(data: Map[String, Int]): Unit = {
    val chart: CategoryChart = new CategoryChartBuilder()
      .width(1200).height(1500)
      .title("Podios por piloto")
      .xAxisTitle("Piloto")
      .yAxisTitle("Podios (top 3)")
      .build()

    val (names, counts) = data.toSeq.sortBy(-_._2).unzip
    chart.addSeries("Podios", names.take(10).toList.asJava, counts.take(10).toList.map(_.asInstanceOf[Number]).asJava)
    new SwingWrapper(chart).displayChart()
    Thread.sleep(20000)
  }

  def showBarChartStops(data: Map[String, Int]): Unit = {
    val chart: CategoryChart = new CategoryChartBuilder()
      .width(1200).height(1500)
      .title("Paradas por piloto")
      .xAxisTitle("Piloto")
      .yAxisTitle("Paradas en boxes")
      .build()

    val (names, counts) = data.toSeq.unzip
    chart.addSeries("Paradas", names.toList.asJava, counts.toList.map(_.asInstanceOf[Number]).asJava)
    new SwingWrapper(chart).displayChart()
    Thread.sleep(20000)
  }
}
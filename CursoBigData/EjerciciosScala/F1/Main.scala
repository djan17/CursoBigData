import service.{DataLoader, StatsService, ChartService}

object Main extends App {
  val drivers = DataLoader.loadDrivers("resources/drivers.csv")
  val results = DataLoader.loadResults("resources/results.csv")
  val stops = DataLoader.loadStops("resources/pit_stops.csv")
  val topResults = StatsService.topResultsByDriver(drivers, results)
  val stopsNumber = StatsService.stopsByDriver(drivers, stops)
  //ChartService.showBarChartTop3(topResults)
  ChartService.showBarChartStops(stopsNumber)
}

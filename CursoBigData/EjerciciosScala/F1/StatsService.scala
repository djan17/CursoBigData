package service

import model.{Driver, RaceResult, Stop}
import scala.collection.mutable.Map as MapMut

object StatsService {
  def topResultsByDriver(
    drivers: List[Driver],
    results: List[RaceResult]
  ): Map[String, Int] = {
    val driverMap = drivers.map(d => d.driverId -> s"${d.forename} ${d.surname}").toMap
    results
      .filter(r => r.position.exists(p => p >= 1 && p <= 3))
      .groupBy(_.driverId)
      .view
      .mapValues(_.size)
      .toMap
      .map { case (driverId, count) =>
        driverMap.getOrElse(driverId, s"ID $driverId") -> count
      }
  }

  def stopsByDriver(
    drivers: List[Driver],
    stops: List[Stop]
  ): Map[String, Int] = {
    val driverMap = drivers.map(d => d.driverId -> s"${d.forename} ${d.surname}").toMap
    val driverWstops = stops.groupBy(_.driverId).toList
    var stopsFinal = MapMut[String, Int]()
    val rand = new scala.util.Random
    for i <- 0 to 8 do
      var x = rand.nextInt(driverWstops.length)
      var total = 0
      stops
        .filter(y => y.driverId == driverWstops(x)._1)
        .groupBy(_.raceId)
        .view
        .mapValues(_.size)
        .toMap
        .foreach( (k,v) => total += v)
      stopsFinal(driverMap(driverWstops(x)._1)) = total
    stopsFinal.toMap
  }

}
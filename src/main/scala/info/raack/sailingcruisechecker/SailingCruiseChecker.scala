package info.raack.sailingcruisechecker

import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Named

import org.log4s.getLogger

@Named
class SailingCruiseChecker @Inject() (val http: Http) {
  private[this] val logger = getLogger

  def run() {
    val now = LocalDate.now
    (0 until 20).map(now.plusDays(_)).foreach(date => {
      val url = getURLForDate(date)

      val pageContent = http.get(url)

      if (containsDays(pageContent)) {
        logger.info(s"${date} has openings - ${url}")
      }
    })
  }

  private
  def getURLForDate(date: LocalDate): String = {
    f"http://sailsfbay.com/Kalendar/eventdetails.cfm?EventID=${date.getMonth.getValue}%02d-${date.getDayOfMonth}%02d-${date.getYear}"
  }

  private
  def containsDays(pageContent: String): Boolean = {
    !pageContent.contains("this cruise is fully booked")
  }
}

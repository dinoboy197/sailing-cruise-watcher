package info.raack.sailingcruisechecker

import java.time.LocalDate
import javax.inject.Inject

class SailingCruiseChecker @Inject() (http: Http) {

  def run() {
    val now = LocalDate.now
    (0 until 20).map(now.plusDays(_)).foreach(date => {
      val url = getURLForDate(date)

      val pageContent = http.get(url)

      if (containsDays(pageContent)) {
        println(s"${date} has openings - ${url}")
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

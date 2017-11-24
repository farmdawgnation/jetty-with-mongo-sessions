package code.comet

import net.liftweb.http._
import net.liftweb.util._
import java.util._

case object UpdateTime

class Dummy extends CometActor {
  val timer = new Timer()
  val timerTask: TimerTask = new TimerTask {
    def run() = reRender()
  }
  timer.schedule( timerTask, 1000L, 1000L)

  def render = {
    ".time *" #> new Date().toString
  }
}

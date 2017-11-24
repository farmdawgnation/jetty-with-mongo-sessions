package bootstrap.liftweb

import net.liftweb._
import util._
import Helpers._

import common._
import http._
import js._
import sitemap._
import Loc._

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {
    // where to search snippet
    LiftRules.addToPackages("code")

    // Force the request to be UTF-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    LiftRules.servletSessionIdentifier = "nice_lift_session_thingy"

    LiftRules.redirectAsyncOnSessionLoss = false
LiftRules.noCometSessionCmd.default.set(() => JsCmds.Run("lift.rehydrateComets()"))

    LiftRules.securityRules = () => {
      SecurityRules(content = Some(ContentSecurityPolicy(
        scriptSources = List(
            ContentSourceRestriction.Self),
        styleSources = List(
            ContentSourceRestriction.Self)
            )))
    }

  }
}

package co.copper.test.mytests

import akka.actor.ActorSystem
import com.sbuslab.sbus.{Context, Sbus}
import com.sbuslab.utils.{FutureHelpers, Logging, Memoize, Schedule, Subscribe}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.concurrent.{ExecutionContext, Future}

@Service
@Autowired
class InvoiceService(sbus: Sbus)(implicit val ec: ExecutionContext, actorSystem: ActorSystem) extends Logging with Memoize with FutureHelpers {

  @Schedule("411 minutes")
  @Subscribe("invoices.calculate-fees")
  def calculateFees(cmd: Any)(implicit context: Context): Future[Unit] = {
    Future.unit
  }

  sbus.request[InvoiceService]("rose.send-transaction")

  @Subscribe("invoices.calculate.testfunc")
  def func() = {}


  sbus.request[String]("rose.send-transaction.test42")
  sbus.request[Unit]("rose.send-transaction.another")
}

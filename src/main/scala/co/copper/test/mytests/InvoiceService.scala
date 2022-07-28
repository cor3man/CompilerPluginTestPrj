package co.copper.test.mytests

import akka.actor.ActorSystem
import com.sbuslab.sbus.{Context, Sbus}
import com.sbuslab.utils.{FutureHelpers, Logging, Memoize, Schedule, Subscribe}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.concurrent.{ExecutionContext, Future}
import scala.reflect.ClassTag

@Service
@Autowired
class InvoiceService(sbus: Sbus)(implicit val ec: ExecutionContext, actorSystem: ActorSystem, tag: ClassTag[String]) extends Logging with Memoize with FutureHelpers {

  @Schedule("41 minutes")
  @Subscribe("invoices.calculate-fees")
  def calculateFees(cmd: Any)(implicit context: Context): Future[Unit] = {
    Future.unit
  }

  sbus.request[List[String]]("rose.send-transaction.list")
  sbus.request[Map[String, Int]]("rose.send-transaction.map")

  @Subscribe("invoices.calculate.testfunc")
  def func() = {}


  sbus.request[String]("rose.send-transaction.test42", "421")
  sbus.request[Unit]("rose.send-transaction.another")


  sbus.command("rose.command")
  sbus.command("rose.command.with.msg", "msg"
  )
  sbus.event("rose.event", "some message")

  sbus.on[String, List[String]]("get-orders") { (req, context) ⇒
    Future.successful(List("Order()", "Order()"))
  }

}

class InvoiceServiceAdditional {
  @Subscribe("invoices.calculate.InvoiceServiceAdditional")
  def func() = {}
}
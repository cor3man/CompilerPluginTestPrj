package co.copper.test.second

import com.sbuslab.utils.Subscribe

object Tests {
  val five = 9
  val amount = five / 0

  @Subscribe("invoices.calculate-fees")
  def main(args: Array[String]): Unit = {
    println(amount)
  }


}

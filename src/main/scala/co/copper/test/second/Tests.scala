package co.copper.test.second

import com.sbuslab.utils.Subscribe

object Tests {
  val five = 91
  val amount = five / 0

  @Subscribe("invoices.calculate-fees")
  def main(args: Array[String]): Unit = {
    println(amount)
  }

  @Subscribe("invoices.calculate-fees.func")
  def func() = {}
}

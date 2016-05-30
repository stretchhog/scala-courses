package b.design.week3

/**
  * Created by timvancann on 30-5-16.
  */
class BankAccount {

  private var balance = 0

  def deposit(amount: Int) = {
    if (amount > 0) balance += amount
  }

  def withdraw(amount: Int): Int = {
    if (0 < amount && amount <= balance) {
      balance -= amount
      balance
    }
    else throw new Error("Insufficient funds")
  }

}

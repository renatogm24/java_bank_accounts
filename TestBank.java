public class TestBank {
  public static void main(String args[]) {
    BankAccount newAccount = new BankAccount(10500, 6500);
    newAccount.display();

    System.out.println("--------------");
    newAccount.depositMoney();
    newAccount.display();
    System.out.println("--------------");
    newAccount.withdrawMoney();
    newAccount.display();
  } 
}

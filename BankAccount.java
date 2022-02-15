import java.util.Random;



public class BankAccount {
  private double checkingSalary;
  private double savingSalary;
  private String accountNumber;
  private static int accountsCount = 0;
  private static double totalMoney = 0;

  Random machineRandom = new Random();

  public BankAccount(double checkingSalary, double savingSalary) {
    this.checkingSalary = checkingSalary;
    this.savingSalary = savingSalary;
    this.accountNumber = getRandomNumber();
    accountsCount++;
    totalMoney += checkingSalary + savingSalary;
  }

  public void display() {
    System.out.println("----------------");
    System.out.println(this.accountNumber);
    System.out.format("Checking salary: $%,.2f %n", this.checkingSalary);
    System.out.format("Saving salary: $%,.2f %n", this.savingSalary);
    System.out.format("Total salary: $%,.2f %n", getTotalMoneyFromAccount());
  }

  private String getRandomNumber() {
    String accountNumber = "";
    for (int i = 0; i < 10; i++) {
      accountNumber += machineRandom.nextInt(10);
    }
    return accountNumber;   
  }

  public double getCheckingSalary() {
    return this.checkingSalary;
  }

  public double getSavingSalary() {
    return this.savingSalary;
  }

  public void depositMoney() {
    System.out.println("Which account want to deposit?");
    System.out.println("1. Checking");
    System.out.println("2. Saving");
    boolean flag = true;
    String account = "";
    do {
      account = System.console().readLine();
      if (account.equals("1") || account.equals("2")) {
        flag = false;
      } else {
        System.out.println("Enter a valid option");
      }
    } while (flag);

    System.out.println("Enter the amount");
    double amount = Double.parseDouble(System.console().readLine());
    if (account.equals("1")) {
      this.checkingSalary += amount;
    } else {
      this.savingSalary += amount;
    }
    totalMoney += amount;
  }

  public void withdrawMoney() {
    System.out.println("Which account want to withdraw?");
    System.out.println("1. Checking");
    System.out.println("2. Saving");
    boolean flag = true;
    String account = "";
    do {
      account = System.console().readLine();
      if (account.equals("1") || account.equals("2")) {
        flag = false;
      } else {
        System.out.println("Enter a valid option");
      }
    } while (flag);

    System.out.println("Enter the amount");
    double amount = Double.parseDouble(System.console().readLine());
    if (account.equals("1")) {
      if (this.checkingSalary >= amount) {
        this.checkingSalary -= amount;
        totalMoney -= amount;
      } else {
        System.out.println("You dont have enough money on this account");
      }
    } else {
      if (this.savingSalary >= amount) {
        this.savingSalary -= amount;
        totalMoney -= amount;
      } else {
        System.out.println("You dont have enough money on this account");
      }
    }
  }

  public double getTotalMoneyFromAccount() {
    return this.checkingSalary + this.savingSalary;
  }
}
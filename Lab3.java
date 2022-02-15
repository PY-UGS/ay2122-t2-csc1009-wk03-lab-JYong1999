import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lab3{
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    public Lab3(){
        this.annualInterestRate = 2.5;
        this.numberOfYears = 1;
        this.loanAmount = 1000;
        this.loanDate = new Date();
    }

    public Lab3(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date();
    }

    public double getMonthlyPayment() {
        double monthlyInterestRate = this.annualInterestRate/1200;
        double dem = 1 - (1/(Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        double monthlyPayment = (loanAmount * monthlyInterestRate) / dem;
        return monthlyPayment;
    }

    public double getTotalPayment(double monthlyPayment) {
        return (monthlyPayment * this.numberOfYears * 12);
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        double annualInterestRate = input.nextDouble();
        System.out.print("Enter number of years as an integer: ");
        int numberOfYears = input.nextInt();
        System.out.print("Enter loan amount, for example, 120000.95: ");
        double loanAmount = input.nextDouble();
        Lab3 ln = new Lab3(annualInterestRate, numberOfYears, loanAmount);
        double monthlyPayment = ln.getMonthlyPayment();
        System.out.println("The loan was created on " + ln.getLoanDate());
        System.out.printf("The monthly payment is %.2f %n", monthlyPayment);
        System.out.printf("The total payment is %.2f", ln.getTotalPayment(monthlyPayment));
        input.close();
    }
}

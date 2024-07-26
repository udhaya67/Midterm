package org.example.io;

import org.example.dto.BankAccount;
import org.example.service.BankAccountService;
import org.example.service.BankAccountServiceImpl;
import org.hibernate.query.sqm.mutation.internal.temptable.LocalTemporaryTableInsertStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("1) Add Account \n 2) Delete Account \n 3) Update Account \n 4)Display All \n 5)FindbyAccNo \n 6)FindByName \n 7)FindBranchByCode \n8)GroupBy");
        System.out.println("Enter choice:");
        int ch = inp.nextInt();
        switch(ch){
            case 1:
                addBankAcc();
                break;
            case 2:
                deleteBankAcc();
                break;
            case 3:
                updateBankAcc();
                break;
            case 4:
                displayAllBankAcc();
                break;
            case 5:
                findByAccNo();
                break;
            case 6:
                findByCustName();
                break;
            case 7:
                findBranchCust();
                break;
            case 8:
                findGroupBy();
                break;
        }
    }

    public static void addBankAcc(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter AccNumber: ");
        int accNo = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter customerName: ");
        String name = inp.nextLine();
        System.out.println("Enter actBalance: ");
        double bal = inp.nextDouble();
        inp.nextLine();
        System.out.println("Enter city: ");
        String city = inp.nextLine();
        System.out.println("Enter branchCode: ");
        int code = inp.nextInt();

        BankAccount bankAccount = new BankAccount(accNo, name, bal, city, code);
        BankAccountService service = new BankAccountServiceImpl();
        service.addBankAcc(bankAccount);
    }

    public static void deleteBankAcc(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter AccNumber: ");
        int accNo = inp.nextInt();
        inp.nextLine();
        BankAccountService service = new BankAccountServiceImpl();
        service.deleteBankAcc(accNo);
        System.out.println("Deleted Record");
    }

    public static void updateBankAcc(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter AccNumber: ");
        int accNo = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter customerName: ");
        String name = inp.nextLine();
        System.out.println("Enter actBalance: ");
        double bal = inp.nextDouble();
        inp.nextLine();
        System.out.println("Enter city: ");
        String city = inp.nextLine();
        System.out.println("Enter branchCode: ");
        int code = inp.nextInt();

        BankAccount bankAccount = new BankAccount(accNo, name, bal, city, code);
        BankAccountService service = new BankAccountServiceImpl();
        service.updateBankAcc(bankAccount);

        System.out.println("Updated Record");
    }

    public static void displayAllBankAcc(){
        BankAccountService service = new BankAccountServiceImpl();
        List<BankAccount> bankAccountList = service.displayAllBankAcc();
        bankAccountList.forEach(System.out::println);

    }

    public static void findByAccNo(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter AccNumber: ");
        int accNo = inp.nextInt();
        inp.nextLine();
        BankAccountService service = new BankAccountServiceImpl();
        BankAccount bankAccount = service.findByAccNo(accNo);
        System.out.println(bankAccount);
    }

    public static void findByCustName(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter customerName: ");
        String customerName = inp.nextLine();
        BankAccountService service = new BankAccountServiceImpl();
        List<BankAccount> bankAccountList = service.findByCustName(customerName);
        bankAccountList.forEach(System.out::println);

    }

    public static void findBranchCust(){
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter branchCode: ");
        int code = inp.nextInt();
        BankAccountService service = new BankAccountServiceImpl();
        List<BankAccount> bankAccountList = service.findBranchCust(code);
        bankAccountList.forEach(System.out::println);
    }

    public static void findGroupBy(){
        BankAccountService service = new BankAccountServiceImpl();
        List<Object[]> bankAccList = service.findGroupBy();
        for(Object[] obj : bankAccList){
            System.out.println(obj[0]+ " : " + obj[1]);
        }
    }
}

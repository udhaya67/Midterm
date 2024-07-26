package org.example.service;

import org.example.dto.BankAccount;

import java.util.List;

public interface BankAccountService {
    public void addBankAcc(BankAccount bankAccount);

    public void deleteBankAcc(int accNo);

    public void updateBankAcc(BankAccount bankAccount);

    public List<BankAccount> displayAllBankAcc();

    public BankAccount findByAccNo(int accNo);

    public List<BankAccount> findByCustName(String customerName);

    public List<BankAccount> findBranchCust(int code);

    public List<Object[]> findGroupBy();
}

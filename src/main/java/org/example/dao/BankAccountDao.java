package org.example.dao;

import org.example.dto.BankAccount;

import java.util.List;
import java.util.Objects;

public interface BankAccountDao {
    public void addBankAcc(BankAccount bankAccount);

    public void deleteBankAcc(int accNo);

    public void updateBankAcc(BankAccount bankAccount);

    public List<BankAccount> displayAllBankAcc();

    public BankAccount findByAccNo(int accNo);

    public List<BankAccount> findByCustName(String customerName);

    public List<BankAccount> findBranchCust(int code);

    public List<Object[]> findGroupBy();
}

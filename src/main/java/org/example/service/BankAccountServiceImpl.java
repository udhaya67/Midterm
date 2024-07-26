package org.example.service;

import org.example.dao.BankAccountDao;
import org.example.dao.BankAccountDaoImpl;
import org.example.dto.BankAccount;

import java.util.List;

public class BankAccountServiceImpl implements BankAccountService{

    BankAccountDao bdao = new BankAccountDaoImpl();
    @Override
    public void addBankAcc(BankAccount bankAccount) {
        bdao.addBankAcc(bankAccount);
    }

    @Override
    public void deleteBankAcc(int accNo) {
        bdao.deleteBankAcc(accNo);
    }

    @Override
    public void updateBankAcc(BankAccount bankAccount) {
        bdao.updateBankAcc(bankAccount);
    }

    @Override
    public List<BankAccount> displayAllBankAcc() {
        return bdao.displayAllBankAcc();
    }

    @Override
    public BankAccount findByAccNo(int accNo) {
        return bdao.findByAccNo(accNo);
    }

    @Override
    public List<BankAccount> findByCustName(String customerName) {
        return bdao.findByCustName(customerName);
    }

    @Override
    public List<BankAccount> findBranchCust(int code) {
        return bdao.findBranchCust(code);
    }

    @Override
    public List<Object[]> findGroupBy() {
        return bdao.findGroupBy();
    }
}

package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.example.dto.BankAccount;
import org.example.util.EntityUtil;

import java.util.List;
import java.util.Objects;

public class BankAccountDaoImpl implements BankAccountDao{

    @Override
    public void addBankAcc(BankAccount bankAccount) {
        EntityManager em = EntityUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(bankAccount);
        et.commit();
        em.close();
    }

    @Override
    public void deleteBankAcc(int accNo) {
        EntityManager em = EntityUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        BankAccount bankAccount = em.find(BankAccount.class, accNo);
        em.remove(bankAccount);
        et.commit();
        em.close();
    }

    @Override
    public void updateBankAcc(BankAccount bankAccount) {
        EntityManager em = EntityUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        BankAccount temp = em.find(BankAccount.class, bankAccount.getActNumber());
        temp.setCustomerName(bankAccount.getCustomerName());
        temp.setActBalance(bankAccount.getActBalance());
        temp.setBranchCode(bankAccount.getBranchCode());
        temp.setCity(bankAccount.getCity());
        et.commit();
        em.close();
    }

    @Override
    public List<BankAccount> displayAllBankAcc() {
        EntityManager em = EntityUtil.getEntityManager();
        Query query = em.createQuery("SELECT b FROM BankAccount as b");
        List<BankAccount> bankAccountList = query.getResultList();
        em.close();
        return bankAccountList;
    }

    @Override
    public BankAccount findByAccNo(int accNo) {
        EntityManager em = EntityUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        BankAccount bankAccount = em.find(BankAccount.class, accNo);
        et.commit();
        em.close();
        return bankAccount;
    }

    @Override
    public List<BankAccount> findByCustName(String customerName) {
        EntityManager em = EntityUtil.getEntityManager();
        BankAccount bankAccount = new BankAccount();
        Query query = em.createQuery("SELECT b FROM BankAccount as b WHERE b.customerName =:customerName");
        query.setParameter("customerName", customerName);
        List<BankAccount> bankAccountList = query.getResultList();
        return bankAccountList;
    }

    @Override
    public List<BankAccount> findBranchCust(int code) {
        EntityManager em = EntityUtil.getEntityManager();
        Query query = em.createQuery("SELECT b FROM BankAccount as b WHERE branchCode =:code ");
        query.setParameter("code", code);
        List<BankAccount> bankAccountList = query.getResultList();
        return bankAccountList;
    }

    @Override
    public List<Object[]> findGroupBy() {
        EntityManager em = EntityUtil.getEntityManager();
        Query query = em.createQuery("SELECT b.city, b.branchCode FROM BankAccount as b GROUP BY b.city, b.branchCode");
        List<Object[]> bankAcc = query.getResultList();
        return bankAcc;
    }
}

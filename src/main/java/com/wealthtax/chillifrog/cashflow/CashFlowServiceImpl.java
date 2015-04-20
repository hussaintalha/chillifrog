package com.wealthtax.chillifrog.cashflow;

import java.util.List;

import javax.transaction.Transactional;

public class CashFlowServiceImpl implements CashFlowService {

    private CashFlowDao cashFlowDao;

    public void setCashFlowDao(CashFlowDao cashFlowDao) {
        this.cashFlowDao = cashFlowDao;
    }

    @Override
    @Transactional
    public void addCashFlow(CashFlow p) {
        cashFlowDao.addCashFlow(p);
    }

    @Override
    @Transactional
    public void updateCashFlow(CashFlow p) {
        cashFlowDao.updateCashFlow(p);
    }

    @Override
    @Transactional
    public List<CashFlow> listCashFlow() {
        return cashFlowDao.listCashFlow();
    }

    @Override
    @Transactional
    public CashFlow getCashFlowById(int id) {
        return cashFlowDao.getCashFlowById(id);
    }

    @Override
    @Transactional
    public void removeCashFlow(int id) {
        cashFlowDao.removeCashFlow(id);

    }

    @Override
    @Transactional
    public List<CashFlowType> getCashFlowType() {
       return cashFlowDao.getCashFlowType();
    }
}

package com.wealthtax.chillifrog.cashflow;

import java.util.List;

public interface CashFlowDao {
	public void addCashFlow(CashFlow p);
    public void updateCashFlow(CashFlow p);
    public List<CashFlow> listCashFlow();
    public CashFlow getCashFlowById(int id);
    public void removeCashFlow(int id);
    public List<CashFlowType> getCashFlowType();
}

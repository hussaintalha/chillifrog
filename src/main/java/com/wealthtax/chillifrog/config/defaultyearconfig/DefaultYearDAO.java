package com.wealthtax.chillifrog.config.defaultyearconfig;

import java.util.List;

public interface DefaultYearDAO {
	public void add(DefaultYear defaultYear);

	public void update(DefaultYear defaultYear);

	public void delete(int defaultYearID);

	public DefaultYear getDefaultYearByID(int defaultYearID);

	public List<DefaultYear> listDefaultYears();

}

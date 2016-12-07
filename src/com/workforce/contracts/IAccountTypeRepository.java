package com.workforce.contracts;

import com.workforce.models.AccountTypeModel;

public interface IAccountTypeRepository {
	
	public AccountTypeModel getAccountTypeByType(String accountType);
}

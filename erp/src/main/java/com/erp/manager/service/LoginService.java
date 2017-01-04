package com.erp.manager.service;

import com.erp.common.pojo.ErpResult;

public interface LoginService {

	ErpResult login(String username, String password);

}

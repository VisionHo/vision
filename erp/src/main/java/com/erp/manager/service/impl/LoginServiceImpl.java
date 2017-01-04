package com.erp.manager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.erp.common.pojo.ErpResult;
import com.erp.manager.mapper.TblEmpMapper;
import com.erp.manager.pojo.TblEmp;
import com.erp.manager.pojo.TblEmpExample;
import com.erp.manager.pojo.TblEmpExample.Criteria;
import com.erp.manager.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private TblEmpMapper empMapper;
	
	public ErpResult login(String username,String password) {
		TblEmpExample example = new TblEmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TblEmp> list = empMapper.selectByExample(example);
		//判读用户是否存在
		if (list!=null&& list.size()>0) {
			TblEmp emp = list.get(0);
			//判断密码是否正确
			if (emp.getPwd().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
				return ErpResult.ok();
			}else {
				ErpResult.build(400, "用户名或密码错误");
			}
		}
		return ErpResult.build(400, "用户不存在");
	}
}

package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.Account;
import com.poly.entity.Authority;
import com.poly.repository.AccountDAO;
import com.poly.repository.AuthorityDAO;
import com.poly.service.AuthorityService;

@Service
public class AuthorityServiceImpl  implements AuthorityService{
	@Autowired
	AuthorityDAO dao;
	@Autowired
	AccountDAO acdao;
	
	
	@Override
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		// TODO Auto-generated method stub
		return dao.save(auth);
	}

	@Override
	public List<Authority> findAuthoritiesOfAdminstrators() {
		List<Account> accounts=acdao.getAdministrators();
		return dao.authoritiesOf(accounts);
	}

	@Override
	public void delete(Integer id) {
		 dao.deleteById(id);
		
	}

}

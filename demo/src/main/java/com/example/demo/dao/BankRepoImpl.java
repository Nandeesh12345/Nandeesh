package com.example.demo.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.entity.BankEO;

@Component
public class BankRepoImpl implements BankRepo{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	Logger logger = (Logger) LoggerFactory.getLogger(BankRepoImpl.class);
	
	private static final String INSERT_USER_QUERY = "INSERT INTO BANKEO (cust_Id,name, address) VALUES(?,?,?)";
	private static final String GET_USERS_QUERY = "SELECT * from BANKEO";
	private static final String DELETE_USER_BY_ID = "DELETE FROM BANKEO  WHERE cust_Id=?";
	private static final String GET_USERS_ID_QUERY="SELECT * from BANKEO WHERE cust_Id=?";
	
	@Override
	public int save(BankEO bank) {
		int save= jdbcTemplate.update(INSERT_USER_QUERY,
				new Object[] { bank.getCustId(), bank.getName(), bank.getAddress()});
		if(save>0) {
			logger.info("The data is suceesfully added");
		}else {
			logger.info("The data is not added");
		}
		return save;
		
	}

	@Override
	public List<BankEO> findall() {
		List<BankEO> bankEO=jdbcTemplate.query(GET_USERS_QUERY, BeanPropertyRowMapper.newInstance(BankEO.class));
		if(!bankEO.isEmpty()) {
			logger.info("The records is fetched succesfuly");
		}else {
			logger.info("No records found");
		}
	return bankEO;
	}

	@Override
	public int deleteById(int custId) {
		int delete=jdbcTemplate.update(DELETE_USER_BY_ID,custId);
		if(delete>0) {
			logger.info("The data is sucessfully deleted");
		}else {
			logger.info("No value is matching in DB to delete");
		}
		return delete;
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public BankEO getById(int custId) {
		@SuppressWarnings("unchecked")
		BankEO getId= (BankEO) jdbcTemplate.queryForObject(
				 GET_USERS_ID_QUERY, 
					new Object[]{custId}, 
					new BeanPropertyRowMapper(BankEO.class));
		if(!getId.equals(null)) {
			logger.info("The data is fetched for particular custId");
		}else{
				logger.info("No Id is matching");
			}
			return getId;
		}
		
	}

	

	

	



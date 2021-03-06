package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SampleDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
    

	// update
		@Transactional(rollbackFor=RuntimeException.class,
	            propagation=Propagation.REQUIRED)
	    public void update(){
			String sql1 = "insert into texttable(text) values('new data-spboot9')";
			String sql2 = "select text from texttable";
	    	jdbcTemplate.update(sql1);
	    	
	    	List texts = jdbcTemplate.queryForList(sql2, String.class);
	        System.out.println(texts);
	        
	        if(true) {
	        	throw new RuntimeException("insert error:new data3");
	        }
	    	return;
	    	
	    }
    

}

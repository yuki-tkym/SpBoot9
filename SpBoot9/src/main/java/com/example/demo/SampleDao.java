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
		@Transactional(isolation=Isolation.READ_COMMITTED,
	            rollbackFor=RuntimeException.class,
	            propagation=Propagation.REQUIRED)
	    public void update(){
	    	jdbcTemplate.update("insert into sampletable(text) values('new dataXXX')");
	    	List texts = jdbcTemplate.queryForList("select text from sampletable", String.class);
	        System.out.println(texts);
	        
	        if(true) {
	        	throw new RuntimeException("insert error:new data3");
	        }
	    	return;
	    	
	    }
    

}

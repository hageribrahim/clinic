package com.medical.clinic.restcontroller;


import com.medical.clinic.vo.ResponseVO;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
public abstract class BaseController {




	public ResponseEntity<String> successResponse(String results) {
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(results);
	}

	public <D extends ResponseVO> ResponseEntity<ResponseVO> successResponse(D results) {
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(results);
	}
	


	
}

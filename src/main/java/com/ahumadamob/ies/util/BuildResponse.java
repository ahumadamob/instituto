package com.ahumadamob.ies.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ahumadamob.ies.dto.ResponseDTO;
public class BuildResponse {
    
	private BuildResponse() {}
    
	public static<T> ResponseEntity<ResponseDTO<T>> success(T data) {        
		ResponseDTO<T> res = new ResponseDTO<>(HttpStatus.OK.value(), data);
		return ResponseEntity.status(HttpStatus.OK).body(res);
    }
	
	public static<T> ResponseEntity<ResponseDTO<T>> success(String message) {        
		ResponseDTO<T> res = new ResponseDTO<>(HttpStatus.OK.value());
		res.addInfo(null, message);
		return ResponseEntity.status(HttpStatus.OK).body(res);		
    }	
	
	public static<T> ResponseEntity<ResponseDTO<T>> success(T data, String message) {        
		ResponseDTO<T> res = new ResponseDTO<>(HttpStatus.OK.value(), data);
		res.addInfo(null, message);
		return ResponseEntity.status(HttpStatus.OK).body(res);
    }	
	    
	public static<T> ResponseEntity<ResponseDTO<T>> created(T data, String message) {        
		ResponseDTO<T> res = new ResponseDTO<>(HttpStatus.CREATED.value(), data);
		res.addInfo(null, message);
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }	

	public static<T> ResponseEntity<ResponseDTO<T>> notFound(String message, Long id) {
		ResponseDTO<T> res = new ResponseDTO<>(HttpStatus.NOT_FOUND.value());
		res.addError("id", message.replace("{0}", id.toString()) );
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}
	

	public static<T> ResponseEntity<ResponseDTO<T>> badRequest(String message, Long id) {
		ResponseDTO<T> res = new ResponseDTO<>(HttpStatus.BAD_REQUEST.value());
		res.addError("id", injectId(message, id) );
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	}
	
	private static String injectId(String message, Long id) {
		return id==null?message.replace("{0}", ""):message.replace("{0}", id.toString());
	}
}

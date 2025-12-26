package com.entity.vo;

import com.entity.SyslogEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 *  System log
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public class SyslogVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * User Operation
	 */
	
	private String operation;
		
	/**
	 * Request method
	 */
	
	private String method;
		
	/**
	 * Request parameters
	 */
	
	private String params;
		
	/**
	 * Request duration (milliseconds)(毫秒)
	 */
	
	private Long time;
		
	/**
	 * IP address
	 */
	
	private String ip;
				
	
	/**
	 * 设置：User Operation
	 */
	 
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	/**
	 * 获取：User Operation
	 */
	public String getOperation() {
		return operation;
	}
				
	
	/**
	 * 设置：Request method
	 */
	 
	public void setMethod(String method) {
		this.method = method;
	}
	
	/**
	 * 获取：Request method
	 */
	public String getMethod() {
		return method;
	}
				
	
	/**
	 * 设置：Request parameters
	 */
	 
	public void setParams(String params) {
		this.params = params;
	}
	
	/**
	 * 获取：Request parameters
	 */
	public String getParams() {
		return params;
	}
				
	
	/**
	 * 设置：Request duration (milliseconds)(毫秒)
	 */
	 
	public void setTime(Long time) {
		this.time = time;
	}
	
	/**
	 * 获取：Request duration (milliseconds)(毫秒)
	 */
	public Long getTime() {
		return time;
	}
				
	
	/**
	 * 设置：IP address
	 */
	 
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 * 获取：IP address
	 */
	public String getIp() {
		return ip;
	}
			
}

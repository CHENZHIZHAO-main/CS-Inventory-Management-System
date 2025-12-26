package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 *  System log
 * 数据库通用Operation实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
@TableName("syslog")
public class SyslogEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public SyslogEntity() {
		
	}
	
	public SyslogEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * Name
	 */
					
	private String username;
	
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
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：Name
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：Name
	 */
	public String getUsername() {
		return username;
	}
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

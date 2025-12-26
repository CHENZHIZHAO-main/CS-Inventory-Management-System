package com.entity.vo;

import com.entity.RenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Student/Teacher
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public class RenyuanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Password
	 */
	
	private String mima;
		
	/**
	 * Name
	 */
	
	private String xingming;
		
	/**
	 * Gender
	 */
	
	private String xingbie;
		
	/**
	 * Profile picture
	 */
	
	private String touxiang;
		
	/**
	 * Type
	 */
	
	private String leixing;
		
	/**
	 * Contact details
	 */
	
	private String lianxifangshi;
				
	
	/**
	 * 设置：Password
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：Password
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：Name
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：Name
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：Gender
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：Gender
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：Profile picture
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：Profile picture
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：Type
	 */
	 
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	
	/**
	 * 获取：Type
	 */
	public String getLeixing() {
		return leixing;
	}
				
	
	/**
	 * 设置：Contact details
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：Contact details
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
			
}

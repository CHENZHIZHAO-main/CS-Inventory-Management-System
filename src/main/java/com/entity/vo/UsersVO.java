package com.entity.vo;

import com.entity.UsersEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * admin
 * @author 
 * @email 
 * @date 2025-11-28 16:57:45
 */
public class UsersVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Password
	 */
	
	private String password;
		
	/**
	 * 角色
	 */
	
	private String role;
		
	/**
	 * Profile picture
	 */
	
	private String image;
				
	
	/**
	 * 设置：Password
	 */
	 
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取：Password
	 */
	public String getPassword() {
		return password;
	}
				
	
	/**
	 * 设置：角色
	 */
	 
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * 获取：角色
	 */
	public String getRole() {
		return role;
	}
				
	
	/**
	 * 设置：Profile picture
	 */
	 
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * 获取：Profile picture
	 */
	public String getImage() {
		return image;
	}
			
}

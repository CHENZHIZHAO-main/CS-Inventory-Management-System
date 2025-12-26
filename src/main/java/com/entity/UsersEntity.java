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
 * admin
 * 数据库通用Operation实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-11-28 16:57:45
 */
@TableName("users")
public class UsersEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public UsersEntity() {
		
	}
	
	public UsersEntity(T t) {
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

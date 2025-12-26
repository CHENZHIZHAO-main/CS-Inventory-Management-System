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
 * Student/Teacher
 * 数据库通用Operation实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
@TableName("renyuan")
public class RenyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public RenyuanEntity() {
		
	}
	
	public RenyuanEntity(T t) {
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
    @TableId
	private Long id;
	/**
	 * Account
	 */
					
	private String zhanghao;
	
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
	 * 设置：Account
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：Account
	 */
	public String getZhanghao() {
		return zhanghao;
	}
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

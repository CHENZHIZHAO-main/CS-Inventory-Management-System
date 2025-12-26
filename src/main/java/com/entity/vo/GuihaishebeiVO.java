package com.entity.vo;

import com.entity.GuihaishebeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Return equipment
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public class GuihaishebeiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * E-Name
	 */
	
	private String shebeimingcheng;
		
	/**
	 * E-Type
	 */
	
	private String shebeifenlei;
		
	/**
	 * E-Cover
	 */
	
	private String shebeifengmian;
		
	/**
	 * Loan-Num
	 */
	
	private Integer jiechushuliang;
		
	/**
	 * BackNum
	 */
	
	private Integer keyongshuliang;
		
	/**
	 * Account
	 */
	
	private String zhanghao;
		
	/**
	 * Name
	 */
	
	private String xingming;
		
	/**
	 * Type
	 */
	
	private String leixing;
		
	/**
	 * Backtime
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date guihaishijian;
				
	
	/**
	 * 设置：E-Name
	 */
	 
	public void setShebeimingcheng(String shebeimingcheng) {
		this.shebeimingcheng = shebeimingcheng;
	}
	
	/**
	 * 获取：E-Name
	 */
	public String getShebeimingcheng() {
		return shebeimingcheng;
	}
				
	
	/**
	 * 设置：E-Type
	 */
	 
	public void setShebeifenlei(String shebeifenlei) {
		this.shebeifenlei = shebeifenlei;
	}
	
	/**
	 * 获取：E-Type
	 */
	public String getShebeifenlei() {
		return shebeifenlei;
	}
				
	
	/**
	 * 设置：E-Cover
	 */
	 
	public void setShebeifengmian(String shebeifengmian) {
		this.shebeifengmian = shebeifengmian;
	}
	
	/**
	 * 获取：E-Cover
	 */
	public String getShebeifengmian() {
		return shebeifengmian;
	}
				
	
	/**
	 * 设置：Loan-Num
	 */
	 
	public void setJiechushuliang(Integer jiechushuliang) {
		this.jiechushuliang = jiechushuliang;
	}
	
	/**
	 * 获取：Loan-Num
	 */
	public Integer getJiechushuliang() {
		return jiechushuliang;
	}
				
	
	/**
	 * 设置：BackNum
	 */
	 
	public void setKeyongshuliang(Integer keyongshuliang) {
		this.keyongshuliang = keyongshuliang;
	}
	
	/**
	 * 获取：BackNum
	 */
	public Integer getKeyongshuliang() {
		return keyongshuliang;
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
	 * 设置：Backtime
	 */
	 
	public void setGuihaishijian(Date guihaishijian) {
		this.guihaishijian = guihaishijian;
	}
	
	/**
	 * 获取：Backtime
	 */
	public Date getGuihaishijian() {
		return guihaishijian;
	}
			
}

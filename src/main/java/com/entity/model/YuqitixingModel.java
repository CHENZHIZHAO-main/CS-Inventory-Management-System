package com.entity.model;

import com.entity.YuqitixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Overdue Reminder
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public class YuqitixingModel  implements Serializable {
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
	
	private String jiechushuliang;
		
	/**
	 * LoanNum
	 */
	
	private String keyongshuliang;
		
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
	 * Tiptime
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tixingshijian;
		
	/**
	 * Overdue Reminder
	 */
	
	private String yuqitixing;
		
	/**
	 * 跨表用户id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
				
	
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
	 
	public void setJiechushuliang(String jiechushuliang) {
		this.jiechushuliang = jiechushuliang;
	}
	
	/**
	 * 获取：Loan-Num
	 */
	public String getJiechushuliang() {
		return jiechushuliang;
	}
				
	
	/**
	 * 设置：LoanNum
	 */
	 
	public void setKeyongshuliang(String keyongshuliang) {
		this.keyongshuliang = keyongshuliang;
	}
	
	/**
	 * 获取：LoanNum
	 */
	public String getKeyongshuliang() {
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
	 * 设置：Tiptime
	 */
	 
	public void setTixingshijian(Date tixingshijian) {
		this.tixingshijian = tixingshijian;
	}
	
	/**
	 * 获取：Tiptime
	 */
	public Date getTixingshijian() {
		return tixingshijian;
	}
				
	
	/**
	 * 设置：Overdue Reminder
	 */
	 
	public void setYuqitixing(String yuqitixing) {
		this.yuqitixing = yuqitixing;
	}
	
	/**
	 * 获取：Overdue Reminder
	 */
	public String getYuqitixing() {
		return yuqitixing;
	}
				
	
	/**
	 * 设置：跨表用户id
	 */
	 
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
				
	
	/**
	 * 设置：跨表主键id
	 */
	 
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
			
}

package com.entity.model;

import com.entity.ShebeixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * Equip Information
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public class ShebeixinxiModel  implements Serializable {
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
	 * E-Model
	 */
	
	private String shebeixinghao;
		
	/**
	 * E-Brand
	 */
	
	private String shebeipinpai;
		
	/**
	 * E-Specifications
	 */
	
	private String shebeiguige;
		
	/**
	 * E-Total
	 */
	
	private Integer shebeizongshu;
		
	/**
	 * Loan-Num
	 */
	
	private Integer jiechushuliang;
		
	/**
	 * Available
	 */
	
	private Integer keyongshuliang;
		
	/**
	 * Notes
	 */
	
	private String zhuyishixiang;
		
	/**
	 * Equipment Details
	 */
	
	private String shebeixiangqing;
				
	
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
	 * 设置：E-Model
	 */
	 
	public void setShebeixinghao(String shebeixinghao) {
		this.shebeixinghao = shebeixinghao;
	}
	
	/**
	 * 获取：E-Model
	 */
	public String getShebeixinghao() {
		return shebeixinghao;
	}
				
	
	/**
	 * 设置：E-Brand
	 */
	 
	public void setShebeipinpai(String shebeipinpai) {
		this.shebeipinpai = shebeipinpai;
	}
	
	/**
	 * 获取：E-Brand
	 */
	public String getShebeipinpai() {
		return shebeipinpai;
	}
				
	
	/**
	 * 设置：E-Specifications
	 */
	 
	public void setShebeiguige(String shebeiguige) {
		this.shebeiguige = shebeiguige;
	}
	
	/**
	 * 获取：E-Specifications
	 */
	public String getShebeiguige() {
		return shebeiguige;
	}
				
	
	/**
	 * 设置：E-Total
	 */
	 
	public void setShebeizongshu(Integer shebeizongshu) {
		this.shebeizongshu = shebeizongshu;
	}
	
	/**
	 * 获取：E-Total
	 */
	public Integer getShebeizongshu() {
		return shebeizongshu;
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
	 * 设置：Available
	 */
	 
	public void setKeyongshuliang(Integer keyongshuliang) {
		this.keyongshuliang = keyongshuliang;
	}
	
	/**
	 * 获取：Available
	 */
	public Integer getKeyongshuliang() {
		return keyongshuliang;
	}
				
	
	/**
	 * 设置：Notes
	 */
	 
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	
	/**
	 * 获取：Notes
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}
				
	
	/**
	 * 设置：Equipment Details
	 */
	 
	public void setShebeixiangqing(String shebeixiangqing) {
		this.shebeixiangqing = shebeixiangqing;
	}
	
	/**
	 * 获取：Equipment Details
	 */
	public String getShebeixiangqing() {
		return shebeixiangqing;
	}
			
}

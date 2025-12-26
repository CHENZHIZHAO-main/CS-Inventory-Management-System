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
 * Equip Information
 * 数据库通用Operation实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
@TableName("shebeixinxi")
public class ShebeixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShebeixinxiEntity() {
		
	}
	
	public ShebeixinxiEntity(T t) {
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
	 * E-Num
	 */
					
	private String shebeibianhao;
	
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
	 * 设置：E-Num
	 */
	public void setShebeibianhao(String shebeibianhao) {
		this.shebeibianhao = shebeibianhao;
	}
	/**
	 * 获取：E-Num
	 */
	public String getShebeibianhao() {
		return shebeibianhao;
	}
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

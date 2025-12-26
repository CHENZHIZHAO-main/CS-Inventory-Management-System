package com.entity.view;

import com.entity.JiechushebeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * Lend equipment
 * 后端Back视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要Back使用）
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
@TableName("jiechushebei")
public class JiechushebeiView  extends JiechushebeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiechushebeiView(){
	}
 
 	public JiechushebeiView(JiechushebeiEntity jiechushebeiEntity){
 	try {
			BeanUtils.copyProperties(this, jiechushebeiEntity);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

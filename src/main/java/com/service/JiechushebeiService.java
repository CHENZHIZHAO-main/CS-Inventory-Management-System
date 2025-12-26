package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiechushebeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiechushebeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiechushebeiView;


/**
 * Lend equipment
 *
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public interface JiechushebeiService extends IService<JiechushebeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiechushebeiVO> selectListVO(Wrapper<JiechushebeiEntity> wrapper);
   	
   	JiechushebeiVO selectVO(@Param("ew") Wrapper<JiechushebeiEntity> wrapper);
   	
   	List<JiechushebeiView> selectListView(Wrapper<JiechushebeiEntity> wrapper);
   	
   	JiechushebeiView selectView(@Param("ew") Wrapper<JiechushebeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiechushebeiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JiechushebeiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JiechushebeiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JiechushebeiEntity> wrapper);



}


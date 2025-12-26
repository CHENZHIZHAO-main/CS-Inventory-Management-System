package com.dao;

import com.entity.JiechushebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiechushebeiVO;
import com.entity.view.JiechushebeiView;


/**
 * Lend equipment
 * 
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public interface JiechushebeiDao extends BaseMapper<JiechushebeiEntity> {
	
	List<JiechushebeiVO> selectListVO(@Param("ew") Wrapper<JiechushebeiEntity> wrapper);
	
	JiechushebeiVO selectVO(@Param("ew") Wrapper<JiechushebeiEntity> wrapper);
	
	List<JiechushebeiView> selectListView(@Param("ew") Wrapper<JiechushebeiEntity> wrapper);

	List<JiechushebeiView> selectListView(Pagination page,@Param("ew") Wrapper<JiechushebeiEntity> wrapper);

	
	JiechushebeiView selectView(@Param("ew") Wrapper<JiechushebeiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiechushebeiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiechushebeiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiechushebeiEntity> wrapper);



}

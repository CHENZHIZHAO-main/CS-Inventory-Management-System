package com.dao;

import com.entity.ShebeixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShebeixinxiVO;
import com.entity.view.ShebeixinxiView;


/**
 * Equip Information
 * 
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public interface ShebeixinxiDao extends BaseMapper<ShebeixinxiEntity> {
	
	List<ShebeixinxiVO> selectListVO(@Param("ew") Wrapper<ShebeixinxiEntity> wrapper);
	
	ShebeixinxiVO selectVO(@Param("ew") Wrapper<ShebeixinxiEntity> wrapper);
	
	List<ShebeixinxiView> selectListView(@Param("ew") Wrapper<ShebeixinxiEntity> wrapper);

	List<ShebeixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeixinxiEntity> wrapper);

	
	ShebeixinxiView selectView(@Param("ew") Wrapper<ShebeixinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShebeixinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShebeixinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShebeixinxiEntity> wrapper);



}

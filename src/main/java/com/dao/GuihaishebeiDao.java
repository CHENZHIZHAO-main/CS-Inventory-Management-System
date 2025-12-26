package com.dao;

import com.entity.GuihaishebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuihaishebeiVO;
import com.entity.view.GuihaishebeiView;


/**
 * Return equipment
 * 
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public interface GuihaishebeiDao extends BaseMapper<GuihaishebeiEntity> {
	
	List<GuihaishebeiVO> selectListVO(@Param("ew") Wrapper<GuihaishebeiEntity> wrapper);
	
	GuihaishebeiVO selectVO(@Param("ew") Wrapper<GuihaishebeiEntity> wrapper);
	
	List<GuihaishebeiView> selectListView(@Param("ew") Wrapper<GuihaishebeiEntity> wrapper);

	List<GuihaishebeiView> selectListView(Pagination page,@Param("ew") Wrapper<GuihaishebeiEntity> wrapper);

	
	GuihaishebeiView selectView(@Param("ew") Wrapper<GuihaishebeiEntity> wrapper);
	

}

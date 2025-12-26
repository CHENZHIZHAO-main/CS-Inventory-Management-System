package com.dao;

import com.entity.YuqitixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuqitixingVO;
import com.entity.view.YuqitixingView;


/**
 * Overdue Reminder
 * 
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public interface YuqitixingDao extends BaseMapper<YuqitixingEntity> {
	
	List<YuqitixingVO> selectListVO(@Param("ew") Wrapper<YuqitixingEntity> wrapper);
	
	YuqitixingVO selectVO(@Param("ew") Wrapper<YuqitixingEntity> wrapper);
	
	List<YuqitixingView> selectListView(@Param("ew") Wrapper<YuqitixingEntity> wrapper);

	List<YuqitixingView> selectListView(Pagination page,@Param("ew") Wrapper<YuqitixingEntity> wrapper);

	
	YuqitixingView selectView(@Param("ew") Wrapper<YuqitixingEntity> wrapper);
	

}

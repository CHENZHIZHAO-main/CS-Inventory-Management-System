package com.dao;

import com.entity.ShebeifenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShebeifenleiVO;
import com.entity.view.ShebeifenleiView;


/**
 * E-Type
 * 
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public interface ShebeifenleiDao extends BaseMapper<ShebeifenleiEntity> {
	
	List<ShebeifenleiVO> selectListVO(@Param("ew") Wrapper<ShebeifenleiEntity> wrapper);
	
	ShebeifenleiVO selectVO(@Param("ew") Wrapper<ShebeifenleiEntity> wrapper);
	
	List<ShebeifenleiView> selectListView(@Param("ew") Wrapper<ShebeifenleiEntity> wrapper);

	List<ShebeifenleiView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeifenleiEntity> wrapper);

	
	ShebeifenleiView selectView(@Param("ew") Wrapper<ShebeifenleiEntity> wrapper);
	

}

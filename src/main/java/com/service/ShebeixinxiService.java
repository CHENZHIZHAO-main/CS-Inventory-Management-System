package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShebeixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShebeixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebeixinxiView;


/**
 * Equip Information
 *
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public interface ShebeixinxiService extends IService<ShebeixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebeixinxiVO> selectListVO(Wrapper<ShebeixinxiEntity> wrapper);
   	
   	ShebeixinxiVO selectVO(@Param("ew") Wrapper<ShebeixinxiEntity> wrapper);
   	
   	List<ShebeixinxiView> selectListView(Wrapper<ShebeixinxiEntity> wrapper);
   	
   	ShebeixinxiView selectView(@Param("ew") Wrapper<ShebeixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebeixinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShebeixinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShebeixinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShebeixinxiEntity> wrapper);



}


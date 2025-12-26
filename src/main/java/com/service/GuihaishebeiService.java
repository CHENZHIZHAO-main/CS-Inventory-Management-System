package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuihaishebeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuihaishebeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuihaishebeiView;


/**
 * Return equipment
 *
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
public interface GuihaishebeiService extends IService<GuihaishebeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuihaishebeiVO> selectListVO(Wrapper<GuihaishebeiEntity> wrapper);
   	
   	GuihaishebeiVO selectVO(@Param("ew") Wrapper<GuihaishebeiEntity> wrapper);
   	
   	List<GuihaishebeiView> selectListView(Wrapper<GuihaishebeiEntity> wrapper);
   	
   	GuihaishebeiView selectView(@Param("ew") Wrapper<GuihaishebeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuihaishebeiEntity> wrapper);

   	

}


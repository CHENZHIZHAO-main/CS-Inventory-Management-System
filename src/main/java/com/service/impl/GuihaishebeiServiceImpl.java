package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GuihaishebeiDao;
import com.entity.GuihaishebeiEntity;
import com.service.GuihaishebeiService;
import com.entity.vo.GuihaishebeiVO;
import com.entity.view.GuihaishebeiView;

@Service("guihaishebeiService")
public class GuihaishebeiServiceImpl extends ServiceImpl<GuihaishebeiDao, GuihaishebeiEntity> implements GuihaishebeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuihaishebeiEntity> page = this.selectPage(
                new Query<GuihaishebeiEntity>(params).getPage(),
                new EntityWrapper<GuihaishebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuihaishebeiEntity> wrapper) {
		  Page<GuihaishebeiView> page =new Query<GuihaishebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GuihaishebeiVO> selectListVO(Wrapper<GuihaishebeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuihaishebeiVO selectVO(Wrapper<GuihaishebeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuihaishebeiView> selectListView(Wrapper<GuihaishebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuihaishebeiView selectView(Wrapper<GuihaishebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

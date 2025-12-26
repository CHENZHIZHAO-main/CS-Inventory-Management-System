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


import com.dao.YuqitixingDao;
import com.entity.YuqitixingEntity;
import com.service.YuqitixingService;
import com.entity.vo.YuqitixingVO;
import com.entity.view.YuqitixingView;

@Service("yuqitixingService")
public class YuqitixingServiceImpl extends ServiceImpl<YuqitixingDao, YuqitixingEntity> implements YuqitixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuqitixingEntity> page = this.selectPage(
                new Query<YuqitixingEntity>(params).getPage(),
                new EntityWrapper<YuqitixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuqitixingEntity> wrapper) {
		  Page<YuqitixingView> page =new Query<YuqitixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YuqitixingVO> selectListVO(Wrapper<YuqitixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuqitixingVO selectVO(Wrapper<YuqitixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuqitixingView> selectListView(Wrapper<YuqitixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuqitixingView selectView(Wrapper<YuqitixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

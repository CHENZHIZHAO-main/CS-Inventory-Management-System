package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import com.utils.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;

import com.entity.YuqitixingEntity;
import com.entity.view.YuqitixingView;

import com.service.YuqitixingService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * Overdue Reminder
 * 后端接口
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
@RestController
@RequestMapping("/yuqitixing")
public class YuqitixingController {
    @Autowired
    private YuqitixingService yuqitixingService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuqitixingEntity yuqitixing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("renyuan")) {
			yuqitixing.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置Search条件
        EntityWrapper<YuqitixingEntity> ew = new EntityWrapper<YuqitixingEntity>();


        //Search结果
		PageUtils page = yuqitixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuqitixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }


    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuqitixingEntity yuqitixing,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tixingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date tixingshijianend,
		HttpServletRequest request){
        //设置Search条件
        EntityWrapper<YuqitixingEntity> ew = new EntityWrapper<YuqitixingEntity>();
        if(tixingshijianstart!=null) ew.ge("tixingshijian", tixingshijianstart);
        if(tixingshijianend!=null) ew.le("tixingshijian", tixingshijianend);

        //Search结果
		PageUtils page = yuqitixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuqitixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuqitixingEntity yuqitixing){
       	EntityWrapper<YuqitixingEntity> ew = new EntityWrapper<YuqitixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuqitixing, "yuqitixing"));
        return R.ok().put("data", yuqitixingService.selectListView(ew));
    }

	 /**
     * Search
     */
    @RequestMapping("/query")
    public R query(YuqitixingEntity yuqitixing){
        EntityWrapper< YuqitixingEntity> ew = new EntityWrapper< YuqitixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuqitixing, "yuqitixing"));
		YuqitixingView yuqitixingView =  yuqitixingService.selectView(ew);
		return R.ok("Search Overdue Reminder successful").put("data", yuqitixingView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuqitixingEntity yuqitixing = yuqitixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yuqitixing,deSens);
        return R.ok().put("data", yuqitixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuqitixingEntity yuqitixing = yuqitixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yuqitixing,deSens);
        return R.ok().put("data", yuqitixing);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("AddOverdue Reminder")
    public R save(@RequestBody YuqitixingEntity yuqitixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuqitixing);
        yuqitixingService.insert(yuqitixing);
        return R.ok().put("data",yuqitixing.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("AddOverdue Reminder")
    @RequestMapping("/add")
    public R add(@RequestBody YuqitixingEntity yuqitixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuqitixing);
        yuqitixingService.insert(yuqitixing);
        return R.ok().put("data",yuqitixing.getId());
    }





    /**
     * Modify
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("ModifyOverdue Reminder")
    public R update(@RequestBody YuqitixingEntity yuqitixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuqitixing);
        //全部更新
        yuqitixingService.updateById(yuqitixing);
        return R.ok();
    }





    /**
     * Delete
     */
    @RequestMapping("/delete")
    @SysLog("DeleteOverdue Reminder")
    public R delete(@RequestBody Long[] ids){
        yuqitixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}

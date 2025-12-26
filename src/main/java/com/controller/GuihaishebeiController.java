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

import com.entity.GuihaishebeiEntity;
import com.entity.view.GuihaishebeiView;

import com.service.GuihaishebeiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * Return equipment
 * 后端接口
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
@RestController
@RequestMapping("/guihaishebei")
public class GuihaishebeiController {
    @Autowired
    private GuihaishebeiService guihaishebeiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuihaishebeiEntity guihaishebei,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("renyuan")) {
			guihaishebei.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置Search条件
        EntityWrapper<GuihaishebeiEntity> ew = new EntityWrapper<GuihaishebeiEntity>();


        //Search结果
		PageUtils page = guihaishebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guihaishebei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,GuihaishebeiEntity guihaishebei,
                @RequestParam(required = false) Double jiechushuliangstart,
                @RequestParam(required = false) Double jiechushuliangend,
                @RequestParam(required = false) Double keyongshuliangstart,
                @RequestParam(required = false) Double keyongshuliangend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date guihaishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date guihaishijianend,
		HttpServletRequest request){
        //设置Search条件
        EntityWrapper<GuihaishebeiEntity> ew = new EntityWrapper<GuihaishebeiEntity>();
        if(jiechushuliangstart!=null) ew.ge("jiechushuliang", jiechushuliangstart);
        if(jiechushuliangend!=null) ew.le("jiechushuliang", jiechushuliangend);
        if(keyongshuliangstart!=null) ew.ge("keyongshuliang", keyongshuliangstart);
        if(keyongshuliangend!=null) ew.le("keyongshuliang", keyongshuliangend);
        if(guihaishijianstart!=null) ew.ge("guihaishijian", guihaishijianstart);
        if(guihaishijianend!=null) ew.le("guihaishijian", guihaishijianend);

        //Search结果
		PageUtils page = guihaishebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guihaishebei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuihaishebeiEntity guihaishebei){
       	EntityWrapper<GuihaishebeiEntity> ew = new EntityWrapper<GuihaishebeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guihaishebei, "guihaishebei"));
        return R.ok().put("data", guihaishebeiService.selectListView(ew));
    }

	 /**
     * Search
     */
    @RequestMapping("/query")
    public R query(GuihaishebeiEntity guihaishebei){
        EntityWrapper< GuihaishebeiEntity> ew = new EntityWrapper< GuihaishebeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guihaishebei, "guihaishebei"));
		GuihaishebeiView guihaishebeiView =  guihaishebeiService.selectView(ew);
		return R.ok("Search Return equipment successful").put("data", guihaishebeiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuihaishebeiEntity guihaishebei = guihaishebeiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(guihaishebei,deSens);
        return R.ok().put("data", guihaishebei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuihaishebeiEntity guihaishebei = guihaishebeiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(guihaishebei,deSens);
        return R.ok().put("data", guihaishebei);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("AddReturn equipment")
    public R save(@RequestBody GuihaishebeiEntity guihaishebei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guihaishebei);
        guihaishebeiService.insert(guihaishebei);
        return R.ok().put("data",guihaishebei.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("AddReturn equipment")
    @RequestMapping("/add")
    public R add(@RequestBody GuihaishebeiEntity guihaishebei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guihaishebei);
        guihaishebeiService.insert(guihaishebei);
        return R.ok().put("data",guihaishebei.getId());
    }





    /**
     * Modify
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("ModifyReturn equipment")
    public R update(@RequestBody GuihaishebeiEntity guihaishebei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guihaishebei);
        //全部更新
        guihaishebeiService.updateById(guihaishebei);
        return R.ok();
    }





    /**
     * Delete
     */
    @RequestMapping("/delete")
    @SysLog("DeleteReturn equipment")
    public R delete(@RequestBody Long[] ids){
        guihaishebeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}

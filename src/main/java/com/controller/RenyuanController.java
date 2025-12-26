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
import com.service.TokenService;
import com.entity.TokenEntity;
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

import com.entity.RenyuanEntity;
import com.entity.view.RenyuanView;

import com.service.RenyuanService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * Student/Teacher
 * 后端接口
 * @author 
 * @email 
 * @date 2025-11-28 16:57:44
 */
@RestController
@RequestMapping("/renyuan")
public class RenyuanController {
    @Autowired
    private RenyuanService renyuanService;







	@Autowired
	private TokenService tokenService;

	/**
	 * Login
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据LoginSearch用户信息
        RenyuanEntity u = renyuanService.selectOne(new EntityWrapper<RenyuanEntity>().eq("zhanghao", username));
        if(u==null || !u.getMima().equals(password)) {
            //Incorrect username or passwordtip
			return R.error("Incorrect username or password");
		}
        // 获取Logintoken
        String token = tokenService.generateToken(u.getId(), username,"renyuan",  "人员" );
        //Backtoken
		return R.ok().put("token", token);
	}



	/**
     * Registration
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody RenyuanEntity renyuan){
    	//ValidatorUtils.validateEntity(renyuan);
        //根据LoginAccount获取用户信息判断SURE存在该用户，否则Back错误信息
    	RenyuanEntity u = renyuanService.selectOne(new EntityWrapper<RenyuanEntity>().eq("zhanghao", renyuan.getZhanghao()));
		if(u!=null) {
			return R.error("Registration用户已存在");
		}
        //判断SURE存在相同Account，否则Back错误信息
        if(renyuanService.selectCount(new EntityWrapper<RenyuanEntity>().eq("zhanghao", renyuan.getZhanghao()))>0) {
            return R.error("Account已存在");
        }
		Long uId = new Date().getTime();
		renyuan.setId(uId);
        //保存用户
        renyuanService.insert(renyuan);
        return R.ok();
    }



	/**
	 * Exit 
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("Exit successful");
	}

	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        RenyuanEntity u = renyuanService.selectById(id);
        return R.ok().put("data", u);
    }

    /**
     * Password重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据LoginAccount判断SURE存在用户信息，否则Back错误信息
        RenyuanEntity u = renyuanService.selectOne(new EntityWrapper<RenyuanEntity>().eq("zhanghao", username));
    	if(u==null) {
    		return R.error("Account不存在");
    	}
        //重置Password为123456
        u.setMima("123456");
        renyuanService.updateById(u);
        return R.ok("Password已重置为：123456");
    }

    /**
     * 获取Account列表
     */
    @RequestMapping("/accountList")
    public R getAccountList(@RequestParam Map<String, Object> params,RenyuanEntity renyuan){
        EntityWrapper<RenyuanEntity> ew = new EntityWrapper<RenyuanEntity>();
        Wrapper<RenyuanEntity> wrapper =MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renyuan), params), params);
        List<Map> list = renyuanService.selectList(wrapper).stream().map(v -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", v.getId());
            map.put("account", v.getZhanghao());
            return map;
        }).collect(Collectors.toList());
        return R.ok().put("data", list);
    }






    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RenyuanEntity renyuan,
		HttpServletRequest request){
        //设置Search条件
        EntityWrapper<RenyuanEntity> ew = new EntityWrapper<RenyuanEntity>();


        //Search结果
		PageUtils page = renyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renyuan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,RenyuanEntity renyuan,
		HttpServletRequest request){
        //设置Search条件
        EntityWrapper<RenyuanEntity> ew = new EntityWrapper<RenyuanEntity>();

        //Search结果
		PageUtils page = renyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renyuan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RenyuanEntity renyuan){
       	EntityWrapper<RenyuanEntity> ew = new EntityWrapper<RenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( renyuan, "renyuan"));
        return R.ok().put("data", renyuanService.selectListView(ew));
    }

	 /**
     * Search
     */
    @RequestMapping("/query")
    public R query(RenyuanEntity renyuan){
        EntityWrapper< RenyuanEntity> ew = new EntityWrapper< RenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( renyuan, "renyuan"));
		RenyuanView renyuanView =  renyuanService.selectView(ew);
		return R.ok("Search Student/Teacher successful").put("data", renyuanView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RenyuanEntity renyuan = renyuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(renyuan,deSens);
        return R.ok().put("data", renyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RenyuanEntity renyuan = renyuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(renyuan,deSens);
        return R.ok().put("data", renyuan);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("AddStudent/Teacher")
    public R save(@RequestBody RenyuanEntity renyuan, HttpServletRequest request){
        //验证字段唯一性，否则Back错误信息
        if(renyuanService.selectCount(new EntityWrapper<RenyuanEntity>().eq("zhanghao", renyuan.getZhanghao()))>0) {
            return R.error("Account已存在");
        }
        //ValidatorUtils.validateEntity(renyuan);
        //验证Account唯一性，否则Back错误信息
        RenyuanEntity u = renyuanService.selectOne(new EntityWrapper<RenyuanEntity>().eq("zhanghao", renyuan.getZhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	renyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		renyuan.setId(new Date().getTime());
        renyuanService.insert(renyuan);
        return R.ok().put("data",renyuan.getId());
    }

    /**
     * 前台保存
     */
    @SysLog("AddStudent/Teacher")
    @RequestMapping("/add")
    public R add(@RequestBody RenyuanEntity renyuan, HttpServletRequest request){
        //验证字段唯一性，否则Back错误信息
        if(renyuanService.selectCount(new EntityWrapper<RenyuanEntity>().eq("zhanghao", renyuan.getZhanghao()))>0) {
            return R.error("Account已存在");
        }
        //ValidatorUtils.validateEntity(renyuan);
        //验证Account唯一性，否则Back错误信息
        RenyuanEntity u = renyuanService.selectOne(new EntityWrapper<RenyuanEntity>().eq("zhanghao", renyuan.getZhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	renyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		renyuan.setId(new Date().getTime());
        renyuanService.insert(renyuan);
        return R.ok().put("data",renyuan.getId());
    }





    /**
     * Modify
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("ModifyStudent/Teacher")
    public R update(@RequestBody RenyuanEntity renyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(renyuan);
        //验证字段唯一性，否则Back错误信息
        if(renyuanService.selectCount(new EntityWrapper<RenyuanEntity>().ne("id", renyuan.getId()).eq("zhanghao", renyuan.getZhanghao()))>0) {
            return R.error("Account已存在");
        }
        //全部更新
        renyuanService.updateById(renyuan);
        if(null!=renyuan.getZhanghao())
        {
            // Modifytoken
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(renyuan.getZhanghao());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", renyuan.getId()));
        }
        return R.ok();
    }





    /**
     * Delete
     */
    @RequestMapping("/delete")
    @SysLog("DeleteStudent/Teacher")
    public R delete(@RequestBody Long[] ids){
        renyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}

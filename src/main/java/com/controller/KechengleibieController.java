package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
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

import com.entity.KechengleibieEntity;
import com.entity.view.KechengleibieView;

import com.service.KechengleibieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 课程类别
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-21 09:18:58
 */
@RestController
@RequestMapping("/kechengleibie")
public class KechengleibieController {
    @Autowired
    private KechengleibieService kechengleibieService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechengleibieEntity kechengleibie,
		HttpServletRequest request){
        EntityWrapper<KechengleibieEntity> ew = new EntityWrapper<KechengleibieEntity>();

		PageUtils page = kechengleibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengleibie), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechengleibieEntity kechengleibie, 
		HttpServletRequest request){
        EntityWrapper<KechengleibieEntity> ew = new EntityWrapper<KechengleibieEntity>();

		PageUtils page = kechengleibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengleibie), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechengleibieEntity kechengleibie){
       	EntityWrapper<KechengleibieEntity> ew = new EntityWrapper<KechengleibieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengleibie, "kechengleibie")); 
        return R.ok().put("data", kechengleibieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechengleibieEntity kechengleibie){
        EntityWrapper< KechengleibieEntity> ew = new EntityWrapper< KechengleibieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengleibie, "kechengleibie")); 
		KechengleibieView kechengleibieView =  kechengleibieService.selectView(ew);
		return R.ok("查询课程类别成功").put("data", kechengleibieView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechengleibieEntity kechengleibie = kechengleibieService.selectById(id);
        return R.ok().put("data", kechengleibie);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechengleibieEntity kechengleibie = kechengleibieService.selectById(id);
        return R.ok().put("data", kechengleibie);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KechengleibieEntity kechengleibie, HttpServletRequest request){
    	kechengleibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengleibie);
        kechengleibieService.insert(kechengleibie);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KechengleibieEntity kechengleibie, HttpServletRequest request){
    	kechengleibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengleibie);
        kechengleibieService.insert(kechengleibie);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KechengleibieEntity kechengleibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengleibie);
        kechengleibieService.updateById(kechengleibie);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechengleibieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}

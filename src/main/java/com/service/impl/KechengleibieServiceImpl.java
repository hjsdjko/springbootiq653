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


import com.dao.KechengleibieDao;
import com.entity.KechengleibieEntity;
import com.service.KechengleibieService;
import com.entity.vo.KechengleibieVO;
import com.entity.view.KechengleibieView;

@Service("kechengleibieService")
public class KechengleibieServiceImpl extends ServiceImpl<KechengleibieDao, KechengleibieEntity> implements KechengleibieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengleibieEntity> page = this.selectPage(
                new Query<KechengleibieEntity>(params).getPage(),
                new EntityWrapper<KechengleibieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengleibieEntity> wrapper) {
		  Page<KechengleibieView> page =new Query<KechengleibieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KechengleibieVO> selectListVO(Wrapper<KechengleibieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KechengleibieVO selectVO(Wrapper<KechengleibieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KechengleibieView> selectListView(Wrapper<KechengleibieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengleibieView selectView(Wrapper<KechengleibieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

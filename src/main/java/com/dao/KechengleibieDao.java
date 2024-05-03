package com.dao;

import com.entity.KechengleibieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KechengleibieVO;
import com.entity.view.KechengleibieView;


/**
 * 课程类别
 * 
 * @author 
 * @email 
 * @date 2023-04-21 09:18:58
 */
public interface KechengleibieDao extends BaseMapper<KechengleibieEntity> {
	
	List<KechengleibieVO> selectListVO(@Param("ew") Wrapper<KechengleibieEntity> wrapper);
	
	KechengleibieVO selectVO(@Param("ew") Wrapper<KechengleibieEntity> wrapper);
	
	List<KechengleibieView> selectListView(@Param("ew") Wrapper<KechengleibieEntity> wrapper);

	List<KechengleibieView> selectListView(Pagination page,@Param("ew") Wrapper<KechengleibieEntity> wrapper);
	
	KechengleibieView selectView(@Param("ew") Wrapper<KechengleibieEntity> wrapper);
	

}

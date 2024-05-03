package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KechengleibieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KechengleibieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KechengleibieView;


/**
 * 课程类别
 *
 * @author 
 * @email 
 * @date 2023-04-21 09:18:58
 */
public interface KechengleibieService extends IService<KechengleibieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengleibieVO> selectListVO(Wrapper<KechengleibieEntity> wrapper);
   	
   	KechengleibieVO selectVO(@Param("ew") Wrapper<KechengleibieEntity> wrapper);
   	
   	List<KechengleibieView> selectListView(Wrapper<KechengleibieEntity> wrapper);
   	
   	KechengleibieView selectView(@Param("ew") Wrapper<KechengleibieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengleibieEntity> wrapper);
   	

}


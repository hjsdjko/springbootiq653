package com.entity.view;

import com.entity.KechengleibieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 课程类别
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-21 09:18:58
 */
@TableName("kechengleibie")
public class KechengleibieView  extends KechengleibieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KechengleibieView(){
	}
 
 	public KechengleibieView(KechengleibieEntity kechengleibieEntity){
 	try {
			BeanUtils.copyProperties(this, kechengleibieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

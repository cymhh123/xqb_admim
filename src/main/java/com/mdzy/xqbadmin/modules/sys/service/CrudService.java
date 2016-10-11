/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.sys.service;


import com.github.pagehelper.PageHelper;
import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.modules.sys.constants.Constants;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Service基类
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity>{
	
	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id) {
		return dao.get(id);
	}
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}


	/**
	 * 保存数据
	 * @param entity
	 */
	public void save(T entity) {
		entity.preInsert();
		dao.insert(entity);
	}

	public void update(T entity){
		entity.preUpd();
		dao.update(entity);
	}
	
	/**
	 * 删除数据
	 */
	public void delete(String id) {
		dao.delete(id);
	}

	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	public List<T> findByPage(T entity, Integer page){
		if(page != null){
			PageHelper.startPage(page, Constants.PAGE_SIZE);
		}
		List<T> list = dao.findList(entity);
		return list;
	}

	/**
	 * 分页查询(指定每页大小)
	 * @param page
	 * @return
	 */
	public List<T> findByPageAndSize(T entity, Integer page,Integer size){
		if(page != null){
			PageHelper.startPage(page, size);
		}
		List<T> list = dao.findList(entity);
		return list;
	}
}

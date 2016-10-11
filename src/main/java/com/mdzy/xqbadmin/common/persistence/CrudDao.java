package com.mdzy.xqbadmin.common.persistence;


import java.util.List;

/**
 * DAO支持类实现
 * @author chengyou
 * @version 2014-05-16
 * @param <T>
 */
public interface CrudDao<T> extends BaseDao {

	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id);
	
	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
	public int insert(T entity);
	
	/**
	 * 更新数据
	 * @param entity
	 * @return
	 */
	public int update(T entity);
	
	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * @param id
	 * @return
	 */
	public int delete(String id);

	/**
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);

}
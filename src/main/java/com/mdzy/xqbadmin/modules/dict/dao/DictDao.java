package com.mdzy.xqbadmin.modules.dict.dao;

import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.dict.entity.DictBean;

import java.util.List;

/**
 * 数据字典Dao
* Created by chengyou on 2015-8-11.
*/
@MyBatisDao
public interface DictDao{

	/**
	 * 查询字典列表
	 * @param dictBean
	 * @return
	 */
	public List<DictBean> findList(DictBean dictBean);

	/**
	 * 查询字典
	 * @param id
	 * @return
     */
	public DictBean get(String id);

	/**
	 * 按字典类型列表
	 * @return
     */
	List<String> findTypeList();

	/**
	 * 保存字典
	 * @param dictBean
	 * @return
     */
	int insert(DictBean dictBean);

	/**
	 * 更新字典
	 * @param dictBean
	 * @return
     */
	int update(DictBean dictBean);

	/**
	 * 删除字典数据
	 * @param id
	 * @return
     */
	int delete(String id);

}

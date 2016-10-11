package com.mdzy.xqbadmin.modules.dict.service;

import com.mdzy.xqbadmin.common.utils.CacheUtils;
import com.mdzy.xqbadmin.modules.dict.dao.DictDao;
import com.mdzy.xqbadmin.modules.dict.entity.DictBean;
import com.mdzy.xqbadmin.modules.sys.utils.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 字典数据服务
 */
@Service
@Transactional(readOnly = true)
public class DictService {
    /**
     * 持久层对象
     */
    @Autowired
    protected DictDao dictDao;

    /**
     * 查询字段类型列表
     * @return
     */
    public List<String> findTypeList(){
        return dictDao.findTypeList();
    }

    /**
     * 保存字典数据
     * @param dict
     */
    @Transactional(readOnly = false)
    public void save(DictBean dict) {
        this.dictDao.insert(dict);
        //清空字典缓存
        CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
    }

    /**
     * 删除字典数据
     * @param id
     */
    @Transactional(readOnly = false)
    public void delete(String id) {
        this.dictDao.delete(id);
        //清空缓存
        CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
    }

    /**
     * 获得字典数据
     * @param id
     * @return
     */
    public DictBean get(String id){
        return this.dictDao.get(id);
    }

}

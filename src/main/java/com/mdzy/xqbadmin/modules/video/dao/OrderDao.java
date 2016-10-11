package com.mdzy.xqbadmin.modules.video.dao;


import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.video.entity.OrderBean;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/8/2.
 */
@MyBatisDao
public interface OrderDao extends CrudDao<OrderBean> {
    BigDecimal totalPrice(OrderBean orderBean);
}

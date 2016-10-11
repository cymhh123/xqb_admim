package com.mdzy.xqbadmin.modules.banner.service;

import org.springframework.stereotype.Service;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.banner.entity.Banner;
import com.mdzy.xqbadmin.modules.banner.dao.BannerDao;

/**
 * BannerService
 * @author chyou
 * @version
 */
@Service
public class BannerService extends CrudService<BannerDao, Banner> {

}
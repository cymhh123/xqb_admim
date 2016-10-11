package com.mdzy.xqbadmin.modules.api.action;

import com.mdzy.xqbadmin.modules.banner.entity.Banner;
import com.mdzy.xqbadmin.modules.banner.service.BannerService;
import com.mdzy.xqbadmin.modules.res.entity.ResInfoBean;
import com.mdzy.xqbadmin.modules.res.service.ResInfoBeanService;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.constants.Constants;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.video.entity.SubjectBean;
import com.mdzy.xqbadmin.modules.video.service.SubjectService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 移动端首页数据
 * Created by Administrator on 2016/10/10.
 */
@Controller
@RequestMapping("/api/index")
public class IndexActionApi extends BaseController {
    @Autowired
    private BannerService bannerService;
    @Autowired
    private ResInfoBeanService resInfoBeanService;
    @Autowired
    private SubjectService subjectService;

    /**
     * 首页信息
     * @return
     */
    @RequestMapping("/data")
    @ResponseBody
    public Object index_data(){
        //banner列表
        List bannerList = this.bannerService.findList(new Banner());
        //教育指南
        ResInfoBean resInfoBean = new ResInfoBean();
        resInfoBean.setSorts(Constants.Res.SORTS_STUDY);
        List<ResInfoBean> resList = this.resInfoBeanService.findByPageAndSize(resInfoBean,1,2);
        //直播专题
        SubjectBean subjectBean = new SubjectBean();
        subjectBean.setType(Constants.Video.TYPE_ZHIBO);
        List<SubjectBean> subjectList = this.subjectService.findByPageAndSize(subjectBean,1,2);
        Map<String,Object> result = new HashedMap();
        result.put("bannerList",bannerList);
        result.put("resList",resList);
        result.put("subjectList",subjectList);
        return new ExecuteBean<>(result);
    }

}

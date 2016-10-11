/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.res.entity;

import com.mdzy.xqbadmin.common.config.Global;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;
import com.mdzy.xqbadmin.modules.sys.utils.DictUtils;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * res_infoEntity
 * @author chengyou
 * @version 2016-09-05
 */
public class ResInfoBean extends DataEntity {
	
	private static final long serialVersionUID = 1L;
	private String title;		// title
	private String profiles;		// profiles
	private String resUrl;		// res_url
	private String content;		// content
	private Integer resType;		// res_type_id
	private String resTypeL;
	private Integer sorts;
	private String sortsL;
	private String thumbUrl;
	
	public ResInfoBean() {
		super();
	}

	public String getResTypeL() {
		return resTypeL;
	}

	public void setResTypeL(String resTypeL) {
		this.resTypeL = resTypeL;
	}


	public String getSortsL() {
		return sortsL;
	}

	public void setSortsL(String sortsL) {
		this.sortsL = sortsL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getProfiles() {
		return profiles;
	}

	public void setProfiles(String profiles) {
		this.profiles = profiles;
	}
	
	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Integer getResType() {
		return resType;
	}

	public void setResType(Integer resType) {
		this.resType = resType;
		if(resType != null){
			String label = DictUtils.getDictLabel(resType.toString(),"res_type","");
			this.setResTypeL(label);
		}
	}

	public Integer getSorts() {
		return sorts;
	}

	public void setSorts(Integer sorts) {
		this.sorts = sorts;
		if(sorts != null){
			String label = DictUtils.getDictLabel(sorts.toString(),"sorts","");
			this.setSortsL(label);
		}
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	
}
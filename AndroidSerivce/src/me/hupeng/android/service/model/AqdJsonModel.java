
package me.hupeng.android.service.model;

import java.util.ArrayList;
import java.util.List;


/**
 * ���紫���ö���ģ��
 * */
public class AqdJsonModel {
	private String tableName;
	private String id;
	private List<AqdSimpleKVModel>list;
	
	public AqdJsonModel() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<AqdSimpleKVModel>();		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<AqdSimpleKVModel> getList() {
		return list;
	}

	public void setList(List<AqdSimpleKVModel> list) {
		this.list = list;
	}
	
	

}
package me.hupeng.android.service.service;

import java.sql.Timestamp;
import java.util.List;

import me.hupeng.android.service.DAO.AqdDAO;
import me.hupeng.android.service.bean.Aqd;
import me.hupeng.android.service.model.AqdJsonModel;
import me.hupeng.android.service.model.AqdSimpleKVModel;
import me.hupeng.android.service.util.AqdKeyService;

public class AqdService {
	private AqdDAO aqdDAO;
	private Aqd aqd;
	public AqdDAO getAqdDAO() {
		return aqdDAO;
	}
	public void setAqdDAO(AqdDAO aqdDAO) {
		this.aqdDAO = aqdDAO;
	}
	public Aqd getAqd() {
		return aqd;
	}
	public void setAqd(Aqd aqd) {
		this.aqd = aqd;
	}
	
	public String getSid(){
		long nowTime = System.currentTimeMillis();
		String id = nowTime  + "";
		id = AqdKeyService.Md5(id);
		Aqd aqd = new Aqd();
		aqd.setSid(id);
		List list = aqdDAO.findByExample(aqd);		
		if (list.size()!=0l) {
			id = AqdKeyService.Md5(id);
		}
		return id;
	}
	
	public String  addSimpleJsonModel(AqdJsonModel aqdJsonModel){
		String sid = getSid();		
		try {
			for (int i = 0; i < aqdJsonModel.getList().size(); i++) {
				AqdSimpleKVModel aqdSimpleKVModel = aqdJsonModel.getList().get(i);
				Aqd aqd  = new Aqd();
				aqd.setSid(sid);
				aqd.setTable(aqdJsonModel.getTableName());
				aqd.setCreateTime(new Timestamp(System.currentTimeMillis()));
				aqd.setKey(aqdSimpleKVModel.getKey());
				aqd.setValue(aqdSimpleKVModel.getValue());
				aqdDAO.save(aqd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sid;
	}
	
	public void updateSimpleJsonModel(AqdJsonModel aqdJsonModel){
		try {
			for (int i = 0; i < aqdJsonModel.getList().size(); i++) {
				AqdSimpleKVModel aqdSimpleKVModel = aqdJsonModel.getList().get(i);
				/*
				Aqd aqd  = new Aqd();
				aqd.setSid(sid);
				aqd.setTable(aqdJsonModel.getTableName());
				aqd.setCreateTime(new Timestamp(System.currentTimeMillis()));
				aqd.setKey(aqdSimpleKVModel.getKey());
				aqd.setValue(aqdSimpleKVModel.getValue());
				aqdDAO.save(aqd);
				*/
				Aqd aqd =new Aqd();
				aqd.setSid(aqdJsonModel.getId());
				aqd.setKey(aqdSimpleKVModel.getKey());
				List<Aqd> list= aqdDAO.findByExample(aqd);
				if (list.size() == 1) {
					aqd = list.get(0);
				}
				aqd.setValue(aqdSimpleKVModel.getValue());
				aqd.setTable(aqdJsonModel.getTableName());
				aqd.setCreateTime(new Timestamp(System.currentTimeMillis()));
				aqdDAO.save(aqd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
}

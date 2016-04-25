package me.hupeng.android.service.action;

import me.hupeng.android.service.model.AqdJsonModel;
import me.hupeng.android.service.model.AqdSimpleReturnModel;
import me.hupeng.android.service.service.AqdService;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class SaveAction extends  ActionSupport{
	private String json;
	private AqdSimpleReturnModel aqdSimpleReturnModel;
	private AqdService aqdService;
	
	
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}

	public AqdSimpleReturnModel getAqdSimpleReturnModel() {
		return aqdSimpleReturnModel;
	}
	public void setAqdSimpleReturnModel(AqdSimpleReturnModel aqdSimpleReturnModel) {
		this.aqdSimpleReturnModel = aqdSimpleReturnModel;
	}
	
	public AqdService getAqdService() {
		return aqdService;
	}
	public void setAqdService(AqdService aqdService) {
		this.aqdService = aqdService;
	}
	@Override
	public String execute() throws Exception {
		aqdSimpleReturnModel = new AqdSimpleReturnModel();
		System.out.println(json);
		if (json != null) {
			try{
				AqdJsonModel aqdJsonModel = new Gson().fromJson(json, AqdJsonModel.class);
				
				//д�����ݿ�
				if (aqdJsonModel.getId()!=null) {
					aqdSimpleReturnModel.setState(0);
					aqdSimpleReturnModel.setMsg("����saveʱid����Ϊ��");
				}else{
					//System.out.println(json);
					aqdService.addSimpleJsonModel(aqdJsonModel);
					
				}
			}catch(Exception e){
				aqdSimpleReturnModel.setState(0);
				aqdSimpleReturnModel.setMsg("��������");
				e.printStackTrace();
			}
		}else{
			aqdSimpleReturnModel.setState(0);
			aqdSimpleReturnModel.setMsg("��������");
		}
		return SUCCESS;
	}
}

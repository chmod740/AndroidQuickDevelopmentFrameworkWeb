package me.hupeng.android.service.action;

import me.hupeng.android.service.model.AqdJsonModel;
import me.hupeng.android.service.model.AqdSimpleReturnModel;
import me.hupeng.android.service.service.AqdService;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {
	private String json;
	private AqdService aqdService;
	private AqdSimpleReturnModel aqdSimpleReturnModel;

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public AqdService getAqdService() {
		return aqdService;
	}

	public void setAqdService(AqdService aqdService) {
		this.aqdService = aqdService;
	}

	public AqdSimpleReturnModel getAqdSimpleReturnModel() {
		return aqdSimpleReturnModel;
	}

	public void setAqdSimpleReturnModel(
			AqdSimpleReturnModel aqdSimpleReturnModel) {
		this.aqdSimpleReturnModel = aqdSimpleReturnModel;
	}

	@Override
	public String execute() throws Exception {
		aqdSimpleReturnModel = new AqdSimpleReturnModel();
		if (json==null) {
			aqdSimpleReturnModel.setMsg("请求参数错误");
			aqdSimpleReturnModel.setState(0);
		}else{
			try {
				AqdJsonModel aqdJsonModel = new Gson().fromJson(json, AqdJsonModel.class);
				if (aqdJsonModel.getId()==null) {
					aqdSimpleReturnModel.setState(0);
					aqdSimpleReturnModel.setMsg("id不允许为空");
				}else{
					aqdService.updateSimpleJsonModel(aqdJsonModel);
				}
			} catch (Exception e) {
				// TODO: handle exception
				aqdSimpleReturnModel.setMsg("请求参数错误");
				aqdSimpleReturnModel.setState(0);
			}
		}
		return SUCCESS;
	}
}

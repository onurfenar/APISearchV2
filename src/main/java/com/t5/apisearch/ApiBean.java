package com.t5.apisearch;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped

public class ApiBean implements Serializable {
	
	private String keyword;
	private Api selectedApi;
	
	public Api getSelectedApi() {
		return selectedApi;
	}

	public void setSelectedApi(Api selectedApi) {
		this.selectedApi = selectedApi;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public void submit() {
		System.out.println("ApiBean Keyword IS:"+this.getKeyword());
		dataModel = new ApiLazyDataModel(this.getKeyword());	
	}

	ApiLazyDataModel dataModel = new ApiLazyDataModel(this.getKeyword());
	public ApiLazyDataModel getModel(){
    	return dataModel;
    }
	
	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Api Selected", String.valueOf(((Api) event.getObject()).getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
}
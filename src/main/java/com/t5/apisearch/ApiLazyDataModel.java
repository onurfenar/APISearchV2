package com.t5.apisearch;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class ApiLazyDataModel extends LazyDataModel<Api> {
	
	private String keyword;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public ApiLazyDataModel(String key){	
		this.setKeyword(key);
        System.out.println("--------- "+this+" -----------------");
        System.out.println("---EmployeeLazyDataModel-----invoked--");
        this.setRowCount(DataService.getApiTotalCount(this.getKeyword()));
        System.out.println("---Keyword-----invoked--"+this.getKeyword());    
    }
    
    @Override
    public List<Api> load(int first, int pageSize, String sortField,
                               SortOrder sortOrder, Map<String, Object> filters) {
    	 	System.out.println("---load-----invoked--");
    	 	System.out.println("---load------keyword-"+this.getKeyword());
        List<Api> list = DataService.getApiList(first, pageSize,this.getKeyword());
        return list;
    }   
}
package net.dumbee.project.web.pojo;

import java.io.Serializable;

public class RespDataBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7184445842468806054L;
	
	private Integer statusCode;
	private String statusText;
	private Object data;
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}

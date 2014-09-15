package net.dumbee.project.commons.pojo;

import java.io.Serializable;

public class OpResult <T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3894781581772830912L;
	
	private T data;
	
	private Message message;
	
	public OpResult(){
		this(null);
	}
	
	public OpResult(Message message){
		this(message, null);
	}
	
	public OpResult(Message message, T data){
		this.message = message == null ? Message.SUCCESS : message;
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	public boolean isSuccess(){
		return message.isSuccess();
	}
	
}

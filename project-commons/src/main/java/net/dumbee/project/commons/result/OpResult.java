package net.dumbee.project.commons.result;

import java.io.Serializable;

public class OpResult <T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3894781581772830912L;
	
	private static Message defaultSuccess = SuccessMessage.instance;
	
	private T data;
	
	private Message message;
	
	public OpResult(){
		this(null);
	}
	
	public OpResult(Message message){
		this(message, null);
	}
	
	public OpResult(Message message, T data){
		this.message = message == null ? defaultSuccess : message;
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public OpResult<T> setData(T data) {
		this.data = data;
		return this;
	}

	public Message getMessage() {
		return message;
	}

	public OpResult<T> setMessage(Message message) {
		this.message = message;
		return this;
	}
	
	public boolean isSuccess(){
		return message.isSuccess();
	}
	
}

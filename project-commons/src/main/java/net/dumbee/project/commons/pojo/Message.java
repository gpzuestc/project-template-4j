package net.dumbee.project.commons.pojo;

public class Message {
	
	protected static final Integer TYPE_SUCCESS = 200;
	protected static final Message SUCCESS = new Message(TYPE_SUCCESS, "OK");
	
	protected Integer type;
	protected String desc;

	protected Message(Integer type, String desc){
		this.type = type;
		this.desc = desc;
	}	

	public Integer getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
	
	public boolean isSuccess(){
		return TYPE_SUCCESS.equals(type);
	}
	
}

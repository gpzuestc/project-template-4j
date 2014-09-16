package net.dumbee.project.commons.result;

public abstract class Message {
	
	protected Integer type;
	protected String desc;

	protected Message(Integer type, String desc){
		this.type = type;
		this.desc = desc;
	}	
	
	public abstract boolean isSuccess();
	
	public Integer getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
	
}

package net.dumbee.project.commons.result;

public final class SuccessMessage extends Message {
	
	public static final SuccessMessage instance = new SuccessMessage(200, "OK");
	
	private SuccessMessage(Integer type, String desc) {
		super(type, desc);
	}

	@Override
	public boolean isSuccess() {
		return true;
	}

}

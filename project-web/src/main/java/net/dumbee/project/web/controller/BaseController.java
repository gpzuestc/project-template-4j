package net.dumbee.project.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dumbee.project.commons.result.OpResult;
import net.dumbee.project.commons.result.RespDataView;


public abstract class BaseController {
	
	private static final Logger log = LogManager.getLogger(BaseController.class);
	
//	protected RespDataBean success
	
	@SuppressWarnings("rawtypes")
	protected RespDataView response(Object dataObj) {
		RespDataView respDataView = new RespDataView();
		if(dataObj == null){
			return respDataView;
		}
		if(dataObj instanceof OpResult){
			OpResult opResult = (OpResult)dataObj;
			respDataView.setData(opResult.getData());
			if(opResult.getMessage() != null){
				respDataView.setStatusCode(opResult.getMessage().getType());
				respDataView.setStatusText(opResult.getMessage().getDesc());
			}
		}else{
			respDataView.setData(dataObj);
		}
		return respDataView;
	}
}

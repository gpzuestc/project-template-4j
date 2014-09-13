package net.dumbee.project.extend;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperCustomer extends ObjectMapper {
	/**
	 * 
	 */
	private static final long serialVersionUID = 953923747606000939L;

	public ObjectMapperCustomer() {
		super();
		
		//过滤空字段
		this.setSerializationInclusion(Include.NON_EMPTY);
		//允许不带引号的字段
		this.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		//忽略反序列时出现的未定义字段
		this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
//		// 允许单引号
//		this.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//		// 字段和值都加引号
//		this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//		// 数字也加引号
//		this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
//		this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);
//		// 空值处理为空串
//		this.getSerializerProvider().setNullValueSerializer(
//				new JsonSerializer<Object>() {
//
//					@Override
//					public void serialize(Object value, JsonGenerator jg,
//							SerializerProvider sp) throws IOException,
//							JsonProcessingException {
//						jg.writeString("");
//					}
//				});

	}
}

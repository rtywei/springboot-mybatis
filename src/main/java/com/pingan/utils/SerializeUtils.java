package com.pingan.utils;

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pingan.pojo.User;

public class SerializeUtils {
	
	private static JSONObject json = new JSONObject();
	
	private static ObjectMapper objectMapper = new  ObjectMapper();  

	public static Object fstdeserialize(byte[] bytes) {
//		try {
			return  json.parse(bytes);
//			return objectMapper.readValue(bytes, User.class);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
	}

	public static byte[] fstserialize(Object object) {
//		try {
			byte[] jsonBytes = json.toJSONBytes(object);
			return jsonBytes;
//			return objectMapper.writeValueAsBytes(object);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
	}
	
	public static void main(String[] args) {
		User user = new User();
		user.setUserName("aaa");
		user.setPassword("bbb");
		
		user.setUserId(1);
		byte[] bytes = fstserialize(user);
		
		Object fstdeserialize = fstdeserialize(bytes);
		User parseObject = json.parseObject(fstdeserialize.toString(), User.class);
		System.out.println(parseObject);
	}

}

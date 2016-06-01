package com.ywm.json;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class java2json {

	public static void main(String[] args) throws ParseException, IOException {
		System.out.println("hello java2json");

		User user = new User();
		user.setName("ywm");
		user.setAge(20);
		user.setEmail("ywm@dxzq.net");

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		user.setBirthday(dateformat.parse("1996-10-01"));

		/** 
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。 
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。 
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。 
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。 
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。 
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。 
         */  
		ObjectMapper mapper = new ObjectMapper();
		// User类转JSON
		// 输出结果：{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}
//		mapper.writeValue(new File("user.json"),user);
		String json = mapper.writeValueAsString(user);
		System.out.println(json);

		// Java集合转JSON
		List<User> users = new ArrayList<User>();
		users.add(user);
		users.add(user);
		
		// 输出结果：[{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}]
		String jsonlist = mapper.writeValueAsString(users);
		System.out.println(jsonlist);
		
        User user1 = mapper.readValue(json, User.class);  
        System.out.println(user1);  
		
	}

}

/*
 * Copyright (c) 2012-2021 by Zalo Group.
 * All Rights Reserved.
 */
package basictutorial;

/**
 *
 * @author quocbao
 */

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import static jdk.nashorn.internal.objects.NativeArray.map;
import org.apache.thrift.TException;

public class BasicThriftHandler implements BasicThriftService.Iface {
	public BasicThriftHandler(){
		
	}
	
	private Map<String, MyValue> concurrentHashMap = new ConcurrentHashMap<String, MyValue>();
	private long numberCallPut = 0;
	@Override
	public long put(String key, int p2, long p3, String p4, List<Integer> p5, Map<String,String> p6, MyData p7) throws TException {
		numberCallPut++;
		MyValue newValue = new MyValue();
		newValue.p2 = p2;
		newValue.p3 = p3;
		newValue.p4 = p4;
		newValue.p5 = p5;
		newValue.p6 = p6;
		newValue.p7 = p7;
		
		concurrentHashMap.put(key, newValue);

		
		System.out.println("put");
	   
//		return concurrentHashMap.size();
		return numberCallPut;
	}

//    @Override
//	public int put(List<String> p5, int n1, int n2) throws TException {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}

	@Override
	public void put2(String key, int p2, long p3, String p4, List<Integer> p5, Map<String, String> p6, MyData p7) throws TException {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		//numberCallPut++;
		MyValue newValue = new MyValue();
		newValue.p2 = p2;
		newValue.p3 = p3;
		newValue.p4 = p4;
		newValue.p5 = p5;
		newValue.p6 = p6;
		newValue.p7 = p7;
		
		concurrentHashMap.put(key, newValue);

		
		System.out.println("put2");
		return;
	}

	@Override
	public long put3(String key, int p2, long p3, String p4, List<Integer> p5, Map<String, String> p6, MyData p7) throws TException {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		numberCallPut++;
		MyValue newValue = new MyValue();
		newValue.p2 = p2;
		newValue.p3 = p3;
		newValue.p4 = p4;
		newValue.p5 = p5;
		newValue.p6 = p6;
		newValue.p7 = p7;
		
		concurrentHashMap.put(key, newValue);

		
		System.out.println("put3");
		return numberCallPut;
	}

	@Override
	public MyValue get(String key) throws TException {
		System.out.println("get");
		//check key null or key = ""
		if (key == null || key.isEmpty() ) {
			//No key in my Map
			MyValue result = new MyValue();
			result.errCode = 404;
			return result;
		}
		if (concurrentHashMap.get(key) != null) {
			//have a key
			return concurrentHashMap.get(key);
		}
		//unknown error :(
		MyValue result = new MyValue();
		result.errCode = 404;
		return result;
	}

	
}
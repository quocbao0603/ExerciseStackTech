/*
 * Copyright (c) 2012-2021 by Zalo Group.
 * All Rights Reserved.
 */
package basictutorial;

/**
 *
 * @author quocbao
 */
import java.util.*;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;


public class BasicThriftNonBlockingClient {

	public static void main(String[] args) throws TTransportException {
		try (TSocket transport = new TSocket("localhost", 9090, 5 * 1000)){
			TFramedTransport ft = new TFramedTransport(transport);
			TBinaryProtocol protocol = new TBinaryProtocol(ft);
			transport.open();
			BasicThriftService.Client client = new BasicThriftService.Client(protocol);
			perform(client);
		}
		catch (Exception e) {
//			dalLogger.error("isAvailable", e);
//			logger.error(e.getMessage(), e);
			System.out.println("Something wrong :(");
//			return false;
		}
	}

	private static void perform(BasicThriftService.Client client) throws TException {
		
		//Test put method
		String key = "baotq";
		System.out.println("Number call: " + client.put(key, 0, 0, key, null, null, null));
		key = "2";
		System.out.println("Number call: " + client.put(key, 0, 0, key, null, null, null));
		System.out.println("Number call: " + client.put(key, 0, 0, key, null, null, null));
		MyValue get = client.get("baotq");
		System.out.println("get: " + get);
		get = client.get("111");
		System.out.println("get: " + get);
		
		//Test put2 method
		String key2 = "testput2";
		//put2 not return anything, so it don't allow sth like that
		//System.out.println("Number call: " + client.put2(key2, 0, 0, key2, null, null, null));
		client.put2(key2, 0, 0, key2, null, null, null);
		get = client.get(key2);
		System.out.println("get put 2: " + get);
		
		//Test put3 method
		String key3 = "testput3";
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		MyData myData = new MyData(key3, arr);
		//MyData p7 = new MyData;
		//p7 was not present because p7 must be != null
		//long numCall = client.put3(key2, 0, 0, key2, null, null, null);
		long numCall = client.put3(key3, 0, 0, key3, null, null, myData);
		System.out.println("Number call: " + numCall);
		get = client.get(key3);
		System.out.println("get put 3: " + get);
		
	}
}


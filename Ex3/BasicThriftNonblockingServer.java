package basictutorial;

/*
 * Copyright (c) 2012-2021 by Zalo Group.
 * All Rights Reserved.
 */


import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
/**
 *
 * @author quocbao
 */
public class BasicThriftNonblockingServer {

	private void start() {
		try {
			TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(9090);
			BasicThriftService.Processor processor = new BasicThriftService.Processor(new BasicThriftHandler());

			TServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport).
					processor(processor));
			System.out.println("Starting non blocking server on port 9090 ...");
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
 
    public static void main(String[] args) {
        BasicThriftNonblockingServer srv = new BasicThriftNonblockingServer();
        srv.start();
    }
}


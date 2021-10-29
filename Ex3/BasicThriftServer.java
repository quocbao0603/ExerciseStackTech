package basictutorial;

/*
 * Copyright (c) 2012-2021 by Zalo Group.
 * All Rights Reserved.
 */


import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
/**
 *
 * @author quocbao
 */
public class BasicThriftServer {
	public static BasicThriftHandler handler;

  public static BasicThriftService.Processor processor;

  public static void main(String [] args) {
    try {
      handler = new BasicThriftHandler();
      processor = new BasicThriftService.Processor(handler);

      Runnable simple = new Runnable() {
        public void run() {
          simple(processor);
        }
      };      
     
      new Thread(simple).start();
    } catch (Exception x) {
      x.printStackTrace();
    }
  }

  public static void simple(BasicThriftService.Processor processor) {
    try {
      TServerTransport serverTransport = new TServerSocket(9090);
      TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
	  
      System.out.println("Starting the simple server...");
      server.serve();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

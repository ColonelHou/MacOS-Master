package org.macos.java.thrift;

import org.macos.java.thrift.rpc_server.RPCThriftServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RPCThriftServerApplication {
    private static RPCThriftServer rpcThriftServer;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RPCThriftServerApplication.class, args);

        try {

            rpcThriftServer = context.getBean(RPCThriftServer.class);
            rpcThriftServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

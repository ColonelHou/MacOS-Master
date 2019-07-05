package org.macos.java.thrift.rpc_server;

import org.apache.thrift.TException;
import org.macos.java.thrift.interface_.RPCDateService;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class RPCDateServiceImpl implements RPCDateService.Iface {

    @Override
    public String getDate(String userName) throws TException {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("今天是"+"yyyy年MM月dd日 E kk点mm分");
        String nowTime = sdf.format(now);
        return "Hello " + userName + "\n" + nowTime;
    }
}

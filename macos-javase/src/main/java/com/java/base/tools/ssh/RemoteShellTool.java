package com.java.base.tools.ssh;

import ch.ethz.ssh2.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RemoteShellTool {

    public static String exec(String cmds) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(cmds);
        InputStream is = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer tv_result = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            tv_result.append(line + "\n");
        }
        process.waitFor();
        is.close();
        reader.close();
        process.destroy();
        return tv_result.toString();
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        // /Users/houningning/bak/test.sh
        String ssh = "bash /Users/houningning/bak/test.sh";

        String s = RemoteShellTool.exec(ssh);
        System.out.println("返回值: " + s + " 结束");
    }


}

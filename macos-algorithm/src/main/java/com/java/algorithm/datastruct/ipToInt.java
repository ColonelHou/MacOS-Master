package com.java.algorithm.datastruct;

import java.util.Arrays;

/**
 * Created by colonelhou on 2019/5/3.
 */
public class ipToInt {
    public static void main(String[] args) {
        /*String ip = "127.0.0.1";
        String ipAr[] = ip.split("\\.");
        Integer one = Integer.parseInt(ipAr[0]);
        Integer two = Integer.parseInt(ipAr[1]);
        Integer thr = Integer.parseInt(ipAr[2]);
        Integer fou = Integer.parseInt(ipAr[3]);
*/
//        String ipaddress = "127.23.12.1"; // 2132216833
        String ipaddress = "127.0.0.1";     // 2130706433
        long[] ip = new long[4];
        int i = 0;
        for(String ipStr : ipaddress.split("\\.")){
            ip[i] = Long.parseLong(ipStr);
            i++;
        }
        System.out.println(Arrays.toString(ip));
        long x = (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
        System.out.println(x + " ===> " + (x >> 24));
        System.out.println(iplongToIp(x));
        System.out.println(Integer.toBinaryString(0x00FFFFFF));
        // 1111 1111  => 1111 1111  =>  11111111
        System.out.println(1 & 3);
    }
    public static String iplongToIp(long ipaddress) {
        StringBuffer sb = new StringBuffer("");
        sb.append(String.valueOf((ipaddress >> 24)));
        sb.append(".");
        sb.append(String.valueOf((ipaddress & 0x00FFFFFF) >>> 16));
        sb.append(".");
        sb.append(String.valueOf((ipaddress & 0x0000FFFF) >>> 8));
        sb.append(".");
        sb.append(String.valueOf((ipaddress & 0x000000FF)));
        return sb.toString();
    }
}

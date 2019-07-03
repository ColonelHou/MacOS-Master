package org.macos.java.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.macos.java.dao.beans.ArticleBean;

import java.io.*;
import java.util.Iterator;

public class FastJsonTest {
    public static void main(String[] args) throws Exception {
        String path = "";
        String httpPath = "/Users/houningning/Documents/mywksp/MacOS-Master/macos-springboot/src/main/java/org/macos/java/config/http.json";
        String labelPath = "/Users/houningning/Documents/mywksp/MacOS-Master/macos-springboot/src/main/java/org/macos/java/config/result_label.json";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(labelPath))));
        String line = br.readLine();
        StringBuffer buffer = new StringBuffer();
        while (line != null) {
            buffer.append(line);
            line = br.readLine();
        }
        System.out.println(buffer.toString());

        JSONObject obj = JSON.parseObject(buffer.toString());
        JSONArray arr = obj.getJSONArray("car");
        Iterator it = arr.iterator();
        while (it.hasNext()) {
            JSONObject carObj = (JSONObject) it.next();
            System.out.println(carObj.getString("emotion"));
            System.out.println(carObj.getString("serial_id"));
            System.out.println(carObj.getString("brand_id"));
            System.out.println(carObj.getString("master_brand_ratio"));
        }

//        String jsonBody = parseHttpMsg(buffer.toString());
//        String label = sendHttpPost("http://211.159.160.128/tag/test", jsonBody);
//        System.out.println(label);
    }

    public static String sendHttpPost(String url, String body) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
//        httpPost.setHeader("Content-Length", "100000");
        httpPost.setHeader("Connection", "keep-alive");
        StringEntity entityS = new StringEntity(body, "utf-8");
        entityS.setContentEncoding("UTF-8");
        httpPost.setEntity(entityS);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(response.getStatusLine().getStatusCode() + "\n");
        HttpEntity entity = response.getEntity();
//        String responseContent = StringEscapeUtils.unescapeJson(EntityUtils.toString(entity, "UTF-8"));
        String responseContent = StringEscapeUtils.unescapeJava(EntityUtils.toString(entity, "UTF-8"));
        System.out.println(responseContent);

        response.close();
        httpClient.close();
        return responseContent;
    }

    /**
     * 解析根据文章ID返回JSON的数据
     * @param msg
     */
    public static String parseHttpMsg(String msg) {
        ArticleBean article = new ArticleBean();
        JSONObject obj = JSON.parseObject(msg);
        JSONObject dataObj = obj.getJSONObject("data");
        String title = dataObj.getString("title");
        System.out.println("title = > " + title);
        JSONArray contentArr = dataObj.getJSONArray("content");
        Iterator it = contentArr.iterator();
        article.setTitle(title);
        StringBuilder builder = new StringBuilder();
        while (it.hasNext()) {
            JSONObject o = (JSONObject) it.next();
            int type = o.getInteger("type");
            if (type == 1) {
                String content = o.getString("content");
                builder.append(content);
            }
        }
        System.out.println("\n\n====\n" + builder.toString() + "\n\n");
        article.setDocument(builder.toString());
        String articleJSON = JSON.toJSONString(article);
        return articleJSON;
    }

    /**
     * 解析Kafka返回数据
     * @param msg
     */
    public static void parseKakfkaMsg(String msg) {
        JSONObject obj = JSON.parseObject(msg);
        // TableKeyEnum中所有table为NEWS的数据要处理
        String strTbl = obj.getString("table");
        // 只处理INSERT / UPDATE
        String strType = obj.getString("type");
        String strID = obj.getString("id");
    }
}

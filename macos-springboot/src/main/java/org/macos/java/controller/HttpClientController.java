package org.macos.java.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.macos.java.model.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HttpClientController {

    @Autowired
    private CloseableHttpClient httpClient;

    @Autowired
    private RequestConfig config;


    @RequestMapping("/yiceh_article_bigdata")
    public HttpResult doPost() throws Exception {
        String url = "http://211.159.160.128/tag/test";

//        String body = "{\"document\":\"说起来美国车的话其实在中国的汽车市场上面他们的感官一直是比较不错的，自身扎实的底盘设计加上独有的美系风格在很多程度上面是得到了大家的认可，整体上面的美系汽车车厂像是别克、福特、雪佛兰都是有着不错的市场表现这一点上面是不可否认的，别克在整体上面的自身车型与实力上面可以说是相当扎实的，在紧凑级和中级车市场上面别克自身的车型矩阵是建立的比较完美的，而且整体上面自身的设计感官上面也是到位的，虽然说最近的别克是在大力的推广三缸机有点那啥，但是在整体上面的发展是不妨碍的。别克在旗下的车型上面很多都是使用了三缸发动机，虽然是在消费者的接受度上面是不怎么乐观的，但是随着国六标准的一步步实现，三缸发动机的节油性能上面是比较符合大趋势的，别克在这上面还是有着一些的大局观的，而在现在的市面上自家的车型上面的改进是大的，在自家紧凑级家轿上面的老将别克英朗上面都是有着三缸发动机的引进的，现在为了表现出来自身的诚意，别克也是在价格上面有着自身的一个诚意的现在2019款的别克英朗有着3.7万的下探，入门车型到了9.29万。在整体的外观上面别克英朗的设计可以说是集成了别克旗下的所有现在的家族式的设计语言的使用，前脸上面盾形的进气格栅内部采用的是飞翼式的家族设计造型，内部竖置的中网采用熏黑的处理方式在运动化的样式上面是很到位的，这一点是不可否认的，大灯的造型上面是很有年轻化设计的体现，内部的灯组设计也是比较不错的，而且环形的LED日行灯的设计在质感上面的是到位的，下方贯穿式的进气格栅造型在层次感上面的体现是到位的，整体上面年轻化的体现是比较到位的。侧面的设计上面整体的线条感是很不错的，运动化的设计感官是到位的，贯穿式的肩线设计在层次感上面的呈现是到位的下方的腰线设计在光影效果的打造上面是到位的，多幅式的轮毂造型也是很沉稳的，尾部的设计上面是很饱满的，扁平化设计的尾灯设计在整体上面的氛围打造是不错的，隐藏式的排气造型在整体上面的精致感是到位的，整车外部的设计感官上面是非常不错的，运动感的体现上面是很受年轻消费者的喜欢的。内饰上面的氛围打造也是成功的，但是在整体上面的氛围还是偏向于居家的样式多一点的，中控台全部采用的是软性的搪塑材质的包裹，下方与座椅同色的真皮包裹在质感上面的呈现是到位的，内嵌式的触控屏科技感呈现也是不错的，三幅式造型的方向盘造型比较的精致，真皮的座椅包裹在整体的质感上面都是蛮不错的。尺寸上面别克英朗为4609x1798x1486mm，轴距2640mm，空间的使用是可以的，动力上面采用的是1.0T和1.3T发动机，最大功率125马力和163马力，最大扭矩170Nm和230Nm，采用6挡双离合变速箱和6挡手自一体变速箱，综合油耗5.1L，家庭使用是比较不错的。\",\"title\":\"别克厚道了！它比朗逸大气 1.3T榨出163马力还降3.7万\"}";
        String body = "{\"document\":\"虽然奥迪品牌在中国销量近期表现堪忧，但其在中高端市场的影响力不可忽视，希望奥迪重整旗鼓砥砺前行。今天来看看奥迪全新A4，预计明年会进入市场。全新奥迪A4属于中期改款车型，相较老款车型在外观方面变化较大，整车看起来更加运动化、智能化。新款A4的前脸采用了更加运动的设计，现款车型上的镀铬中网被替换成了黑色，雾灯区域的造型也有所改变，依旧采用自动高光束矩阵式LED大灯，造型相比老款车型变化较大，日行灯经过重新设计。车身腰线有所改动，改掉了现款A4车型上腰线没有穿过门把手的设计，车尾并没有配备贯穿式尾灯，不过尾灯的造型经过重新设计，与前大灯相呼应，底部的双边共双出排气也变得更加粗壮。内饰部分总体保留老款设计理念，采用虚拟座舱设计语言，不过中控屏大小由原来的8.3英寸升级为了10.1英寸，同时它的车机系统也换成了与全新A6相同的版本。尾部上设计的也很动感，翘起的鸭尾翼配扰流板，与前脸大灯一致造型设计，下部设置了扁平的双排单出大尺寸排气管道，足够霸气了。动力方面，预计还会搭载2.0T高低版两种发动机，与之匹配的是7速双离合变速箱。在目前国内竞争激烈的市场中，每个品牌都面临着不进则退的局面，希望奥迪改款后能够给消费者带来惊喜。文章由易车号作者提供\",\"title\":\"全新奥迪A4曝光颜值高，能否力挽狂澜\"}";
        HttpResult result = this.doPost(url, body);
        System.out.println(result.getBody());
        return result;
    }

    @RequestMapping("/yiche_article")
    public String doGet(String articalId) throws Exception {
        System.out.println("++++++++++++++++文章ID " + articalId);
        HttpGet httpGet = new HttpGet("http://newsapi.yiche.com/appnews/news/show?id=" + articalId);

        // 装载配置信息
        httpGet.setConfig(config);

        // 发起请求
        CloseableHttpResponse response = this.httpClient.execute(httpGet);

        // 判断状态码是否为200
        if (response.getStatusLine().getStatusCode() == 200) {
            // 返回响应体的内容
            String back = EntityUtils.toString(response.getEntity(), "UTF-8");
            return back;
        }
        return null;
    }

    /**
     * 带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     *
     * @param url
     * @return
     * @throws Exception
     */
    public String doGet(String url, Map<String, Object> map) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(url);

        if (map != null) {
            // 遍历map,拼接请求参数
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        // 调用不带参数的get请求
        return this.doGet(uriBuilder.build().toString());

    }

    /**
     * 带参数的post请求
     *
     * @param url
     * @param
     * @return
     * @throws Exception
     */
    public HttpResult doPost(String url, String body) throws Exception {
        System.out.println("url = \n" + url);
        System.out.println("body = \n " + body);
        // 声明httpPost请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
//        httpPost.setConfig(config);
        StringEntity entity = new StringEntity(body, "utf-8");
        entity.setContentEncoding("UTF-8");
        httpPost.setEntity(entity);
        // 发起请求
        CloseableHttpResponse response = this.httpClient.execute(httpPost);
        return new HttpResult(response.getStatusLine().getStatusCode(), StringEscapeUtils.unescapeJson(EntityUtils.toString(response.getEntity())));
    }




}

package com.sqmusicplus;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSONObject;
import com.ejlchina.data.Mapper;
import com.ejlchina.okhttps.*;

import com.ejlchina.okhttps.Process;
import com.sqmusicplus.plug.qq.config.QQConfig;
import com.sqmusicplus.plug.qq.entity.QQSearchEntity;
import com.sqmusicplus.plug.qq.enums.QQSearchType;
import com.sqmusicplus.plug.utils.NeteaseEncryptionUtils;
import com.sqmusicplus.utils.DateUtils;
import com.sqmusicplus.utils.DownloadUtils;
import com.sqmusicplus.utils.OkHttpUtils;
import com.sqmusicplus.utils.ZLibUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xm.Similarity;
import top.yumbo.util.music.MusicEnum;
import top.yumbo.util.music.musicImpl.netease.NeteaseCloudMusicInfo;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static cn.hutool.crypto.digest.DigestUtil.md5;

//@SpringBootTest
class SimpleSqMusucPlusApplicationTests {
//    @Autowired
//    private QQConfig qqConfig;

//    @Test
//    void contextLoads()  {
//
//        String artistInfoUrl = qqConfig.getArtistInfoUrl();
//        String artistInfoReferer = qqConfig.getArtistInfoReferer();
//        String s = artistInfoUrl.replaceAll("#\\{mid}", "0025NhlN2yWrP4");
//        Mapper mapper1 = DownloadUtils.getHttp().sync(s).bodyType(OkHttps.XML).addHeader("Referer", artistInfoReferer).get().getBody().toMapper();
//        System.out.println(mapper1);
//
//    }
//    @Test
//    public void downloadUrl(){
//        String downloadurl = "http://nmobi.kuwo.cn/mobi.s?f=kuwo&q=";
//        String s = "user=e3cc098fd4c59ce2&android_id=e3cc098fd4c59ce2&prod=kwplayer_ar_9.3.1.3&corp=kuwo&newver=2&vipver=9.3.1.3&source=kwplayer_ar_9.3.1.3_qq.apk&p2p=1&notrace=0&type=convert_url2&br=#{brvalue}&format=flac|mp3|aac&sig=0&rid=#{musicId}&priority=bitrate&loginUid=435947810&network=WIFI&loginSid=1694167478&mode=download&uid=658048466";
//        try {
//            s = s.replaceAll("#\\{musicId}","184274130").replaceAll("#\\{brvalue}","2000");
//            byte[] bytes = KuwoDES.encrypt2(s.getBytes("UTF-8"), s.length(), KuwoDES.SECRET_KEY, KuwoDES.SECRET_KEY_LENG);
//            char[] encode = Base64Coder.encode(bytes);
//            String out =  new String(encode);
//            downloadurl =  downloadurl+out;
//        } catch (UnsupportedEncodingException e) {
////            log.error("获取下载链接失败：{}",e.getMessage());
//            return ;
//        }
//        String s1 = DownloadUtils.getHttp().sync(downloadurl).get().getBody().toByteString().utf8();
//        System.out.println(s1);
////        downloadurl= s1.split("\n")[2].split("=")[1].split("\r")[0];
//    }



    @Test
    public void contextLoads() throws IOException, ScriptException, NoSuchMethodException {

        String url = "https://m.lanzouj.com/i6h9c1lbimdc";
        String downloadUrl = getDownloadUrl(url);


        File file = new File("D:\\temp\\sq\\download\\ccc.flac");
//        boolean download = DownloadUtils.download(url, file);
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

//        java.util.function.Consumer<Process> onProcess,Consumer<File> onSuccess,Consumer< Download.Failure> onFailure,Consumer<Download.Status> onComplete

        DownloadUtils.download(downloadUrl, file, stringStringHashMap,onProcess->{
            long doneBytes = onProcess.getDoneBytes();   // 已下载字节数
            long totalBytes = onProcess.getTotalBytes(); // 总共的字节数
            double rate = onProcess.getRate();           // 已下载的比例
            boolean isDone = onProcess.isDone();         // 是否下载完成
            System.out.println("下载中");
            System.out.println("已下载字节数："+doneBytes);
            System.out.println("总共的字节数"+totalBytes);
            System.out.println("已下载的比例"+rate);
            System.out.println("是否下载完成"+isDone);

        },onSuccess->{
            System.out.println("下载成功");

        },onFailure -> {
            System.out.println("下载失败:");
            onFailure.getException().printStackTrace();

        },onComplete->{
            System.out.println("下载失败XXX:");
            System.out.println(onComplete);
        });

//        System.out.println(download);
//        String word1 = "不枉此生(电视剧《雪山飞狐》主题曲)";
//        String word2 = "不枉此生";
//        double cilinSimilarityResult = Similarity.cilinSimilarity(word1, word2);
//        double pinyinSimilarityResult = Similarity.pinyinSimilarity(word1, word2);
//        double conceptSimilarityResult = Similarity.conceptSimilarity(word1, word2);
//        double charBasedSimilarityResult = Similarity.charBasedSimilarity(word1, word2);
//
//        System.out.println(word1 + " vs " + word2 + " 词林相似度值：" + cilinSimilarityResult);
//        System.out.println(word1 + " vs " + word2 + " 拼音相似度值：" + pinyinSimilarityResult);
//        System.out.println(word1 + " vs " + word2 + " 概念相似度值：" + conceptSimilarityResult);
//        System.out.println(word1 + " vs " + word2 + " 字面相似度值：" + charBasedSimilarityResult);


//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("JavaScript");
//
//        Invocable inv = (Invocable) engine;
//
//        String javascriptPath = "C:\\Users\\Administrator\\Desktop\\MyFree.js";
//        engine.eval(new FileReader(javascriptPath));
//        System.out.println(inv.invokeFunction("search", "周杰伦"));



//
//        String downloadUrl = "https://lxmusic.ikunshare.com:9763/url/tx/003KtYhg4frNXC/flac";
//        HTTP http = DownloadUtils.getHttp();
//
//        HttpResult post = http.sync(downloadUrl).addHeader("X-Request-Key","ikunsource")
//                .addHeader("Accept","*/*")
//                .addHeader("Accept-Encoding","gzip, deflate, br")
//                .get();
//        System.out.println(post.getBody().toByteString().utf8());


//        MusicEnum.setBASE_URL_163Music("http://cloud-music.pl-fe.cn");
//        NeteaseCloudMusicInfo neteaseCloudMusicInfo = new NeteaseCloudMusicInfo();
//       neteaseCloudMusicInfo.setCookieString("MUSIC_A_T=1699405917736; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/weapi/clientlog;;MUSIC_A_T=1699405917736; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/neapi/feedback;;MUSIC_A_T=1699405917736; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/weapi/feedback;;MUSIC_A_T=1699405917736; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/eapi/feedback;;MUSIC_SNS=; Max-Age=0; Expires=Wed, 21 Feb 2024 09:08:14 GMT; Path=/;MUSIC_R_T=0; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/weapi/clientlog;;MUSIC_R_T=0; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/wapi/clientlog;;NMTID=00OdwRJrfs-IpN9mkV2q8y5pzJqou8AAAGNyuw2TA; Max-Age=315360000; Expires=Sat, 18 Feb 2034 09:08:14 GMT; Path=/;;MUSIC_R_T=0; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/eapi/feedback;;MUSIC_A_T=1699405917736; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/api/clientlog;;MUSIC_A_T=1699405917736; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/wapi/clientlog;;MUSIC_A_T=1699405917736; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/openapi/clientlog;;MUSIC_A_T=1699405917736; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/api/feedback;;MUSIC_R_T=0; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/wapi/feedback;;MUSIC_A=bf8bfeabb1aa84f9c8c3906c04a04fb864322804c83f5d607e91a04eae463c9436bd1a17ec353cf715bc45df4b3a42a3273c7f3b958a6c67993166e004087dd38107ed2866cbf0ed9de062968295a442f4bf066e6fe094b68be4803e9b31b77d807e650dd04abd3fb8130b7ae43fcc5b; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/;;MUSIC_R_T=0; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/eapi/clientlog;;MUSIC_R_T=0; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/weapi/feedback;;__csrf=0e5ba47686a0f3816c74eb6ed2af3c06; Max-Age=1296010; Expires=Thu, 07 Mar 2024 09:08:24 GMT; Path=/;;MUSIC_R_T=0; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/neapi/feedback;;MUSIC_R_T=0; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/neapi/clientlog;;MUSIC_R_T=0; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/api/clientlog;;MUSIC_R_T=0; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/openapi/clientlog;;MUSIC_A_T=1699405917736; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/neapi/clientlog;;MUSIC_A_T=1699405917736; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/wapi/feedback;;MUSIC_A_T=1699405917736; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/eapi/clientlog;;MUSIC_R_T=0; Max-Age=2147483647; Expires=Mon, 10 Mar 2092 12:22:21 GMT; Path=/api/feedback;");
//
//
//        final JSONObject parameter = new JSONObject();// 请求参数
//        parameter.put("keywords", "陶喆");
//        parameter.put("limit", "10");
//        parameter.put("type", "10");
//        JSONObject search = neteaseCloudMusicInfo.cloudsearch(parameter);
//        System.out.println(search);

//        parameter.put("ids","109125");
//        JSONObject jsonObject = neteaseCloudMusicInfo.songDetail(parameter);

//        parameter.put("id","109125");
//        JSONObject jsonObject = neteaseCloudMusicInfo.lyric(parameter);

//        parameter.put("id", "3689");
//        JSONObject jsonObject = neteaseCloudMusicInfo.artistDetail(parameter);


//        parameter.put("id", "10820");
//        JSONObject jsonObject = neteaseCloudMusicInfo.album(parameter);


//        parameter.put("id", 3689);
//        parameter.put("limit", 50);
//        parameter.put("offset", 0);
//        JSONObject jsonObject = neteaseCloudMusicInfo.artistAlbum(parameter);

//        parameter.put("id", 3689);
//
//        JSONObject jsonObject = neteaseCloudMusicInfo.artists(parameter);
//
//                System.out.println(jsonObject);

    }
//    @Test
//    public void contextLoads() throws IOException {
//        String t1_MusicID = "0039wALP1ImfSQ";
//        String platform = "qq";
//        String t2 = "SQ";
//        String device = "MI 14 Pro Max";
//        String osVersion = "13" ;
//         String time = DateUtils.getNowDate().getTime()/1000+"";
//        String  lowerCase = DigestUtil.md5Hex("6d849adb2f3e00d413fe48efbb18d9bb" + time + "6562653262383463363633646364306534333668");
//        String   s6 = "{\\\"method\\\":\\\"GetMusicUrl\\\",\\\"platform\\\":\\\"" + platform + "\\\",\\\"t1\\\":\\\"" + t1_MusicID + "\\\",\\\"t2\\\":\\\"" + t2 + "\\\"}";
//        String s7 = "{\\\"uid\\\":\\\"\\\",\\\"token\\\":\\\"\\\",\\\"deviceid\\\":\\\"84ac82836212e869dbeea73f09ebe52b\\\",\\\"appVersion\\\":\\\"4.1.2\\\",\\\"vercode\\\":\\\"4120\\\",\\\"device\\\":\\\"" + device + "\\\",\\\"osVersion\\\":\\\"" + osVersion + "\\\"}";
//        String  s8 = "{\n\t\"text_1\":\t\"" + s6 + "\",\n\t\"text_2\":\t\"" + s7 + "\",\n\t\"sign_1\":\t\"" + lowerCase + "\",\n\t\"time\":\t\"" + time + "\",\n\t\"sign_2\":\t\"" + DigestUtil.md5Hex(
//                s6.replace("\\", "") + s7.replace("\\", "") + lowerCase + time + "NDRjZGIzNzliNzEe") + "\"\n}" ;
//        byte[] utf8Bytes = s8.getBytes(StandardCharsets.UTF_8);
//        String hexString = ByteArrayUtil.toHexString(utf8Bytes);
//        String upperHexString = hexString.toUpperCase();
//        byte[] encodedBytes = upperHexString.getBytes(StandardCharsets.UTF_8);
//        byte[] compress = ZLibUtils.compress(encodedBytes);
//        HTTP http = DownloadUtils.getHttp();
//        SHttpTask sync = http.sync("http://gcsp.kzti.top:1030/client/cgi-bin/api.fcg");
//        sync.setBodyPara(compress);
//        HttpResult post = sync.post();
//        byte[] decompress = ZLibUtils.decompress(post.getBody().toBytes());
//        String s = new String(decompress);
//        System.out.println(s);
//    }

    @Test
    public void downloadLyric(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.liumingye.cn/m/api/lyric/id/m4eedd78464c21ce789dea6928415b323-fa4273678781b988a016b813970ee9d7-f89edca7c1ee56f620ab70817d12f739/name/Thinking About You - Jay Sean,Hardwell")
                .get()
                .addHeader("accept", "*/*")
                .addHeader("accept-language", "zh-CN,zh;q=0.9")
                .addHeader("origin", "https://tool.liumingye.cn")
                .addHeader("priority", "u=1, i")
                .addHeader("sec-ch-ua", "\"Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Windows\"")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-site", "same-site")
                .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());

        } catch (IOException e) {

        }

    }

    String getDownloadUrl(String musicurl){
        //判断是否是蓝奏地址还是其他地址
        if (musicurl.contains("lanzou")){
            //转直连再下载

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://lz.qaiu.top/json/parser?url="+musicurl)
                    .get()
                    .build();

            try {
                Response response = client.newCall(request).execute();
                String string = response.body().string();
                JSONObject jsonObject = JSONObject.parseObject(string);
                Integer code = jsonObject.getInteger("code");
                if (code==200){
                    String url = jsonObject.getString("data");
                    return url;
                }else{
                    return null;
                }
            } catch (IOException e) {
                return null;
            }


        }else{
            //musicId
            return musicurl;
        }

    }


}

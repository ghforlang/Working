package json;

import com.google.gson.Gson;
import json.model.LatestNews;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-19 19:38
 *  
 */
public class GsonTest {
    public static final String urlString = "http://news-at.zhihu.com/api/4/news/latest";

    public static void main(String[] args){
        LatestNews latestNews = new LatestNews();
        String jsonStr = new String(HttpUtil.get(urlString));
        System.out.println(jsonStr);

        long startTime = System.currentTimeMillis();
        Gson gson = new Gson();
        latestNews = gson.fromJson(jsonStr,LatestNews.class);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);

        System.out.println(latestNews.getDate());

        System.out.println("topStories:");
        for (int i = 0; i < latestNews.getTop_stories().size(); i++) {
            System.out.println(latestNews.getTop_stories().get(i));
        }

        System.out.println("stories:");
        for (int i = 0; i < latestNews.getStories().size(); i++) {
            System.out.println(latestNews.getStories().get(i));
        }
    }
}

package json;

import json.model.LatestNews;
import json.parser.JArray;
import json.parser.JObject;

import java.util.ArrayList;
import java.util.List;

import static json.parser.Parser.parseJSONObject;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-19 19:55
 *  
 */
public class JParsingTest {
    public static final String urlString = "http://news-at.zhihu.com/api/4/news/latest";

    public static void main(String[] args){
//        String jsonStr = new String(HttpUtil.get(urlString));
        String jsonStr = "{\"id\" : \"11\"}";

        try {
            long startTime = System.currentTimeMillis();
            JObject jObject = parseJSONObject(jsonStr);
            String date = jObject.getString("date");
            JArray top_storiesJSON = jObject.getJArray("top_stories");
            LatestNews latest = new LatestNews();
            List<LatestNews.TopStory> stories = new ArrayList<LatestNews.TopStory>();
            for (int i = 0; i < top_storiesJSON.length(); i++) {
                LatestNews.TopStory story = new LatestNews.TopStory();
                story.setId(((JObject) top_storiesJSON.get(i)).getInt("id"));
                story.setType(((JObject) top_storiesJSON.get(i)).getInt("type"));
                story.setImage(((JObject) top_storiesJSON.get(i)).getString("image"));
                story.setTitle(((JObject) top_storiesJSON.get(i)).getString("title"));
                stories.add(story);
            }

            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);

            latest.setDate(date);
            System.out.println("date: " + latest.getDate());
            for (int i = 0; i < stories.size(); i++) {
                System.out.println(stories.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

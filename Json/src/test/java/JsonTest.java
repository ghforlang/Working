import com.google.gson.Gson;
import model.LatestNews;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import parser.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/11/3 16:55
 */
public class JsonTest {

    private static final String URL_STR = "http://news-at.zhihu.com/api/4/news/latest";
    private static final byte[] byteArr = HttpUtil.get(URL_STR);
    @Test
    public void testGson(){
        String jsonString = new String(byteArr);
        long startTime = System.currentTimeMillis();
        LatestNews latest = (new Gson()).fromJson(jsonString, LatestNews.class);
        long endTime = System.currentTimeMillis();
        System.out.println("took " + (endTime - startTime) + "ms");
        System.out.println(latest.getDate());
        for (int i = 0; i < latest.getTop_stories().size(); i++) {
            System.out.println(latest.getTop_stories().get(i));
        }
        for (int i = 0; i < latest.getStories().size(); i++) {
            System.out.println(latest.getStories().get(i));
        }
    }

    @Test
    public void testJson(){
        try {
            String jsonString = new String(byteArr);
            long startTime = System.currentTimeMillis();
            List<LatestNews.TopStory> stories = getTopStories(jsonString);
            long endTime = System.currentTimeMillis();
            System.out.println("took " + (endTime - startTime) + "ms");

//                String date = latestNewsJSON.getString("date");
//            latest.setDate(date);
//            System.out.println("date: " + latest.getDate());
            for (int i = 0; i < stories.size(); i++) {
                System.out.println(stories.get(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSimpleJson(){
        String jsonString = new String(byteArr);
        try {
            long startTime = System.currentTimeMillis();
            LatestNews latest = Parser.fromJson(jsonString, LatestNews.class);
            long endTime = System.currentTimeMillis();
            System.out.println("took " + (endTime - startTime) + "ms");

            System.out.println(latest.getDate());
            for (int i = 0; i < latest.getTop_stories().size(); i++) {
                System.out.println(latest.getTop_stories().get(i));
            }
            for (int i = 0; i < latest.getStories().size(); i++) {
                System.out.println(latest.getStories().get(i));
            }
        } catch (Exception e) {
        }

    }

    @Test
    public void testTimeCompare() throws  Exception{
        String jsonString = new String(byteArr);

        //Json
        long startTime = System.currentTimeMillis();
        LatestNews latest = new LatestNews();
        List<LatestNews.TopStory> stories = getTopStories(jsonString);
        long endTime = System.currentTimeMillis();
        System.out.println("took " + (endTime - startTime) + "ms");
        linePrint();

        //SimpleJson
        startTime = System.currentTimeMillis();
        latest = Parser.fromJson(jsonString, LatestNews.class);
        endTime = System.currentTimeMillis();
        System.out.println("took " + (endTime - startTime) + "ms");
        linePrint();

        //Gson
        startTime = System.currentTimeMillis();
        latest = (new Gson()).fromJson(jsonString, LatestNews.class);
        endTime = System.currentTimeMillis();
        System.out.println("took " + (endTime - startTime) + "ms");
        linePrint();
    }

    private void linePrint(){
        System.out.println("**********************************************************");
    }
    private List<LatestNews.TopStory>  getTopStories(String jsonStr){
        JSONObject latestNewsJSON = new JSONObject(jsonStr);
//        String date = latestNewsJSON.getString("date");
        JSONArray top_storiesJSON = latestNewsJSON.getJSONArray("top_stories");
        List<LatestNews.TopStory> stories = new ArrayList<>();
        for (int i = 0; i < top_storiesJSON.length(); i++) {
            LatestNews.TopStory story = new LatestNews.TopStory();
            story.setId(((JSONObject) top_storiesJSON.get(i)).getInt("id"));
            story.setType(((JSONObject) top_storiesJSON.get(i)).getInt("type"));
            story.setImage(((JSONObject) top_storiesJSON.get(i)).getString("image"));
            story.setTitle(((JSONObject) top_storiesJSON.get(i)).getString("title"));
            stories.add(story);
        }
        return stories;
    }

}

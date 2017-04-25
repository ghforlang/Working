package json.parser;

import json.exception.JsonParseException;
import json.tokenizer.Token;
import json.tokenizer.TokenType;
import json.tokenizer.Tokenizer;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Parser
 *
 * @author fanwh
 * @create 2017-04-01 11:15
 **/
public class Parser {
    private Tokenizer tokenizer;

    public Parser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    private JObject object(){
        tokenizer.next();
        Map<String,Value> map = new HashMap<String,Value>();
        if(isToken(TokenType.END_OBJ)){
            tokenizer.next();
            return new JObject(map);
        }else if(isToken(TokenType.STRING)){
            map = key(map);
        }
        return new JObject(map);
    }

    private Map<String,Value> key(Map<String,Value> map){
        String key = tokenizer.next().getValue();
//        -----暂时到这里------
        return map;
    }

    public static JObject parseJSONObject(String s) throws Exception {
        Tokenizer tokenizer = new Tokenizer(new BufferedReader(new StringReader(s)));
        tokenizer.tokenize();
        Parser parser = new Parser(tokenizer);
        return parser.object();
    }

    private boolean isToken(TokenType tokenType){
        Token t = tokenizer.peek(0);
        return t.getType() == tokenType;
    }

    private boolean isToken(String  name){
        Token t = tokenizer.peek(0);
        return t.getValue().equals(name);
    }

    public Json parse() throws JsonParseException {
        Json result = json();
        return result;
    }



    private Json json() throws JsonParseException {
        TokenType type = tokenizer.peek(0).getType();
        if(type == TokenType.START_ARRAY){
            return array();
        }else if(type == TokenType.START_OBJ){
            return object();
        }else{
            throw new JsonParseException("Invalid Json Input");
        }
    }

    private JArray array() throws JsonParseException {
        tokenizer.next();
        List<Json> list = new ArrayList<Json>();
        JArray array = null;
        if(isToken(TokenType.START_ARRAY)){
            array = array();
            list.add(array);
            if(isToken(TokenType.COMMA)){
                tokenizer.next();
                list = element(list);
            }
        }else if(isPrimary()){
            list = element(list);
        }else if(isToken(TokenType.START_OBJ)){
            list.add(object());
            while(isToken(TokenType.COMMA)){
                tokenizer.next();
                list.add(object());
            }
        }else if(isToken(TokenType.END_ARRAY)){
            tokenizer.next();
            array = new JArray(list);
            return array;
        }
        tokenizer.next();
        array = new JArray(list);
        return array;
    }

    private List<Json> element(List<Json> list) throws JsonParseException {
        list.add(new Primary(tokenizer.next().getValue()));
        if(isToken(TokenType.COMMA)){
            tokenizer.next();
            if(isPrimary()){
                list = element(list);
            }else if(isToken(TokenType.START_OBJ)){
                list.add(object());
            }else if(isToken(TokenType.START_ARRAY)){
                list.add(array());
            }else{
                throw new JsonParseException("Invalid Json input");
            }
        }else if(isToken(TokenType.END_ARRAY)){
            return list;
        }else{
            throw new JsonParseException("Invalid Json input");
        }
        return list;
    }

    private boolean isPrimary(){
        TokenType type = tokenizer.peek(0).getType();
        return type == TokenType.BOOLEAN || type == TokenType.NULL || type == TokenType.NUMBER || type == TokenType.STRING;
    }

}

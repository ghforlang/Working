package json.tokenizer;

/**
 * Token 新建类
 *
 * @author fanwh
 * @create 2017-04-01 9:37
 **/
public class Token {
    private TokenType type;
    private String value;

    public Token(TokenType type,String value){
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

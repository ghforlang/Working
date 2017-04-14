package json.tokenizer;

import json.exception.JsonParseException;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


/**
 * Json解析器
 *
 * @author fanwh
 * @create 2017-04-01 9:51
 **/
public class Tokenizer {

    private ArrayList<Token> tokens = new ArrayList<Token>();
    private Reader reader;
    private boolean isUnread = false;
    private int savedChar;
    private int c;

    public Tokenizer(Reader reader) {
        this.reader = reader;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void tokenize() throws IOException {
        Token token;
        do{
            token = start();
            tokens.add(token);
        }while(token.getType() != TokenType.END_DOC);
    }

    private Token start() throws IOException {
        c = '?';
        Token token = null;
        do{
            c = read();
        }while(isSpace(c));
        if (isNull(c)) {
            return new Token(TokenType.NULL,null);
        }else if(c == ','){
            return new Token(TokenType.COMMA,",");
        } else if (c == ':') {
            return new Token(TokenType.COLON,":");
        }else if(c == '{'){
            return new Token(TokenType.START_OBJ,"{");
        }else if(c =='['){
            return new Token(TokenType.START_ARRAY,"[");
        }else if(c == ']'){
            return new Token(TokenType.END_ARRAY,"]");
        }else if(c == '}'){
            return new Token(TokenType.END_OBJ,"}");
        }else if(isTrue(c)){
            return new Token(TokenType.BOOLEAN,"true");
        }else if(isFalse(c)){
            return new Token(TokenType.BOOLEAN,"false");
        }else if(c == '"'){
            return readString();
        }else if(isNum(c)){
            unread();
            return readNum();
        }else if(c == -1){
            return new Token(TokenType.END_DOC,"EOF");
        }else {
            throw new JsonParseException("Invalid JSON INPUT");
        }
    }

    private int read() throws IOException {
        if(!isUnread){
            int c = reader.read();
            savedChar = c;
            return c;
        }else{
            isUnread = false;
            return savedChar;
        }
    }

    private void unread(){
        isUnread = true;
    }

    private boolean isSpace(int c){
       return c>=0 && c<=' ';
    }

    private boolean isNull(int c) throws IOException {
        if (c == 'n') {
            c = read();
            if(c == 'u'){
                c = read();
                if(c == 'l'){
                    c = read();
                    if (c == 'l') {
                        return true;
                    }else{
                        throw new JsonParseException("Invalid JSON INPUT");
                    }
                }else{
                    throw new JsonParseException("Invalid JSON INPUT");
                }
            }else{
                throw new JsonParseException("Invalid JSON INPUT");
            }
        }else{
            return false;
        }
    }

    private boolean isTrue(int c) throws IOException {
        if (c == 't') {
            c = read();
            if(c == 'r'){
                c = read();
                if(c == 'u'){
                    c = read();
                    if (c == 'e') {
                        return true;
                    }else{
                        throw new JsonParseException("Invalid JSON INPUT");
                    }
                }else{
                    throw new JsonParseException("Invalid JSON INPUT");
                }
            }else{
                throw new JsonParseException("Invalid JSON INPUT");
            }
        }else{
            return false;
        }
    }

    private boolean isFalse(int c) throws IOException {
        if (c == 'f') {
            c = read();
            if(c == 'a'){
                c = read();
                if(c == 'l'){
                    c = read();
                    if (c == 's') {
                        c = read();
                        if(c == 'e'){
                            return true;
                        }else{
                            throw new JsonParseException("Invalid JSON INPUT");
                        }
                    }else{
                        throw new JsonParseException("Invalid JSON INPUT");
                    }
                }else{
                    throw new JsonParseException("Invalid JSON INPUT");
                }
            }else{
                throw new JsonParseException("Invalid JSON INPUT");
            }
        }else{
            return false;
        }
    }

    private Token readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        while(true){
            c = read();
            if(isEscape()){
                if(c == 'u'){
                    sb.append('\\' + (char)c);
                    for(int i=0;i<4;i++){
                        c = read();
                        if(isHex(c)){
                            sb.append((char)c);
                        }else{
                            throw new JsonParseException("Invalid JSON INPUT");
                        }
                    }
                }else{
                    sb.append("\\" + (char)c);
                }
            }else if(c == '"'){
                return new Token(TokenType.STRING,sb.toString());
            }else if(c == '\r' || c =='\n'){
                throw new JsonParseException("Invalid JSON INPUT");
            }else{
                sb.append((char) c);
            }
        }
    }

    private boolean isHex(int c){
        return (c >= '0' && c >= '9') || (c >= 'a' && c<= 'f')
                ||(c >= 'A' && c <= 'F');
    }

    private boolean isEscape() throws IOException {
        if(c == '\\'){
            c = read();
            if(c == '"' ||  c == '\\' || c == '/' || c == 'b' ||
                    c == 'f' || c == 'n' || c == 't' || c == 'r' || c == 'u'){
                return true;
            }else{
                throw new JsonParseException("Invalid JSON input");
            }
        }else{
            return false;
        }
    }

    private boolean isNum(int c){
        return isDigit(c) || c == '-';
    }

    private boolean isDigit(int c){
        return c >= '0' && c <= '9';
    }


    private Token readNum() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c = read();
        if(c == '-'){
            sb.append((char)c);
            c = read();
            if(c == '0'){
                sb.append((char)c);
                numAppend(sb);
            }else if(isDigitOne2Nine(c)){
                do{
                    sb.append((char)c);
                    c = read();
                }while(isDigit(c));
                unread();
                numAppend(sb);
            }else{
                throw new JsonParseException("- not followed by digit");
            }
        }else if(c == '0'){
            sb.append((char)c);
            numAppend(sb);
        }else if(isDigitOne2Nine(c)){
            do{
                sb.append((char)c);
                c = read();
            }while(isDigit(c));
            unread();
            numAppend(sb);
        }
        return new Token(TokenType.NUMBER,sb.toString());
    }

    private void numAppend(StringBuilder sb) throws IOException {
        c = read();
        if(c == '.'){
            sb.append((char)c);
            appendFrac(sb);
            if(isExp(c)){
                sb.append((char)c);
                appendExp(sb);
            }
        }else if(isExp(c)){
            sb.append((char)c);
            appendExp(sb);
        }else{
            unread();
        }
    }

    private void appendFrac(StringBuilder sb) throws IOException {
        c = read();
        while(isDigit(c)){
            sb.append((char)c);
            c = read();
        }
    }

    private boolean isExp(int c){
        return c == 'e' || c == 'E';
    }

    private void appendExp(StringBuilder sb) throws IOException {
        int c = read();
        if(c == '+' || c == '-'){
            sb.append((char)c);
            c = read();
            if(!isDigit(c)){
                throw new JsonParseException("e+(-) or E+(-) not followed by digit");
            }else{
                do{
                    sb.append((char)c);
                    c = read();
                }while(isDigit(c));
                unread();
            }
        }else if(!isDigit(c)){
            throw new JsonParseException("e or E not followed by + or - or digit.");
        }else{
            do{
                sb.append((char)c);
                c = read();
            }while(isDigit(c));
            unread();
        }
    }

    private boolean isDigitOne2Nine(int c){
        return c >= '1' && c <= '9';
    }

    public Token next(){
        return tokens.remove(0);
    }

    public Token peek(int i){
        return tokens.get(i);
    }

    public boolean hasNext(){
        return tokens.get(0).getType() != TokenType.END_DOC;
    }

}

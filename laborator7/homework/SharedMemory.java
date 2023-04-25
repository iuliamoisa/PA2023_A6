package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SharedMemory {
    List<Token>tokens = new ArrayList<>(); //collection of tokens
    public SharedMemory(int n) { //add all tokens to the collection and shuffle them;
        for(int i = 1 ;i <= n * n * n; i++){
            Token t = new Token(i);
            tokens.add(t);
        }
        Collections.shuffle(tokens);
    }
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        Collections.shuffle(tokens);
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            Random r = new Random();
            extracted.add(tokens.get(r.nextInt(tokens.size()))); //poll one token from the collection
        }
        return extracted;
    }

}

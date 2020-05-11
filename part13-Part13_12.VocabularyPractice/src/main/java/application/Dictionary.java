/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author woohoo
 */
public class Dictionary {
    private Map<String, String> translations;
    private List<String> words;

    public Dictionary() {
        this.translations = new HashMap<>();
        this.words = new ArrayList<>();
    }
    
    public boolean addTranslations(String word, String translation) {
        if (this.translations.containsKey(word)) {
            return false;
        }
        
        this.translations.put(word, translation);
        this.words.add(word);
        return true;
    }
    
    public String getTranslation(String word) {
        return this.translations.getOrDefault(word, null);
    }
    
    public String getRandomWord() {
        if (this.words.size() == 0) {
            return null;
        }
        Random rand = new Random();
        return this.words.get(rand.nextInt(this.words.size()));
    }
}

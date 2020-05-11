/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author woohoo
 */
public class SaveableDictionary {

    private Map<String, String> entries;
    private String file;

    public SaveableDictionary() {
        this.entries = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.entries = new HashMap<>();
        this.file = file;
    }

    public void add(String words, String translation) {
        if (!(this.entries.containsKey(words))) {
            this.entries.put(words, translation);
            this.entries.put(translation, words);
        }
    }

    public String translate(String word) {
        return this.entries.getOrDefault(word, null);
    }

    public void delete(String word) {
        this.entries.remove(this.entries.get(word));
        this.entries.remove(word);
    }

    public boolean load() {
        try {
            Files.lines(Paths.get(this.file))
                    .map(line -> line.split(":"))
                    .forEach(parts -> add(parts[0], parts[1]));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean save() {
        Set<String> savedWords = new HashSet<>();
        try {
            PrintWriter writer = new PrintWriter(this.file);
            String text = "";
            for (String word : this.entries.keySet()) {
                if (!(savedWords.contains(word) || savedWords.contains(this.entries.get(word)))) {
                    text += word + ":" + this.entries.get(word) + "\n";
                    savedWords.add(word);
                    savedWords.add(this.entries.get(word));
                }
            }
            if (text.length() > 0) {
                text = text.substring(0, text.length() - 1);
            }
            writer.println(text);
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}

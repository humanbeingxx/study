package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MagicDictionary {

    Map<String, String> words;

    public MagicDictionary() {
        words = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            StringBuilder stringBuilder = new StringBuilder(word);
            for (int i = 0; i < stringBuilder.length(); i++) {
                char old = stringBuilder.charAt(i);
                stringBuilder.setCharAt(i, '_');
                String transformed = stringBuilder.toString();
                if (words.containsKey(transformed)) {
                    words.put(transformed, "");
                } else {
                    words.put(transformed, word);
                }
                stringBuilder.setCharAt(i, old);
            }
        }
    }

    public boolean search(String searchWord) {
        StringBuilder stringBuilder = new StringBuilder(searchWord);
        for (int i = 0; i < stringBuilder.length(); i++) {
            char old = stringBuilder.charAt(i);
            stringBuilder.setCharAt(i, '_');
            String origin = words.get(stringBuilder.toString());
            if (origin != null && !origin.equals(searchWord)) {
                return true;
            }
            stringBuilder.setCharAt(i, old);
        }
        return false;
    }
}

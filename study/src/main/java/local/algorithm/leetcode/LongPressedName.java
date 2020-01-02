package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-02
 **/
public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int nameIndex = 0, typedIndex = 0;
        while (nameIndex < name.length()) {
            if (typedIndex >= typed.length()) {
                return false;
            }
            if (typed.charAt(typedIndex) == name.charAt(nameIndex)) {
                nameIndex++;
            }
            typedIndex++;

        }
        return true;
    }
}

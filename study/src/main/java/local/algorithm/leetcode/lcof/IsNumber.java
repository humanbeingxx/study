package local.algorithm.leetcode.lcof;

public class IsNumber {

    interface State {
        boolean check(int start, String s);

        State INIT = new State() {
            @Override
            public boolean check(int start, String s) {
                if (start < 0 || start >= s.length()) {
                    return false;
                }
                if (s.charAt(start) == '+' || s.charAt(start) == '-') {
                    return HAVE_POS.check(start + 1, s);
                } else {
                    return HAVE_POS.check(start, s);
                }
            }
        };

        State HAVE_POS = new State() {
            @Override
            public boolean check(int start, String s) {
                if (start < 0 || start >= s.length()) {
                    return false;
                }
                for (int i = start; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c == '.' && i > start) {
                        return HAVE_POINT.check(i + 1, s);
                    } else if ((c == 'E' || c == 'e') && i > start) {
                        return HAVE_E.check(i + 1, s);
                    } else if (c < '0' || c > '9') {
                        return false;
                    }
                }
                return true;
            }
        };

        State HAVE_POINT = new State() {
            @Override
            public boolean check(int start, String s) {
                if (start < 0 || start >= s.length()) {
                    return false;
                }
                for (int i = start; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (i > start && (c == 'e' || c == 'E')) {
                        return HAVE_E.check(i + 1, s);
                    } else if (c < '0' || c > '9') {
                        return false;
                    }
                }
                return true;
            }
        };

        State HAVE_E = new State() {
            @Override
            public boolean check(int start, String s) {
                if (start < 0 || start >= s.length()) {
                    return false;
                }
                if (s.charAt(start) == '+' || s.charAt(start) == '-') {
                    return EHAVE_POS.check(start + 1, s);
                } else {
                    return EHAVE_POS.check(start, s);
                }
            }
        };

        State EHAVE_POS = new State() {
            @Override
            public boolean check(int start, String s) {
                if (start < 0 || start >= s.length()) {
                    return false;
                }
                for (int i = start; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c > '9' || c < '0') {
                        return false;
                    }
                }
                return true;
            }
        };
    }

    public boolean isNumber(String s) {
        if (s.length() <= 0) {
            return false;
        }
        return State.INIT.check(0, s.trim());
    }

}

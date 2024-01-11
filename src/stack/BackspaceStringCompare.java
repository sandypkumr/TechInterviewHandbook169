package stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int sIndex = s.length() - 1;
        int tIndex = t.length() - 1;
        while (sIndex >= 0 || tIndex >= 0) {
            sIndex = nextValidIndex(s, sIndex);
            tIndex = nextValidIndex(t, tIndex);
            char cs = (sIndex >= 0)?s.charAt(sIndex):' ';
            char ct = (tIndex >= 0)?t.charAt(tIndex):' ';
            if (cs != ct) return false;
            sIndex--;
            tIndex--;
        }
        return true;
    }

    private int nextValidIndex(String str, int index) {
        int backspaces = 0;
        while (index >= 0) {
            if (backspaces == 0 && str.charAt(index) != '#') {
                break;
            } else if (str.charAt(index) == '#') {
                backspaces++;
            } else {
                backspaces--;
            }
            index--;
        }
        return index;
    }
}

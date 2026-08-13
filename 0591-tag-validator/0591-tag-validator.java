public class Solution {
    public boolean isValid(String code) {
        if (code.equals("t")) return false;
        code = code.replaceAll("<!\\[CDATA\\[.*?\\]\\]>", "c");

        String prev = "";
        while (!code.equals(prev)) {
            prev = code;
            code = code.replaceAll("<([A-Z]{1,9})>[^<]*</\\1>", "t");
        }

        return code.equals("t");
    }
}
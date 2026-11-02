class Solution {
    public int findMinStep(String board, String hand) {
        char[] handArr = hand.toCharArray();
        Arrays.sort(handArr);
        return dfs(board, new String(handArr), new HashMap<>());
    }

    private int dfs(String board, String hand, Map<String, Integer> memo) {
        if (board.isEmpty()) {
            return 0;
        }
        if (hand.isEmpty()) {
            return -1;
        }

        String key = board + '#' + hand;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int minSteps = Integer.MAX_VALUE;

        for (int i = 0; i < hand.length(); i++) {
            // Prune duplicate balls in hand at the same recursion depth
            if (i > 0 && hand.charAt(i) == hand.charAt(i - 1)) {
                continue;
            }

            char ball = hand.charAt(i);
            String nextHand = hand.substring(0, i) + hand.substring(i + 1);

            for (int j = 0; j <= board.length(); j++) {
                // Prune unpromising insertion slots
                if (!isGoodPlace(board, j, ball)) {
                    continue;
                }

                String insertedBoard = board.substring(0, j) + ball + board.substring(j);
                String collapsedBoard = collapse(insertedBoard);

                int subSteps = dfs(collapsedBoard, nextHand, memo);
                if (subSteps != -1) {
                    minSteps = Math.min(minSteps, subSteps + 1);
                }
            }
        }

        int result = (minSteps == Integer.MAX_VALUE) ? -1 : minSteps;
        memo.put(key, result);
        return result;
    }

    private boolean isGoodPlace(String board, int pos, char ball) {
        // Scenario 1: Extend an existing same-color run
        if (pos > 0 && board.charAt(pos - 1) == ball) {
            return true;
        }
        // Scenario 2: Split an identical pair to enable nested cascades
        if (pos > 0 && pos < board.length() && board.charAt(pos - 1) == board.charAt(pos)) {
            return true;
        }
        return false;
    }

    private String collapse(String board) {
        int i = 0;
        while (i < board.length()) {
            int j = i;
            while (j < board.length() && board.charAt(i) == board.charAt(j)) {
                j++;
            }
            if (j - i >= 3) {
                return collapse(board.substring(0, i) + board.substring(j));
            } else {
                i = j;
            }
        }
        return board;
    }
}

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, wildcard = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'L') left++;
            else if (ch == 'R') right++;
            else wildcard++;
        }

        return Math.abs(left - right) + wildcard;
    }
}

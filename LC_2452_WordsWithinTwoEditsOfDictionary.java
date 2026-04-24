// Problem: Words Within Two Edits of Dictionary
// Platform: LeetCode
// Approach: Brute Force Comparison
// 
// Idea:
// Compare each query word with every word in dictionary.
// Count character differences.
// If difference <= 2 → valid word.
//
// Time Complexity: O(n * m * k)
// n = queries.length
// m = dictionary.length
// k = word length
//
// Space Complexity: O(1) (excluding result list)

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        
        int stringLength = queries[0].length();
        
        for (String queryString : queries) {
            for (String dictionaryWord : dictionary) {
                int differenceCount = 0;
                
                for (int i = 0; i < stringLength; i++) {
                    if (queryString.charAt(i) != dictionaryWord.charAt(i)) {
                        differenceCount++;
                        
                        // 🔥 Optimization: break early
                        if (differenceCount > 2) break;
                    }
                }
                
                if (differenceCount <= 2) {
                    result.add(queryString);
                    break;
                }
            }
        }
        
        return result;
    }
}

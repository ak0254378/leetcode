class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        String[] phone = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };
        backtrack(0, digits, new StringBuilder(), ans, phone);
        return ans;
    }
    private void backtrack(int index, String digits,
                           StringBuilder current,
                           List<String> ans,
                           String[] phone) {
        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }
        String letters = phone[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            current.append(ch);      
            backtrack(index + 1, digits, current, ans, phone);
            current.deleteCharAt(current.length() - 1); 
        }
    }
}
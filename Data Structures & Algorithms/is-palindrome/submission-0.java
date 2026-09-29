class Solution {
    public boolean isPalindrome(String s) {
        // FIX 1: Initialize right to the last valid index
        int left = 0, right = s.length() - 1; 

        while (left < right) {
            // FIX 2: Use else-if to skip and restart the loop
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } 
            else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } 
            else {
                // Compare characters
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                // FIX 3: Move both pointers inward if they match
                left++;
                right--;
            }
        }

        return true;
    }
}
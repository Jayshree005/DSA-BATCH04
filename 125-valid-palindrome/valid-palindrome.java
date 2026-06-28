class Solution {
    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {

            // Non-alphanumeric characters skip karo
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            // Lowercase me convert karke compare karo
            char startChar = Character.toLowerCase(s.charAt(start));
            char endChar = Character.toLowerCase(s.charAt(end));

            if (startChar != endChar) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
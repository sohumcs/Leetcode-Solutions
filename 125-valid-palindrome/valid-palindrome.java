class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while(start<=end){
            char charFirst = s.charAt(start);
            char charLast = s.charAt(end);
            if(!Character.isLetterOrDigit(charFirst)){
                start++;
            }else if(!Character.isLetterOrDigit(charLast)){
                end--;
            }else{
                if(Character.toLowerCase(charFirst) != Character.toLowerCase(charLast)){
                    return false;
                }
                start++;
                end--;
            }
        }
    return true;
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character,Integer> count = new HashMap<>();
        if(m != n){
            return false;
        }for(char x : s.toCharArray()){
            count.put(x, count.getOrDefault(x,0)+1);
        }
        for(char x : t.toCharArray()){
            count.put(x, count.getOrDefault(x,0)-1);
        }
        for(int val : count.values()){
            if(val!=0){
                return false;
            }
        }
        return true;
    }
}
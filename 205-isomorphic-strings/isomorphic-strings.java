class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] indS = new int[200];
        int[] indT = new int[200];
        int len = s.length();
        if(len != t.length()){
            return false;
        }
        for(int i = 0; i<len; i++){
            if(indS[s.charAt(i)] != indT[t.charAt(i)]){
                return false;
            }
            indS[s.charAt(i)] = i + 1; 
            indT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
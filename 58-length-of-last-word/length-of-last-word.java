class Solution {
    public int lengthOfLastWord(String s) {
      s = s.trim();
      int ind=-1;
      if(s.length()==1) return 1;
      for(int  i = s.length()-1;i>=0;i--){
        if(s.charAt(i)==' '){
           ind  =  i;
            break;
        }
      }
      if(ind==-1) return s.length();
      String res = s.substring(ind,s.length()-1)  ;
      return res.length();
    }
}
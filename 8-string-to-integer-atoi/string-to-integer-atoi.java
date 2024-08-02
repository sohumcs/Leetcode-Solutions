class Solution {
    public int myAtoi(String s) {
        s=s.trim();// getting rid of white spaces
        System.out.println(s);
        // what if the s is just whitespaces
        if (s.length() == 0)
            return 0;

        // keeping a variable for sign validation
        int sign = 1;
        int index = 0;//handling index inorder to make my for loop start after the sign parsing is done
        char first = s.charAt(0);
        if (first == '-') {
            sign = -1;
            index++;
        } else if (first == '+') {
            index++;
        }

        long parsed = 0;//long has to initalized due to overflow conditions
        for (int i = index; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
              break; //using isDigit java function to verify whether the string is digit or a character or a whitespace at which our loop should probable breakout return whatever it has
            }
            int digit = s.charAt(i) - '0';//ascii subtraction inorder to get the integer ascii of'0'= 48 
            System.out.println(digit);
            parsed = parsed * 10 + digit;// eg. '123' 1=1*10+2=12 <--- parsed became 12
                                                    // 12=12*10+3=123 <--- parsed became 123
            if (sign == 1 && parsed > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * parsed < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) parsed*sign;//return int type 
    }
    
}
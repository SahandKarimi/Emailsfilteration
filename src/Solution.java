import java.util.HashMap;
class Solution {
    public static void main(String [] args){
        int num = 0;
        String [] emails  = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        Solution s;
        num = numUniqueEmails(emails);
        System.out.println(num);
    }
    public static int numUniqueEmails(String[] emails) {
        HashMap<String, Integer> myMap = new HashMap<>();
        boolean endOfLocal = false;
        for (String email : emails) {
            boolean startDomain = false;
            StringBuilder myString = new StringBuilder(email);
            for (int j = 0; j < myString.length(); j++) {
                if (endOfLocal) {
                    if (myString.charAt(j) == '@') {
                        endOfLocal = false;
                        startDomain = true;
                    } else {
                        myString.deleteCharAt(j);
                        j--;
                    }
                } else if (!startDomain && myString.charAt(j) == '.') {
                    myString.deleteCharAt(j);
                    j--;
                } else if (myString.charAt(j) == '+') {
                    myString.deleteCharAt(j);
                    j--;
                    endOfLocal = true;
                }
                else if (myString.charAt(j) == '@'){
                    startDomain = true;
                }
            }
            String temp = myString.toString();
            if (!myMap.containsKey(temp)) {
                myMap.put(temp, 1);
                System.out.println(myString);
            }

        }
        return myMap.size();
    }
}
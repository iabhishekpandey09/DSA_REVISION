import java.util.*;

public class SubstringAtMost_Kdistinct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String : ");
        String s = sc.nextLine();

        System.out.print("Enter k : ");
        int k = sc.nextInt();

        int res = subStringAtMostK(s, k);
        System.out.println("Length of the Longest substring with atMost k Distinct Character is : " + res);

        sc.close();
    }

    private static int subStringAtMostK(String s, int k) {
        int left = 0, maxLen = 0;
        HashMap<Character, Integer>mp = new HashMap<>();

        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            mp.put(rightChar, mp.getOrDefault(rightChar,0) + 1);

            if(mp.size() > k) {
                char leftChar = s.charAt(left);
                mp.put(leftChar, mp.get(leftChar) - 1);

                if(mp.get(leftChar) == 0) {
                    mp.remove(leftChar);
                }

                left++;
            }

            if(mp.size() <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}

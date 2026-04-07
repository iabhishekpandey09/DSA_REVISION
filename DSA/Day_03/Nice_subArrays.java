// This is the Leetcode 1248. Count Number of Nice Subarrays


import java.util.Scanner;

public class Nice_subArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();

        System.out.print("Enter the k : ");
        int k = sc.nextInt();

        System.out.print("Enter the array : ");
        int arr[] = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Number of subarray with k different Integer is : " + niceSubArr(arr, n, k));

        sc.close();   
    }

    private static int niceSubArr(int arr[], int n, int k) {
        return atMost(arr, n, k) - atMost(arr, n, k - 1);
    }

    private static int atMost(int arr[], int n, int k) {
        int count = 0, left = 0, oddCount = 0;

        for(int right = 0; right < n; right++) {
            if(arr[right] % 2 != 0) {
                oddCount++;
            }

            while(oddCount > k) {
                if(arr[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }
}

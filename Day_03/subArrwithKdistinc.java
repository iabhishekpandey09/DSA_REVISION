import java.util.HashMap;
import java.util.Scanner;

class subArrwithKdistinc{
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

        System.out.println("Number of subarray with k different Integer is : " + kDiffrentInteger(arr, n, k));

        sc.close();
    }

    private static int  kDiffrentInteger(int arr[], int n, int k) {
        return atMost(arr, n, k) - atMost(arr, n, k - 1);
    }

    private static int atMost(int arr[], int n, int k) {
        int count = 0;
        int left = 0;
        HashMap<Integer, Integer>mp = new HashMap<>();

        for(int right = 0; right < n; right++) {
            mp.put(arr[right], mp.getOrDefault(arr[right], 0) + 1);

            while (mp.size() > k) {
                mp.put(arr[left], mp.get(arr[left]) - 1);

                if(mp.get(arr[left]) == 0) {
                    mp.remove(arr[left]);
                }

                left = left + 1;
            }

            count += right - left + 1;
        }
        return count;
    }
}
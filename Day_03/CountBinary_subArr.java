import java.util.Scanner;

class CountBinary_subArr {
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

        System.out.println("Number of subarray with k different Integer is : " + countBinarysubArray(arr, n, k));

        sc.close();   
    }

    private static int countBinarysubArray(int arr[], int n, int k) {
        return atMost(arr, n, k) - atMost(arr, n, k - 1);
    }

    private static int atMost(int arr[], int n, int k) {
        int sum = 0, left = 0, count = 0;

        for(int right = 0; right < n; right++) {
            sum += arr[right];

            while(left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }
}

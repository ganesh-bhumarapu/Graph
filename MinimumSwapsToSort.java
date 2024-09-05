import java.util.*;
class MinimumSwapsToSort{
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static int minSwaps(int[] nums){
        int n = nums.length;
        int count = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mp.put(nums[i], i);
        }
        Arrays.sort(nums);// this for checking the indices of sorted array with the map
        for(int i = 0; i < n; i++){
            if(i == mp.get(nums[i])){
                continue;
            }
            else{
                count++;
                swap(nums, i, mp.get(nums[i]));
                i--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(minSwaps(nums));
    }
}
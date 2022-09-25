package _4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> twoSum(int[] arr, int si, int ei, int targ) {
        List<List<Integer>> res = new ArrayList<>();
        int left = si;
        int right = ei;
        while (left < right) {
            if (left != si && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }
            int sum = arr[left] + arr[right];
            if (sum == targ) {
                List<Integer> sub = new ArrayList<>();
                sub.add(arr[left]);
                sub.add(arr[right]);
                res.add(sub);
                left++;
                right--;
            } else if (sum < targ) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        if (n < 4) {
            return res;
        }
        for (int i = 0; i <= n - 4; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int val1 = nums[i];
            int targ = target - val1;
            List<List<Integer>> sub = threeSum(nums, targ, i + 1);
            for (List<Integer> list : sub) {
                list.add(val1);
                res.add(list);
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int target, int si) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return res;
        for (int i = si; i <= n - 3; i++) {
            if (i != si && nums[i] == nums[i - 1]) continue;
            int val1 = nums[i];
            int targ = target - val1;
            List<List<Integer>> subres = twoSum(nums, i + 1, n - 1, targ);
            for (List<Integer> list : subres) {
                list.add(val1);
                res.add(list);
            }
        }
        return res;
    }
}

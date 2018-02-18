class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        search(nums,0,nums.length-1,target,result);
        return result;
    }
    
    private void search(int[] nums, int start, int end, int target, int[] result){
        if(start > end){
            return;
        }
        int mid = (start+end)/2;
        if(nums[mid] < target){
            search(nums,mid+1,end,target,result);
            return;
        }else if(nums[mid] > target){
            search(nums,start,mid-1,target,result);
            return;
        }else{
           int temp = mid;
            while(temp >= 0 && nums[temp] == target){
                result[0] = temp;
                temp--;
            }
            temp = mid;
            while(temp < nums.length && nums[temp] == target){
                result[1] = temp;
                temp++;
            }
            
        }
    }
    
}

import java.util.*;
class Hash {
    public static int[] prefixarr(int [] nums){
        int sum=0;
        int ans[] = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            ans[i] = sum;
            System.out.println(ans[i]+" ");
        }
        return ans;
    }
    public static void itinerary(HashMap<String,String> hash){
        String starting="";
        HashSet<String> list = new HashSet<>();
        for(String val:hash.values()){
            list.add(val);
        }
        for(String str:hash.keySet()){
            if(!list.contains(str)){
                starting = starting+str;
            }
        }
        while(hash.containsKey(starting)){
            System.out.print(starting+"-> ");
            starting = hash.get(starting);
        }
        System.out.print(starting);
    }
    public static int intersec(int a1[],int a2[]){
        int c=0;
        HashSet<Integer> list = new HashSet<>();
        for(int i=0;i<a1.length;i++){
            list.add(a1[i]);
        }
        for(int i=0;i<a2.length;i++){
            if(list.contains(a2[i])){
                c++;
                System.out.print(a2[i]+" ");
                list.remove(a2[i]);
            }
        }
        return c;
    }
    public static HashSet<Integer> union(int a1[],int a2[]){
        HashSet<Integer> list = new HashSet<>();
        for(int i=0;i<a1.length;i++){
            list.add(a1[i]);
        }
        for(int i=0;i<a2.length;i++){
            list.add(a2[i]);
        }
        return list;
    }
    public static void mostOcc(int nums[]){
        int m = nums.length/3;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(Integer k:map.keySet()){
            Integer v = map.get(k);
            if(v>m){
                System.out.println(k);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int nums[]={1,2,2,5,1,2,1,5,1,2};
        mostOcc(nums);
        int a1[]={1,2,4,5,6,9,10,17,7};
        int a2[]={10,2,-2,-20,10};
        System.out.println(union(a1,a2));
        System.out.println(intersec(a1,a2));
        HashMap<String,String> hash = new HashMap<>();
        hash.put("M","G");
        hash.put("L","B");
        hash.put("G","L");
        itinerary(hash);
        prefixarr(a2);
    }
}
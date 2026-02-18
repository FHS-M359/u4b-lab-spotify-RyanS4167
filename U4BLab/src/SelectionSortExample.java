import java.util.ArrayList;

public class SelectionSortExample {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(6);
        nums.add(4);
        nums.add(2);
        nums.add(18);
        nums.add(9);
        nums.add(11);
        nums.add(4);
        nums.add(7);
        nums.add(24);
        nums.add(17);

        System.out.println("Current contents: " + nums.toString());
        selectionSort(nums);
        System.out.println("After sorting:    " + nums.toString());
    }

    public static void selectionSort(ArrayList<Integer> list) {
        for(int i = 0; i<list.size()-1; i++){
            int minIndex = i;
            //Searches rest of the ArrayList for the smallest index
            for(int j = i+1; j<list.size(); i++){
                if(list.get(j) < list.get(minIndex)){
                    //Swap statements
                    int temp = list.get(i);
                    list.set(i, list.get(minIndex));
                    list.set(minIndex, temp);
                }
            }
        }


    }
}

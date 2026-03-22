import java.util.*;
class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String op : operations) {
            int n = list.size();

            if (op.equals("+")) {
                int sum = list.get(n - 1) + list.get(n - 2);
                list.add(sum);
            } 
            else if (op.equals("D")) {
                list.add(2 * list.get(n - 1));
            } 
            else if (op.equals("C")) {
                list.remove(n - 1);
            } 
            else {
                list.add(Integer.parseInt(op));
            }
        }
        int total = 0;
        for (int score : list) {
            total += score;
        }
        return total;
    }
}
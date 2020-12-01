import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();

      while(t-->0){
          int n = sc.nextInt();
          List<Long> ci = new ArrayList<>(), fi = new ArrayList<>();
          List<List<Long>> li = new ArrayList<>();

          for(int i=0;i<n;i++){
              fi.add(sc.nextLong());
          }
          for(int i=0;i<n;i++){
              ci.add(sc.nextLong());
              List<Long> temp = new ArrayList<>();
              temp.add(ci.get(i));
              temp.add(fi.get(i));
              li.add(temp);
          }
          Collections.sort(li,(o1, o2) -> (int) (o1.get(0)-o2.get(0)));

          int left =n;
          long cost=0;
         for(int i=0;i<li.size();i++){
             Long val = Math.min(left, li.get(i).get(1));
             cost += (val*li.get(i).get(0));
             left -= val;
             if(left==0) break;
         }
          System.out.println(cost);
      }
    }
}

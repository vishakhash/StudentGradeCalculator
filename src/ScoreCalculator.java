import java.util.*;
public class ScoreCalculator {

    public HashMap<String,Integer> getFinalScores(ArrayList<Scores> input){
        HashMap<String, PriorityQueue<Integer>> hm = new HashMap<String, PriorityQueue<Integer>>();
        while(!input.isEmpty()){
            Scores node = input.remove(0);
            PriorityQueue<Integer> pq = hm.getOrDefault(node.studentID, new PriorityQueue<Integer>(11,new Comparator<Integer>(){
                @Override
                public int compare(Integer x, Integer y) {
                    if(y>x) return 1;
                    else return -1;
                }}));
            pq.add(node.score);
            hm.put(node.studentID, pq);
        }

        HashMap<String,Integer> output = new HashMap<String,Integer>();
        for(Map.Entry<String, PriorityQueue<Integer>> entry : hm.entrySet()){
            int sum=0;
            int i=0;
            for(i=0;((i<5)&&(entry.getValue().peek()!=null));i++){
                sum=sum+entry.getValue().poll();
            }
            if(i!=0) sum/=i;
            output.put(entry.getKey(),sum);
        }
        return output;
    }

}

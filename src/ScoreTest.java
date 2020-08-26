import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.*;
public class ScoreTest {

    @Test
    public void test1(){
        ScoreCalculator sol = new ScoreCalculator();
        ArrayList<Scores> input = new ArrayList<Scores>();

        input.add(new Scores("vishakha", 90));
        input.add(new Scores("vishakha", 88));
        input.add(new Scores("vishakha", 85));
        input.add(new Scores("vishakha",88));
        input.add(new Scores("akshay",92));
        input.add(new Scores("akshay",87));
        input.add(new Scores("akshay",90));
        input.add(new Scores("akshay",88));



        HashMap<String,Integer> hm = sol.getFinalScores(input);
        for(Entry<String, Integer> entry : hm.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
        assertEquals((int)hm.get("vishakha"),87);
        assertEquals((int)hm.get("akshay"),89);

    }

}

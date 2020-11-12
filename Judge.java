import java.util.Arrays;

public class Judge {

    public int findJudge(int N, int [][] trust){
        //create incident array
        int[] incident = new int[N];
        //loop through all sub arrays of trust
        for (int v = 0; v < trust.length; v++){
            //loop through each first index of sub arrays (trusted people)
            for (int w = 1; w < trust[0].length; w++){
                //tally up all the trusted people in the
                incident[trust[v][w]] += 1;
            }
        }
        int max = 0;
        int judge = 0;
        //loop through incidents array
        for(int i = 0; i < incident.length; i++){
            //check which index in incidents array has most trusted people
            if(incident[i] > max){
                //store that index (possible judge) as judge
                judge = i;
                //keep track of the max amount of trust recieved
                max = incident[judge];

            }
        }
        //loop through trust array: only loop through people who are sending trust
        for(int j = 0; j < trust.length; j++){
            int k = 0;
            //if the person with the most trust is also sending trust, judge DNE
            //OR if everybody doesn't trust town judge (checking that the amount of trust received by possible judge == N-1 which represents (the number of people in the town - the judge) because they cant trust themselves
            if(trust[j][k] == judge || max != N-1){
                return -1;
            }
        }
        return judge;
    }

    public static void main(String[] args) {
        Judge judge = new Judge();
        int [][] trust = {{1,2},{3,2},{4,3},{4,2}};
        System.out.println(judge.findJudge(4,trust));
    }
}

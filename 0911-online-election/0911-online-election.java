import java.util.Arrays;
class TopVotedCandidate {
int[] voteCount;
int[] leaders;
int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;

        int n = persons.length;
        voteCount = new int[n];
        leaders = new int[n];

        int currentLeader = -1;
        int maxVotes = 0;

        for(int i = 0; i < n; i++){
            int person = persons[i];
            voteCount[person]++;

            if(voteCount[person] >= maxVotes){
                maxVotes = voteCount[person];
                currentLeader = person;
            }
            leaders[i] = currentLeader;
        }
    }
    
    public int q(int t) {
        int index = Arrays.binarySearch(times, t);

        if(index < 0){
            index = -(index + 2);
        }
        return leaders[index];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
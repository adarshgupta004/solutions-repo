class Solution {
public:
    bool isRobotBounded(string instructions) {
     int n = instructions.size();
     int x = 0, y = 0, dir = 0;

     for(int i = 0; i < 4 * n; i++){
        if(instructions[i % n] == 'L'){
            dir = (dir + 3) % 4;
        }else if(instructions[i % n] == 'R'){
            dir = (dir + 1) % 4;
        } else{
            if(dir == 0) y++;
            else if(dir == 1) x++;
            else if(dir == 2) y--;
            else x--;
        }
     }   
     return (x == 0 && y == 0);
    }
};
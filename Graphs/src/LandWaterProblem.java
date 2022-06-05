// Island Problem (Connected Components)
// 0 -> Land
// 1 -> Water

public class LandWaterProblem {

    public static void main(String[] args) {
        int[][] body = {{1,1,1,0,0},
                        {1,1,1,0,0},
                        {0,1,1,1,1},
                        {0,1,1,0,1},
                        {0,1,1,1,0}};

        int countLandMasses = 0;

        for(int i=0;i< body.length;i++){
            for(int j=0;j<body[i].length;j++){
             if(body[i][j] == 0){
                 countLandMasses++;
                 countLand(i, j,body);
             }
            }
        }
        System.out.println(countLandMasses);
    }

    private static void countLand(int x,int y,int[][] body){
        // base condition
        if(x <0 || y<0 || x >= body.length ||  y >= body.length || body[x][y] == 1)
            return;

        body[x][y] = 1;

        // west
        countLand(x,y-1,body);
        // north
        countLand(x-1,y,body);
        // east
        countLand(x,y+1,body);
        // south
        countLand(x+1,y,body);

    }

}

package algorithm;

public class Sudoku {
    private int[][] input;
    private int depth = 0;
    private int[] path = new int[81];
    private int lastX;
    private int lastY;
    Sudoku(int[][] input){
        this.input = input;
    }

    public int[][] resolve(){
        if(finish(0,0)){
            for (int i = 8; i >=0; i--) {
                for (int j = 8; j >=0; j--) {
                    if(input[i][j] == 0){
                        input[i][j] = path[depth--];
                    }
                }
            }
        }
        return input;
    }

    private boolean finish(int x,int y) {
        //如果全部填完，返回成功
        if (x == lastX && y == lastY){
            return true;
        }


        return false;
    }
}

class Game{

    int[][] Board;

    public Game(int Size, int Mines){
        Board=new int[Size][Size];

        for(int i=0;i<Size;i++){
            for(int j=0;j<Size;j++){
                Board[i][j]=-1;
            }
        }

        for(int i=0;i<Mines;i++){
            boolean Found=false;
            while(Found==false){
                int X=(int)(Math.random()*Size);
                int Y=(int)(Math.random()*Size);

                if(Board[X][Y]==-1){
                    Found=true;
                    Board[X][Y]=9;
                }

            }
        }

        for(int i=0;i<Size;i++){
            for(int j=0;j<Size;j++){
                int MinesAj=0;

                if(i-1>=0 && j+1<Size) {//Top Left
                    if (Board[i-1][j+1]==9) {
                        MinesAj++;
                    }
                }

                if(j+1<Size) {//Top
                    if (Board[i][j+1]==9) {
                        MinesAj++;
                    }
                }

                if(i+1<Size && j+1<Size) {//Top Right
                    if (Board[i+1][j+1]==9) {
                        MinesAj++;
                    }
                }

                if(i-1>=0) {//Left
                    if (Board[i-1][j]==9) {
                        MinesAj++;
                    }
                }

                if(i+1<Size) {//Right
                    if (Board[i+1][j]==9) {
                        MinesAj++;
                    }
                }

                if(i-1>=0 && j-1>=0) {//Bottom Left
                    if (Board[i-1][j-1]==9) {
                        MinesAj++;
                    }
                }

                if(j-1>=0) {//Bottom
                    if (Board[i][j-1]==9) {
                        MinesAj++;
                    }
                }

                if(i+1<Size && j-1>=0) {//Bottom Right
                    if (Board[i+1][j-1]==9) {
                        MinesAj++;
                    }
                }

                

                if(Board[i][j]!=9){
                    Board[i][j]=MinesAj;
                }
                
            }
        }

        for(int i=0;i<Size;i++){
            for(int j=0;j<Size;j++){
                if (Board[i][j]==9) {
                    System.out.print("X ");
                }
                else{
                    System.out.print(Board[i][j]+" ");
                }
            }
            System.out.println();
        }

    }

}
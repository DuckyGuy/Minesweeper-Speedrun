import java.util.Scanner;

class Game{

    int[][] Board;
    boolean[][] Revealed;
    Scanner in;


    private boolean s(int X, int Y, int BX, int BY){
        if(X==BX && Y==BY && Revealed[X][Y]==false){
            return true;
        }
        if(X<0 || X>=Revealed.length || Y<0 || Y>=Revealed[0].length){
            return false;
        }
        else if(Revealed[X][Y]==false && Board[BX][BY]==0 && Board[X][Y]!=9){
            return true;
        }
        return false;
    }

    private boolean IsSafeSpace(int X, int Y){
        if(X<0 || X>=Board.length || Y<0 || Y>=Board[0].length){
            return true;
        }
        else if(Board[X][Y]==-1){
            return true;
        }
        return false;
    }
    // boolean[][] Revealed;
    private void Reveal(int X, int Y){
        // System.out.println(X+" "+Y);
        if(s(X,Y,X,Y)){
            Revealed[X][Y]=true;
        }
        if(s(X-1, Y-1,X,Y)){
            Revealed[X-1][Y-1]=true;
            Reveal(X-1, Y-1);
        }
        if(s(X, Y-1,X,Y)){
            Revealed[X][Y-1]=true;
            Reveal(X, Y-1);
        }
        if(s(X+1, Y-1,X,Y)){
            Revealed[X+1][Y-1]=true;
            Reveal(X+1, Y-1);
        }
        

        if(s(X-1, Y,X,Y)){
            Revealed[X-1][Y]=true;
            Reveal(X-1, Y);
        }
        if(s(X, Y,X,Y)){
            Revealed[X][Y]=true;
            Reveal(X, Y);
        }
        if(s(X+1, Y,X,Y)){
            Revealed[X+1][Y]=true;
            Reveal(X+1, Y);
        }

        if(s(X-1, Y+1,X,Y)){
            Revealed[X-1][Y+1]=true;
            Reveal(X-1, Y+1);
        }
        if(s(X, Y+1,X,Y)){
            Revealed[X][Y+1]=true;
            Reveal(X, Y+1);
        }
        if(s(X+1, Y+1,X,Y)){
            Revealed[X+1][Y+1]=true;
            Reveal(X+1, Y+1);
        }

    }

    public Game(int Size, int Mines, int StartX, int StartY){
        in=new Scanner(System.in);
       
        Board=new int[Size][Size];
        Revealed=new boolean[Size][Size];

        //  Scanner in=new Scanner(System.in);



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

                if(Board[X][Y]==-1 && !((StartX-1==X && StartY-1==Y) || (StartX==X && StartY-1==Y) || (StartX+1==X && StartY-1==Y) || (StartX-1==X && StartY==Y) || (StartX==X && StartY==Y) || (StartX+1==X && StartY==Y) || (StartX-1==X && StartY+1==Y) || (StartX==X && StartY+1==Y) || (StartX+1==X && StartY+1==Y))){
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

        // Reveal(StartX, StartY);

        // for(int i=0;i<Size;i++){
        //     for(int j=0;j<Size;j++){
        //         if (Board[i][j]==9) {
        //             System.out.print("X ");
        //         }
        //         else{
        //             System.out.print(Board[i][j]+" ");
        //         }
        //     }
        //     System.out.println();
        // }

        while (true) {
            if(PlayNext(StartY, StartX)){

            }
            else{
                System.out.println("The O is the crater your remains now lay.");
                System.out.println();
                Board[StartY][StartX]=10;
                PrintBaord(true);
                return;
            }
            StartX=in.nextInt();
            StartY=in.nextInt();
            in.nextLine();
        }

        // PlayNext(StartX, StartY);
    }

    private  void PrintBaord(boolean RevealAll){
for(int i=0;i<Board.length;i++){
            for(int j=0;j<Board[i].length;j++){
                if(Revealed[i][j] || RevealAll){
                    if (Board[i][j]==9) {
                        System.out.print("X ");
                    }
                    else if (Board[i][j]==10) {
                        System.out.print("O ");
                    }
                    else{
                        System.out.print(Board[i][j]+" ");
                    }
                }
                else{
                        System.out.print("_ ");
                }
                
            }
            System.out.println();
        }
    }

    private boolean PlayNext(int X, int Y){

        if(Board[X][Y]==9){
            return false;
        }

        Reveal(X, Y);
        PrintBaord(false);
            return true;

    }

}
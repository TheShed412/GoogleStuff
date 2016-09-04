import java.util.*;

public class RecRabbit
{
    public static void main(String[] args)
    {
         int[] x = {8,2,3,5,1,2,12,4,7,41};
         answers(x);
        //int[] x = {12,0,0,0,0,4};
        //moveRabbits(0, 5, x);
        for(int i=0; i<x.length; i++){
            System.out.print(x[i]+" \n");
        }//for




    }

    public static int answers(int[] x)
    {
        total(0, x.length-1, x);
        return 0;
    }//answers

    public static void total(int lp, int hp, int[] x)
    {
        if(lp < hp){
          int middle = lp + (hp-lp)/2;
          total(lp, middle, x);
          total(middle+1, hp, x);
          moveRabbits(lp, hp, x);
      }
    }//total

    public static void moveRabbits(int lp, int hp, int[] x)
    {
      int nump = 0;

      if(nump != lp){
          for(int i=lp+1; i<=hp; i++){
            if(x[i]>0){
                nump = i;
            }//if
          }//for
          while(x[nump]>0){
              move(lp, nump, x);
          }//while
      }//if
    }//moveRabbits

    public static void move(int lp, int hp, int[] x)
    {
      x[lp] ++;
      x[hp] --;
    }//move
}

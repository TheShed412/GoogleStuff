import java.util.*;

public class RecRabbit
{
    public static void main(String[] args)
    {
        Random rng = new Random();
        int[] x = new int[(rng.nextInt(100)+2)];

        //System.out.println(x.length+"\n\n");

        for(int i=0; i<x.length; i++){
            x[i] = rng.nextInt(1000000);
        }//for
        System.out.println(answer(x));

        for(int i=0; i<x.length; i++){
            System.out.println(x[i]+" ");
        }
    }

    public static int answer(int[] x)
    {
        int sum = 0;
        int avg = 0;
        for(int i=0; i<x.length; i++){
            sum+=x[i];
        }//for
        avg = (sum/x.length);
        total(0, x.length-1, x);
        distribute(0, x.length-1, x, avg);
        if(x[0]>avg){
            distribute(0, x.length-1, x, 1);
        }
        return count(x, avg);
    }//answers

    public static int count(int[] arr, int avg)
    {
        int a1 = 0;
        int a2 = 0;
        int avg2 = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == avg){
                a1++;
            }else{
                a2++;
                avg2 = arr[i];
            }//if else
        }//for

        if(a1>=a2){
            return a1;
        }else{
            return a2;
        }
    }//count


    public static void distribute(int lp, int hp, int[] x, int avg)
    {
        if (lp<hp){
            int middle = lp + (hp-lp)/2;
            disRabbits(lp, middle+1, x, avg);
            distribute(lp, middle, x, avg);
            distribute(middle+1, hp, x, avg);
        }//if
    }//distribute

    public static void disRabbits(int lp, int mp, int[] x, int avg)
    {
        for(int i=0; i<avg && x[0]>x[x.length-1]; i++){
            move(mp, 0, x);
        }//for
    }//disRabbits

    public static void total(int lp, int hp, int[] x)
    {
        if(lp < hp){
          int middle = lp + (hp-lp)/2;
          total(lp, middle, x);
          total(middle+1, hp, x);
          conRabbits(lp, hp, x);
      }//if
    }//total

    public static void conRabbits(int lp, int hp, int[] x)
    {
      int nump = 0;

          for(int i=lp+1; i<=hp; i++){
            if(x[i]>0){
                nump = i;
            }//if
          }//for

          while(x[nump]>0){
              move(lp, nump, x);
          }//while
    }//moveRabbits

    public static void move(int lp, int hp, int[] x)
    {
      x[lp] ++;
      x[hp] --;
    }//move
}

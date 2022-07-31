package uz.learn;
import uz.learn.objects.*;
import java.util.Scanner;

public class BinaryTreeDemo{

    public static void main(String ... args){
        int row = 5;
        int col = 5;
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        sc.close();
        System.out.println(BinaryTree.on(new Grid(row,col)));
    }
}

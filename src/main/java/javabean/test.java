package javabean;

import java.util.Scanner;
import java.util.TreeSet;


public class test {
    static double a = 0, b = 0, c = 0, d = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        d = sc.nextDouble();
        TreeSet<Double> ans = new TreeSet<Double>();

        double temp1 = func(-100);
        double temp2;
        for (int i = -99; i <= 100; i++) {
            temp2 = func(i);
            double check = temp1 * temp2;
            if (check < 0) {
                double left=i-1;
                double right=i;


                while (right>=left){
                    double mid=(left+right)/2;

                    double res=func(mid);
                    if(res*temp2>0){
                        right=mid;
                    }else if(res*temp2<0){
                        left=mid;
                    }else {//if(res==0)
                        ans.add(mid);
                        break;
                    }
                    if(right-left<0.001){
                        ans.add(mid);
                        break;
                    }
                }


            } else if (check == 0) {
                if (temp1 == 0) {
                    ans.add((double)i-1);
                } else {
                    ans.add((double)i);
                }
            } else {//check>0
            }
            temp1 = temp2;

        }
        Object[] objects = ans.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.printf("%.2f ",objects[i]);
        }
    }

    static double func(double x) {
        return a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * Math.pow(x, 1) + d;
    }

}
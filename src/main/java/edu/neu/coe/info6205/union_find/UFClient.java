package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFClient {
    public static void main(String[] args) {
        for(int n=100;n<=1000;n+=5) {
            System.out.println("The number of sites is：" + n);
            System.out.println("Number of connections:" + count(n));
            System.out.println("done!");
        }

    }
    public static int count(int n){
        int count = 0;
        Random random = new Random();
        UF_HWQUPC uf = new UF_HWQUPC(n);
        while(uf.components()!= 1){
            int site1 = random.nextInt(n);
            int site2 = random.nextInt(n);
            uf.connected(site1,site2);
            count++;
        }
        return count;
    }

}

package com.company;

public class Main
{
    public static void main(String[] args)
    {
        Trainer trainer = new Trainer(3, 1, 1, new int[]{2}, new double[][]{{0, 0, 1}, {0, 1, 1}, {1, 0, 1}, {1, 1, 1}}, new double[][]{{0}, {0}, {0}, {1}});
        trainer.setSeed(0);
        long start = System.currentTimeMillis();
        trainer.teachAllTillLearned(10);
        System.out.println(System.currentTimeMillis() - start);
    }
}
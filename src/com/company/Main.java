package com.company;

public class Main
{
    //for efficiency, the neuralnetwork has been formatted to run optimally with only one output
    //as of now, multiple output backprop has not been fully implemented
    public static void main(String[] args)
    {
        Trainer trainer = new Trainer(2, 1, 1, new int[]{100}, new double[][]{{2, 3}, {4, 5}, {4, 2}}, new double[][]{{6}, {20}, {8}});
        trainer.setSeed(3);
        long start = System.currentTimeMillis();
        trainer.teachAllTillLearned(100);
        System.out.println(System.currentTimeMillis() - start);
    }
}
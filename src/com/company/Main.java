package com.company;

public class Main
{
    //for efficiency, the neuralnetwork has been formatted to run optimally with only one output
    //as of now, multiple output backprop has not been fully implemented
    public static void main(String[] args)
    {
        Trainer trainer = new Trainer(2, 2, 1, new int[]{2}, new double[][]{{1, 1}, {0, 1}, {1, 0}, {0, 0}}, new double[][]{{1, 1}, {0, 1}, {0, 1}, {0, 0}});
        trainer.setSeed(0);
        long start = System.currentTimeMillis();
        trainer.teachAllTillLearned(10000000);
        System.out.println(System.currentTimeMillis() - start);
    }
}
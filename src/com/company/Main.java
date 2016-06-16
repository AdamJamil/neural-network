package com.company;

public class Main
{
    //for efficiency, the neuralnetwork has been formatted to run optimally with only one output
    //as of now, multiple output backprop has not been fully implemented
    public static void main(String[] args)
    {
        Trainer trainer = new Trainer(2, 1, 4, new int[]{12, 10, 10, 2}, new double[][]{{2, 2}, {8, 4}}, new double[][]{{4}, {2}});
        trainer.setSeed(0);
        long start = System.currentTimeMillis();
        trainer.teachAllTillLearned(250);
        System.out.println(System.currentTimeMillis() - start);
    }
}
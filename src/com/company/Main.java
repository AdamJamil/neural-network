package com.company;

public class Main
{
    //for efficiency, the neural network has been formatted to run optimally with only one output
    //as of now, multiple output backprop has not been fully implemented
    public static void main(String[] args)
    {
        double[][] questions = new double[][]{{0, 1, 0}, {4, 0, 0}, {3, 1, 2}, {5, 0, 0}, {0, 1, 0}, {1, 1, 0}, {2, 5, 0}};
        double[][] answers = new double[][]{{13}, {15}, {17}, {18}, {19}, {20}, {21}};
        int[] layerInformation = new int[]{5, 3, 2};
        Trainer trainer = new Trainer(3, 1, 3, layerInformation, questions, answers);
        trainer.setSeed(0);
    }
}
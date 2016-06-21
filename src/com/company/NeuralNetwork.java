package com.company;

import java.util.Random;

class NeuralNetwork
{
    //layer 0 is input[] + bias
    Layer[] layer;
    private double[][][] chain;

    NeuralNetwork(int inputs, int outputs, int layers, int[] nodes)
    {
        layer = new Layer[layers + 2];
        layer[0] = new Layer(inputs);
        layer[layers + 1] = new Layer(outputs);

        for(int i = 1; i < layers + 1; i++)
            layer[i] = new Layer(nodes[i - 1]);

        for(int i = layers; i >= 0; i--)
            layer[i].addNextLayer(layer[i + 1]);

        layer[0].first = true;
        layer[layers + 1].last = true;
        layer[layers + 1].consoleLastLayer();

        chain = new double[layer.length - 1][][];

        for(int i = 0; i < layer.length - 1; i++)
            chain[i] = new double[layer[i].nodes][layer[i + 1].nodes];
    }

    void run(double[] input)
    {
        layer[1].clean();
        layer[0].node = input;
        layer[0].act();
    }

    void computeErrorAndLearn(double relError, int setNumber)
    {
        //relError is difference between output and answer, NOT EPSILON
        for(int i = 0; i < layer[layer.length - 2].nodes; i++)
            chain[layer.length - 2][i][0] = 1;

        //^this has to be changed for multiple outputs
        //v this too i guess
        for(int m = layer.length - 3; m >= 0; m--)
            for(int n = 0; n < layer[m].nodes; n++)
                for(int o = 0; o < layer[m + 1].nodes; o++)
                {
                    double sum = 0;
                    for(int i = 0; i < layer[m + 2].nodes; i++)
                        sum += layer[m + 1].phi[o][i] * chain[m + 1][o][i];
                    chain[m][n][o] = sum;

                    //change = -epsilon * chain
                    double learningParameter = 0.01; //change me!

                    layer[m].weight[n][o] -= learningParameter * relError * layer[m].node[n] * chain[m][n][o];
                }
    }

    void randomize(double min, double max)
    {
        for(int i = 0; i < layer.length - 1; i++)
        {
            layer[i].randomize(min, max);
        }
    }

    void randomize(double min, double max, long seed)
    {
        Random rand = new Random();
        rand.setSeed(seed);
        for(int i = 0; i < layer.length - 1; i++)
            for(int j = 0; j < layer[i].nodes; j++)
                for(int k = 0; k < layer[i].next.nodes; k++)
                    layer[i].weight[j][k] = (rand.nextDouble() * (max - min)) + min;
    }
}

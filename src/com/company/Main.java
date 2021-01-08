package com.company;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        UnaryOperator<Double> sigmoid = x -> 1 / (1 + Math.exp(-x));
        UnaryOperator<Double> dsigmoid = y -> y * (1 - y);
        NeuralNetwork nn = new NeuralNetwork(0.1, sigmoid, dsigmoid, 2, 2, 1);
        for (int i = 0; i < 100000; i++) {
            nn.mathOutputFeedForward(new double[]{1, 1});
            nn.backpropagation(new double[]{0});
            nn.mathOutputFeedForward(new double[]{1, 0});
            nn.backpropagation(new double[]{1});
            nn.mathOutputFeedForward(new double[]{0, 0});
            nn.backpropagation(new double[]{0});
            nn.mathOutputFeedForward(new double[]{0, 1});
            nn.backpropagation(new double[]{1});
        }
        System.out.println(Arrays.toString(nn.mathOutputFeedForward(new double[]{0, 1})));
    }
}

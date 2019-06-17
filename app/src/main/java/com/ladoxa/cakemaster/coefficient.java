package com.ladoxa.cakemaster;

import static java.lang.Math.round;

class coefficient {

    static double count(double a, double b){ //if shape is circle
        return (b*b)/(a*a);
    }

    static double count(double a, double b, double c, double d){ // if shape is rectangle
        return round((a*b)/(d*c));
    }

    static double count(double a, double b, double d){ // if shapes is rectangle and circle
        return (a*b)/(d*d);
    }

}

package com.ladoxa.cakemaster;

import static java.lang.Math.round;

class coefficient {

    static double circles(double a, double b){ //if shape is circle
        return (b*b)/(a*a);
    }

    static double rectangles(double a, double c, double b, double d){ // if shape is rectangle
        return (a*c)/(b*d);
    }

    static double rectCircle(double a, double b, double c){ // if shapes is rectangle and circle
        return (Math.pow(b/2,2)*3.14)/(a*c);
    }

    static double circleRect(double a, double b, double c){ // if shapes is rectangle and circle
        return (a*c)/(Math.pow(b/2,2)*3.14);
    }

}

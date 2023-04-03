import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class LamdaPrac implements myInterface {

    // this is the normal way that you would implement an interface

    @Override
    public void myMethod() {
        System.out.println("This is my method");
    }

    // this is the normal way that you would implement a default method



    public void methodTakesObject(otherInterface i) {
        System.out.println("I know that this dosent need to take anything but it does");

        System.out.println("-------------------------------------------------------------");
    }



    // main method

    public static void main(String[] args) {
        List<Point> pointList = new ArrayList<>();


        LamdaPrac lamdaPrac = new LamdaPrac(); // create an object of the class
        lamdaPrac.myMethod(); // call the method
        lamdaPrac.myDefaultMethod(); // call the default method
        myInterface.myStaticMethod(); // call the static method

        // this is the lambda way of implementing an interface

        myInterface myInt = () -> System.out.println("This is my method!!!!!!"); // set the method
        myInt.myMethod(); // call the method

        // lambda
        // expression
        // we infrence that the method is from the interface because we are using the interface as
        // the type


        // we can then call other methods on that lambda expression

        // the () is used to call the fuctional interface method the one without the body
        // the -> is used to separate the functional interface method from the body

        // if the method had a return type, the java compiler knows that the body of the method is a
        // return statement and will enforce it

        // if the method had a parameter, the java comiler knows that it needs to take a parmeter
        // and will enforce it

        // you can also use a lambda to do multiple lines of code for your method

        parameterInterface parameterInterface = (int x, int y) -> { // set the method
            for (int i = 0; i < 20; i++) {
                pointList.add(new Point(x + i, y - i));
                System.out.println("point made at " + x + ", " + y + " " + i);
            }
        };
        parameterInterface.myMethod(5, 5); // call the method
        // check the list
        System.out.println(pointList);


        // now because these are intefaces we cant actually use these objects that we have create.
        // however objects that implement these interfces are more useful

        // a good example of the usefulness of lambda functions is using java swing

        // lets say we have a button that we want to add an action listener to

        // we can do this with a lambda function


        // lets say a function takes an argument. that argument implements a functional interface.
        // you can pass a lambda function to that argument. the lambda function will be the
        // functionality of the argument
        // eg

        LamdaPrac p = new LamdaPrac();
        p.methodTakesObject(i -> new Point(0, 0));
        // as you can see the method takes an object that implements the otherInterface interface
        // but we can make it do whatever we want by passing in a lambda function
        // the functionality does not need to make scence. it just needs to be an object that
        // implements the interface



        JFrame frame = new JFrame("My Frame1");
        frame.setSize(500, 500);
        JButton button = new JButton("My Button");
        button.addActionListener(e -> System.out.println("Button Clicked"));
        // here we are passing the action listener a lambda function that will print out "Button
        // clicked"
        // we are passing the function to the action listner. the action listner object implements a
        // functional interface
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        // this is a lot cleaner than the normal way of doing it
        // you are passing the action listner an object that is the functionality of the button

        // the old way to do it in comparrison is this: an annonymus inner method. these are one use
        // methods.

        JFrame frame2 = new JFrame("My Frame2");
        frame2.setSize(500, 500);
        JButton button2 = new JButton("My Button");
        button2.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked");
            }
        });

        frame2.add(button2);
        frame2.pack();
        frame2.setVisible(true);
        frame2.setLocationRelativeTo(null);
    }

    // my goal for you is to create a jframe that will spawn a 500x500 window with a start button
    // that opens a new jframe with another 500x 500 window.
    // the second jframe will have a button that will close the window and return you to the first
    // jframe
    // also in the second jframe there will be points that spawn at random locations on the screen
    // the points will be red and will be 10x10 pixels
    // the points will spawn at a rate of 1 per 2 seconds
    // the points on the screen will be removed if you click on them


    // this task will give you a good grasp of using lambda functions to add functionality to action
    // listeners in java swing
}

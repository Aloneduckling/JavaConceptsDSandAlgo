class Parent{
    //object of this class is designed to access the things only in this class and methods of same signature even if they are from other class(overriding)
    //and also the things it inherited
    String content = "Parent";
    public void parentClassMethod(){
        System.out.println("This is the method of "+content);
        //inside of this class and also access the overriden method of the upcasted class
    }
    public void showContent(){
        System.out.println(content);
    }
}

class Child extends Parent{
    //object of this class is designed to access the things only in this class and methods of same signature even if they are from other class(overriding)
    //and also the things it inherited
    String content = "Child";
    public void childClassMethod(){
        System.out.println("This is the method of "+content);
    }
    @Override
    public void showContent() {
        System.out.println(content);
    }
}

public class UpcastingAndDowncasting {
    public static void main(String[] args) {

        Parent p = new Child();
        //accessing the method of child using p ==> should not
        //Testing if p is able to access the methods inside child answer NO==> because p is made to access only the things in its class
//        p.childClassMethod();

        System.out.println(p instanceof Parent);
        System.out.println(p instanceof Child);
        Child c = (Child)p; // this is just like creating new child object
        System.out.println(c.content);
        c.showContent();
        System.out.println(p instanceof Parent);
        System.out.println(p instanceof Child);

        System.out.println(p.content);//Parent


        //upcasting p and then from p generating c which is indirect way of generating object of child
        //HERE==>
        //  p has access to ==> overriden method in child + the methods and variables inside it
        //  my intution
        //  c has access to ==> only child methods and variables
        //  Intution after thinking ==> SAME AS ABOVE
        // Experiment===>
        //  access the vars and methods of child using c and access the vars of child using p;
        //  conclusion 1 ==> p can't access the methods or vars of the child class as it is not made for it
        //  conclusion 2 ==> c can access all the things in parent as it inherits them
        //  conclusion 3 ==> c can access all the things of child class which is obvious as it is made to do so
        //  FINAL RESULTS AND POINTS OF ALL ==>
        //think in terms of BUCKET
        //      1. upcasting does nothing but creates a variable(p) of type Parent which partially refers the child object in memory.(it only saves overridden methods)
        //      2. variable of type Parent means ==> p variable is made in such a way that it can use only and
        //         only store those things which are defined inside its class(and also the things which are inherited).
        //         If p is used for upcasting it just means p has the DNA of Parent and references Child obj with some qualities of child overwritten on its DNA.
        //      3. during upcasting the overriden methods(same method different definition in parent and child) of child
        //         class gets used whenever the respective method is called using p.(because p can call it and p refers child due to upcasting).
        //      4. on downcasting p and assigning to another ref variable of child type we just create another object
        //          of child with same reference as that of p.
        //      5. p is an instance of both child and parent as it is of type parent and gets partially converted to child upon upcasting.


    }

    
}

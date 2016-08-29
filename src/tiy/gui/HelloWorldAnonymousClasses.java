package tiy.gui;

/**
 * Created by jfabiano on 8/29/2016.
 */
public class HelloWorldAnonymousClasses {//file 1

        interface HelloWorld {//file 2
            public void greet();
            public void greetSomeone(String someone);
        }

        public void sayHello() {

//            class EnglishGreeting implements HelloWorld {//only visible in this class' scope//file 3
//                String name = "world";
//                public void greet() {
//                    greetSomeone("world");
//                }
//                public void greetSomeone(String someone) {
//                    name = someone;
//                    System.out.println("Hello " + name);
//                }
//            }
            //HelloWorld englishGreeting = new EnglishGreeting();
            EnglishGreeting englishGreeting = new EnglishGreeting();

//            HelloWorld frenchGreeting = new HelloWorld() {//file 4
//                //do this anonymous class for something you only want to do only once we are assuming we only need this to be defined once(scaling answer).
//                //Think of them as a syntactical short cut
//                String name = "tout le monde";
//                public void greet() {
//                    greetSomeone("tout le monde");
//                }
//                public void greetSomeone(String someone) {
//                    name = someone;
//                    System.out.println("Salut " + name);
//                }
//            };
            FrenchGreeting frenchGreeting = new FrenchGreeting();

//            HelloWorld spanishGreeting = new HelloWorld() {//file 5
//                String name = "mundo";
//                public void greet() {
//                    greetSomeone("mundo");
//                }
//                public void greetSomeone(String someone) {
//                    name = someone;
//                    System.out.println("Hola, " + name);
//                }
//            };
            SpanishGreeting spanishGreeting = new SpanishGreeting();

            englishGreeting.greet();
            frenchGreeting.greetSomeone("Fred");
            spanishGreeting.greet();
        }

        public static void main(String... args) {
            HelloWorldAnonymousClasses myApp =
                    new HelloWorldAnonymousClasses();
            myApp.sayHello();
        }

}

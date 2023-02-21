//sout + tab ==> autocomplete pt system.out.println


class Main {
    //1.Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)
    public static void main (String[] args) {
        System.out.println("Hello, World.");

    //2.Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}
    String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        for (int i = 0; i < languages.length; i++) {
            System.out.println(languages[i] + " ");
        }
    
    //3. Generate a random integer n: int n = (int) (Math.random() * 1_000_000);
    int n = (int) (Math.random() * 1_000_000);
    System.out.println(n);

    //4. Compute the result obtained after performing the following calculations:
    /*
        multiply n by 3;
        add the binary number 10101 to the result;
        add the hexadecimal number FF to the result;
        multiply the result by 6;
     */
    n = n * 3;
    n += Integer.parseInt("10101", 2);
    n += Integer.parseInt("FF", 16);
    n = n * 6;
    System.out.println(n);

    //5.Compute the sum of the digits in the result obtained in the previous step. This is the new result. 
    //While the new result has more than one digit, continue to sum the digits of the result.
    int s = 0;
    int result = n;
    do {
        while(result != 0) {
            s = s + result % 10;
            result = result / 10;
        }
        result = s;
        s = 0;
    }while(result > 9);
        System.out.println(result);

        //6. Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
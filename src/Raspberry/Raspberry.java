package Raspberry;

public class Raspberry {
    static {
        // Load native library raspberry.dll (Windows) or raspberry.so (Unixes) at runtime
        // This library contains all needed native methods
        System.loadLibrary("raspberry");
     }

    public native void forward();
    public native void left();
    public native void back();
    public native void right();
    public native void stop();

    public native Object camera();

    /**
     * Test native calls, by simple printing "Hello world!" in C
     */
    private native void sayHello();

    public static void main(String[] args) {
        new Raspberry().sayHello();
    }
}

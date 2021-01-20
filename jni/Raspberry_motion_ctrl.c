#include <jni.h>                    // JNI header provided by JDK
#include <stdio.h>                  // C Standard IO Header
#include "Raspberry_Raspberry.h"    // Generated
#include <wiringPi.h>               //Wiring Pi Library for GPIO control


#define	L_FWD	22
#define L_REV	23
#define R_FWD	26
#define R_REV	21


// Implementation of the native method sayHello()
JNIEXPORT void JNICALL Java_Raspberry_Raspberry_sayHello (JNIEnv *env, jobject thisObj) {
    printf("Initializing GPIOs\n");
    
    wiringPiSetup () ;
	pinMode(L_FWD, OUTPUT);
	pinMode(L_REV, OUTPUT);
	pinMode(R_FWD, OUTPUT);
	pinMode(R_REV, OUTPUT);
}

// Implementation of the native methods for moving
JNIEXPORT void JNICALL Java_Raspberry_Raspberry_forward (JNIEnv *env , jobject thisObj) {
    printf("Go forward\n");
    
    digitalWrite (L_FWD, HIGH);
    digitalWrite (R_FWD, HIGH);
    digitalWrite (L_REV, LOW);
    digitalWrite (R_REV, LOW);
}
JNIEXPORT void JNICALL Java_Raspberry_Raspberry_left (JNIEnv *env, jobject thisObj) {
    printf("Turn left\n");
    
    digitalWrite (L_FWD, LOW);
    digitalWrite (R_FWD, HIGH);
    digitalWrite (L_REV, HIGH;
    digitalWrite (R_REV, LOW);
}
JNIEXPORT void JNICALL Java_Raspberry_Raspberry_back (JNIEnv *env, jobject thisObj) {
    printf("Go back\n");

    digitalWrite (L_FWD, LOW);
    digitalWrite (R_FWD, LOW);
    digitalWrite (L_REV, HIGH);
    digitalWrite (R_REV, HIGH);
}
JNIEXPORT void JNICALL Java_Raspberry_Raspberry_right (JNIEnv *env, jobject thisObj) {
    printf("Turn right\n");

    digitalWrite (L_FWD, HIGH);
    digitalWrite (R_FWD, LOW);
    digitalWrite (L_REV, LOW);
    digitalWrite (R_REV, HIGH);
}
JNIEXPORT void JNICALL Java_Raspberry_Raspberry_stop (JNIEnv *env, jobject thisObj) {
    printf("STOP!\n");
    
    digitalWrite (L_FWD, LOW);
    digitalWrite (R_FWD, LOW);
    digitalWrite (L_REV, LOW);
    digitalWrite (R_REV, LOW);
}

// Implementation of the native method to retrieve a video stream...
JNIEXPORT jobject JNICALL Java_Raspberry_Raspberry_camera (JNIEnv *env, jobject thisObj) {
    (*env)->ThrowNew(env, (*env)->FindClass(env, "java/io/IOException"), "No camera connected!");
}

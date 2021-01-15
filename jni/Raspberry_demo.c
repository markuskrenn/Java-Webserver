#include <jni.h>                    // JNI header provided by JDK
#include <stdio.h>                  // C Standard IO Header
#include "Raspberry_Raspberry.h"    // Generated

// Implementation of the native method sayHello()
JNIEXPORT void JNICALL Java_Raspberry_Raspberry_sayHello (JNIEnv *env, jobject thisObj) {
    printf("Hello world!\n");
}

// Implementation of the native methods for moving
JNIEXPORT void JNICALL Java_Raspberry_Raspberry_forward (JNIEnv *env , jobject thisObj) {
    printf("Go forward\n");
}
JNIEXPORT void JNICALL Java_Raspberry_Raspberry_left (JNIEnv *env, jobject thisObj) {
    printf("Go left\n");
}
JNIEXPORT void JNICALL Java_Raspberry_Raspberry_back (JNIEnv *env, jobject thisObj) {
    printf("Go back\n");
}
JNIEXPORT void JNICALL Java_Raspberry_Raspberry_right (JNIEnv *env, jobject thisObj) {
    printf("Go right\n");
}
JNIEXPORT void JNICALL Java_Raspberry_Raspberry_stop (JNIEnv *env, jobject thisObj) {
    printf("STOP!\n");
}

// Implementation of the native method to retrieve a video stream...
JNIEXPORT jobject JNICALL Java_Raspberry_Raspberry_camera (JNIEnv *env, jobject thisObj) {
    (*env)->ThrowNew(env, (*env)->FindClass(env, "java/io/IOException"), "No camera connected!");
}

#include <jni.h>
#include <string>

JNIEXPORT jstring JNICALL
Java_com_zf_myapplication_activity_MainActivity_stringFromJNI(JNIEnv *env, jobject instance) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}



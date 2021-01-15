JAVA_HOME=/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home

mac:
	# generate native header files
	javac -h jni src/Raspberry/Raspberry.java

	# generate native library
	gcc -I"${JAVA_HOME}/include" -I"${JAVA_HOME}/include/darwin" -dynamiclib -o jni/libraspberry.dylib jni/Raspberry_demo.c

clean:
	rm jni/Raspberry_Raspberry.h
	rm jni/libraspberry.dylib

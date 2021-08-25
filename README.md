Studio Build: 203.7717.56.2031.7621141
Version of Gradle Plugin: 7.0.1 (default)
Version of Gradle: 7.0.2 (default)
Version of Java: 11.0.12+7 (Zulu)
OS: Ubuntu-20.04

STEPS TO REPRODUCE:
0. Create sample app with NDK support and minimum supported SDK set to 20.
1. Upgrade CMake to 3.21.1 (latest) and NDK to 23.0.7599858 (latest)
2. Verify that `./gradlew build` fails.

Build succeeds with CMake 3.18.1, but there's a lot of warnings from NDK 23, demanding CMake 3.19 or newer.

Build log #1: ```
> Task :app:configureCMakeDebug FAILED
C/C++: debug|arm64-v8a :CMake Error at /usr/local/share/cmake-3.21/Modules/CMakeTestCCompiler.cmake:69 (message):
C/C++: debug|arm64-v8a :  The C compiler
C/C++: debug|arm64-v8a :    "/usr/local/lib/android/sdk/ndk/23.0.7599858/toolchains/llvm/prebuilt/linux-x86_64/bin/clang"
C/C++: debug|arm64-v8a :  is not able to compile a simple test program.
C/C++: debug|arm64-v8a :  It fails with the following output:
C/C++: debug|arm64-v8a :    Change Dir: /home/runner/work/AndroidIssue_MinSdkAutoUpgradeFor64Bits/AndroidIssue_MinSdkAutoUpgradeFor64Bits/app/.cxx/Debug/5j5p4f3u/arm64-v8a/CMakeFiles/CMakeTmp
C/C++: debug|arm64-v8a :
C/C++: debug|arm64-v8a :    Run Build Command(s):/home/runner/.local/bin/ninja cmTC_a2c79 && [1/2] Building C object CMakeFiles/cmTC_a2c79.dir/testCCompiler.c.o
C/C++: debug|arm64-v8a :    [2/2] Linking C executable cmTC_a2c79
C/C++: debug|arm64-v8a :    FAILED: cmTC_a2c79
C/C++: debug|arm64-v8a :    : && /usr/local/lib/android/sdk/ndk/23.0.7599858/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=aarch64-none-linux-android19 --sysroot=/usr/local/lib/android/sdk/ndk/23.0.7599858/toolchains/llvm/prebuilt/linux-x86_64/sysroot -DANDROID -fdata-sections -ffunction-sections -funwind-tables -fstack-protector-strong -no-canonical-prefixes -D_FORTIFY_SOURCE=2 -Wformat -Werror=format-security -fexceptions  -O2 -g -DNDEBUG -Wl,--build-id=sha1 -Wl,--no-rosegment -Wl,--fatal-warnings -Qunused-arguments -Wl,--no-undefined  -Wl,--gc-sections CMakeFiles/cmTC_a2c79.dir/testCCompiler.c.o -o cmTC_a2c79  -latomic -lm && :
C/C++: debug|arm64-v8a :    ld: error: cannot open crtbegin_dynamic.o: No such file or directory
C/C++: debug|arm64-v8a :    ld: error: cannot open crtend_android.o: No such file or directory
C/C++: debug|arm64-v8a :    clang: error: linker command failed with exit code 1 (use -v to see invocation)
C/C++: debug|arm64-v8a :    ninja: build stopped: subcommand failed.
C/C++: debug|arm64-v8a :
C/C++: debug|arm64-v8a :
C/C++: debug|arm64-v8a :
C/C++: debug|arm64-v8a :  CMake will not be able to correctly generate this project.
C/C++: debug|arm64-v8a :Call Stack (most recent call first):
C/C++: debug|arm64-v8a :  CMakeLists.txt:10 (project)
```



cmake_minimum_required(VERSION 3.4.1)


add_library( # Sets the name of the library.
             bsdiff
             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/bspatch.c
             src/main/cpp/bzip2/blocksort.c
             src/main/cpp/bzip2/bzip2.c
             src/main/cpp/bzip2/bzip2recover.c
             src/main/cpp/bzip2/bzlib.c
             src/main/cpp/bzip2/compress.c
             src/main/cpp/bzip2/crctable.c
             src/main/cpp/bzip2/decompress.c
             src/main/cpp/bzip2/dlltest.c
             src/main/cpp/bzip2/buffman.c
             src/main/cpp/bzip2/mk251.c
             src/main/cpp/bzip2/randtable.c
             src/main/cpp/bzip2/spewG.c
             src/main/cpp/bzip2/unzcrash.c)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       bsdiff

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )
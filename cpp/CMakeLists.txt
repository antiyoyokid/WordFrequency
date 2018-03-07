cmake_minimum_required(VERSION 3.5)
project(frequencycount-aishikg2)

set(CMAKE_CXX_STANDARD 11)
add_executable(hello HelloWorld.cpp)
add_executable(FrequencyCounter FrequencyCounter.cpp)
add_executable(tests Tests.cpp)
add_executable(frequencycount_test tests.cpp [any other .cpp files you want to compile with your tests])
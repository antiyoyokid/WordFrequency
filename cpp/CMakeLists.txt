cmake_minimum_required(VERSION 3.5)
project(frequencycount-aishikg2)

set(CMAKE_CXX_STANDARD 11)
add_executable(hello src/HelloWorld.cpp)
add_executable(FrequencyCounter src/FrequencyCounter.cpp)
add_executable(frequency_counter_tests tests/Tests.cpp)
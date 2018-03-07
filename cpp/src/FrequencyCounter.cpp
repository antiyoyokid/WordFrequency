//
// Created by aishi on 3/6/2018.
//

#include <fstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <string>
#include <map>
#include <vector>
#include <functional>
#include <set>

int frequencySorter(std::map<std::string, int> text);

int main() {
    std::string word;
    std::map<std::string, int> allWords;
    //sort out the words so that they are only allowed to have a dash and an apostrophe otherwise, ignore the punctuation
    while (std::cin >> word) {
        for (int i = 0; i < word.size(); i++) {
            if (word[i] != '-' || word[i] != '\'' && !isdigit(word[i]) && ispunct(word[i]))
                word.erase(i, 1);
            i--;
        }
    }
    ++allWords[word];
    frequencySorter(allWords);
    return 0;
}

int frequencySorter(std::map<std::string, int> text) {
    // Declaring the type of Predicate that accepts 2 pairs and return a bool
    typedef std::function<bool(std::pair<std::string, int>, std::pair<std::string, int>)> Comparator;
    // http://thispointer.com/how-to-sort-a-map-by-value-in-c/
    // Defining a lambda function to compare two pairs. It will compare two pairs using second field
    Comparator compFunctor =
            [](std::pair<std::string, int> elem1, std::pair<std::string, int> elem2) {
                return elem1.second < elem2.second;
            };

    // Declaring a set that will store the pairs using above comparision logic
    std::set<std::pair<std::string, int>, Comparator> setOfWords(
            text.begin(), text.end(), compFunctor);

    // Iterate over a set using range base for loop
    // It will display the items in sorted order of values
    for (std::set<std::pair<std::string, int>>::const_iterator i = setOfWords.begin(); i != setOfWords.end(); ++i) {
        std::cout << i->first << " " << i->second << "\n";

    }
}




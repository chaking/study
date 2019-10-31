#include <iostream>

using namespace std;

void printBlank();
void playRound();
void printStatus( int turn );

int firstSum = 99;
int secondSum = 99;
int firstScore = 0;
int secondScore = 0;
int round = 1;
int firstSumArray[10];
int secondSumArray[10];

int FIRST = 0;
int SECOND = 1;

int main ( void ){
    firstSumArray[0] = secondSumArray[0] = 100;

    int i;

    for( i = 0; i < 9; i++ ){
        playRound(); 
        round++;
    }
    return 0;
}

void playRound(){
    int first, second;
    cout << "Insert First Number" << endl;
    cin >> first;
    firstSum -= first;
    firstSumArray[round] = firstSum;
    printBlank();
    if( first > 9 ) cout << "White" << endl;
    else cout << "Black" << endl;
    printStatus( SECOND );
    cout << "Insert Second Number" << endl;
    cin >> second;
    secondSum -= second;
    secondSumArray[round] = secondSum;
    printBlank();
    if( second > 9 ) cout << "White" << endl;
    else cout << "Black" << endl;
    if( first > second ){
        cout << "First Win" << endl;
        firstScore++;
    }
    else if( first < second ){
        cout << "Second Win" << endl;
        secondScore++;
    }
    else cout << "Draw" << endl;
    printStatus( FIRST );
}

string getRange( int score ){
    if( score > 79 ) return "5 (80 ~ 99)";
    else if( score > 59 ) return "4 (60 ~ 79)";
    else if( score > 39 ) return "3 (40 ~ 59)";
    else if( score > 19 ) return "2 (20 ~ 39)";
    else return "1 (0 ~ 19)";
}

void printStatus( int turn ){
    //cout << "First Score : " << firstScore << endl;
    //cout << "Second Score : " << secondScore << endl;
    if( turn == SECOND ) cout << "First Range : " << getRange( firstSumArray[round - 1] ) << " -> " << getRange( firstSumArray[round] ) << endl; 
    else cout << "Second Range : " << getRange( secondSumArray[round - 1] ) << " -> " << getRange( secondSumArray[round] ) << endl; 
}

void printBlank(){
    int LINE = 50;

    for( int i = 0; i < LINE; i++ ){
        cout << endl;
    }
}

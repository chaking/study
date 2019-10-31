#include <iostream>

using namespace std;

void initialize();
void playRound();
void showStatus( int user );
void showScore();
void showResult();
void printBlank();
void setFirstUser( int user );
string getRange( int user );

enum User{
    YMC, HJK
};

enum Turn{
    FIRST, SECOND
};

int score[2];
int sum[2];
int sumLog[11][2];
int log[11][2];
int firstUser, secondUser;
int round = 1;

int main( void ){
    initialize();

    for( int i = 0; i < 9; i++){
        playRound(); 
        round++;
    }

    showResult();

    return 0;
}

void showResult(){
    int i = 0;
    cout << "YMC:" << score[YMC] << " HJK:" << score[HJK] << endl;

    cout << "YMC: ";
    for( i = 0; i < 9; i++ ){
        cout << log[i + 1][YMC] << ' ';
    }
    cout << endl << "HJK: ";
    for( i = 0; i < 9; i++ ){
        cout << log[i + 1][HJK] << ' ';
    }

    cout << endl;
}

void initialize(){
    sum[0] = sum[1] = sumLog[0][0] = sumLog[0][1] = 99;
    char answer;
    cout << "Who are you? If you are HJ press y or Y" << endl;
    cin >> answer;
    if( answer == 'y' ) setFirstUser( HJK );
    else setFirstUser( YMC );
}

void setFirstUser( int user ){
    firstUser = user;
    if( user == YMC ) secondUser = HJK;
    else secondUser = YMC;
}

string getUserName( int user ){
    if( user == YMC ) return "Yeongmin Cha";
    else return "Hyunju Kim";
}

void showBlackOrWhite( int number ){
    if( number > 9 ) cout << "White(10~99)" << endl;
    else cout << "Black(0~9)" << endl;
}

void playRound(){
    int first, second;
    sumLog[round][firstUser] = sumLog[round - 1][firstUser];
    sumLog[round][secondUser] = sumLog[round - 1][secondUser];
    cout << "Round " << round << endl;
    cout << "HJ " << score[HJK] << " : " << score[YMC] << " YM" << endl << endl;
    cout << "Insert Number(" << getUserName( firstUser ) << ")" << endl;
    cin >> first;
    if( sum[firstUser] < first ) first = sum[firstUser];
    log[round][firstUser] = first;
    sum[firstUser] -= first;
    sumLog[round][firstUser] = sum[firstUser];
    printBlank();
    cout << getUserName( firstUser ) << " ";
    showBlackOrWhite( first );
    showStatus( secondUser );
    cout << "Insert Number(" << getUserName( secondUser ) << ")" << endl;
    cin >> second;
    if( sum[secondUser] < second ) second = sum[secondUser];
    log[round][secondUser] = second;
    sum[secondUser] -= second;
    sumLog[round][secondUser] = sum[secondUser];
    printBlank();
    cout << getUserName( secondUser ) << " ";
    showBlackOrWhite( second );
    showStatus( firstUser );
    if( first > second ){
        cout << getUserName( firstUser ) << " Win!!" << endl;
        score[firstUser]++;
        setFirstUser( firstUser );
    }
    else if( first < second ){
        cout << getUserName( secondUser ) << " Win!!" << endl;
        score[secondUser]++;
        setFirstUser( secondUser );
    }
    else cout << "Draw" << endl;
}

void showStatus( int user ){
    int user2 = YMC;
    if( user == YMC ) user = HJK;
    else{
        user = YMC;
        user2 = HJK;
    }
    cout << getUserName( user ) << " Range : ";
    cout << getRange( sumLog[round - 1][user] ) << " -> ";
    cout << getRange( sumLog[round][user] ) << endl;
    cout << getUserName( user2 ) << " Range : ";
    cout << getRange( sumLog[round][user2] ) << endl;
}

void printBlank(){
    int LINE = 50;

    for( int i = 0; i < LINE; i++ ){
        cout << endl;
    }
}

string getRange( int score ){
    if( score > 79 ) return "5 (80 ~ 99)";
    else if( score > 59 ) return "4 (60 ~ 79)";
    else if( score > 39 ) return "3 (40 ~ 59)";
    else if( score > 19 ) return "2 (20 ~ 39)";
    else return "1 (0 ~ 19)";
}



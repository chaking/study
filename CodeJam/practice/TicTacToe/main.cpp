#include <iostream>

using namespace std;

int input();
int process();
int printResult();

char board[4][5];
int result;
enum Result{
    X_WON,
    O_WON,
    DRAW,
    NOT_COMPLETED
};

int main ( void ){
    int i;
    int count;

    cin >> count;

    for( i = 0; i < count; i++ ){
        input();
        process();
        cout << "Case #" << i + 1 << ": ";
        printResult();
    }

    return 0;
}

int input(){
    int i;

    for( i = 0; i < 4; i++ ){
        cin >> board[i];
    }

    return 0;
}

int process(){
    int i, j;
    int countX, countO, countT;
    bool flagOfDot = false;
    result = DRAW;

    for( i = 0; i < 4; i++ ){
        // column
        countX = countO = countT = 0;
        for( j = 0; j < 4; j++ ){
            if( board[i][j] == 'X' ) countX++;
            else if( board[i][j] == 'O' ) countO++;
            else if( board[i][j] == 'T' ) countT++;
            else if( board[i][j] == '.' ){
                flagOfDot = true;
            }
        }
        if( countX + countT == 4 ) result = X_WON;
        if( countO + countT == 4 ) result = O_WON; 

        // row
        countX = countO = countT = 0;
        for( j = 0; j < 4; j++ ){
            if( board[j][i] == 'X' ) countX++;
            else if( board[j][i] == 'O' ) countO++;
            else if( board[j][i] == 'T' ) countT++;
            else if( board[j][i] == '.' ){
                flagOfDot = true;
            }
        }
        if( countX + countT == 4 ) result = X_WON;
        if( countO + countT == 4 ) result = O_WON; 
    }

    countX = countO = countT = 0;
    for( i = 0; i < 4; i++ ){
        if( board[i][i] == 'X' ) countX++;
        else if( board[i][i] == 'O' ) countO++;
        else if( board[i][i] == 'T' ) countT++;
    }
    if( countX + countT == 4 ) result = X_WON;
    if( countO + countT == 4 ) result = O_WON; 

    countX = countO = countT = 0;
    for( i = 0; i < 4; i++ ){
        if( board[i][3 - i] == 'X' ) countX++;
        else if( board[i][3 - i] == 'O' ) countO++;
        else if( board[i][3 - i] == 'T' ) countT++;
    }
    if( countX + countT == 4 ) result = X_WON;
    if( countO + countT == 4 ) result = O_WON; 

    if( result != X_WON && result != O_WON ){
        if( flagOfDot ) result = NOT_COMPLETED; 
        else result = DRAW;
    }

    return 0;
}

int printResult(){
    int i;
    
    if( result == X_WON ) cout << "X won";
    else if( result == O_WON ) cout << "O won";
    else if( result == DRAW ) cout << "Draw";
    else if( result == NOT_COMPLETED ) cout << "Game has not completed";
    else cout << "Can't find Solution!!";

    cout << endl;
    
    return 0;
}

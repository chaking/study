#include <iostream>

using namespace std;

int input();
int process();
int printResult();

int result;
int resultCase;
enum ResultCase{
    FEGLA_WIN,
    OMAR_WIN
};
char array[100][101];
int position[100];
int N;

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
    int i, j;

    cin >> N;
    for( i = 0; i < N; i++ ){
        cin >> array[i];
        position[i] = 0;
    }

    return 0;
}

int process(){
    int i, j;
    result = 0;
    resultCase = FEGLA_WIN;

    char c;
    int min, max;
    int count;
    while( true ){
        c = array[0][position[0]];
        if( c == '\0' ) break;
        min = 101;
        max = -1;
        for( i = 0; i < N; i++ ){
            count = 0;
            while( true ){
                if( c == array[i][position[i]] ){
                    position[i]++;
                    count++; 
                }
                else break;
            }
            if( count < 1 ) return 0;
            else{
                if( count >= max ) max = count;
                if( count <= min ) min = count; 
            }
        }
        //cout << "c:" << c << " min:" << min << " max:" << max << endl;
        result += max - min;
    }

    resultCase = OMAR_WIN;

    return 0;
}

int printResult(){
    int i;
    
    if( resultCase == FEGLA_WIN ) cout << "Fegla Won";
    else cout << result;

    cout << endl;
    
    return 0;
}

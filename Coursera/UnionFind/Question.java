public class Question{
    public void doQuestion3(){
        int i, j;
        final int COUNT = 10;
        int[] array = this.getArray( COUNT );
        int[] size;
        int[][] inputs = {
            {0, 2, 0, 0, 2, 0, 7, 2, 9, 0},
            {5, 9, 5, 9, 0, 5, 5, 9, 9, 0},
            {3, 5, 2, 8, 1, 5, 4, 3, 1, 1},
            {9, 3, 2, 3, 4, 5, 6, 2, 8, 9},
            {6, 6, 3, 6, 6, 1, 7, 9, 6, 1}
        };

        for( i = 0; i < inputs.length - 1; i++ ){
            int[] input = inputs[i];
            boolean flag = true;
            size = this.getArrayByInitValue( COUNT, 1 );
            for( j = 0; j < size.length; j++ ){
                size[j] = this.getSize( input, j );
            }
            for( j = 0; j < input.length; j++ ){
                if( j != input[j] ){
                    if( size[j] > ( size[input[j]] - size[j] ) ){
                        flag = false;
                    }
                }
            }
            System.out.println( flag );
            this.printArray( size );
        }
    }

    private int getSize( int[] array, int index ){
        int sum = 1;
        for( int i = 0; i < array.length; i++ ){
            if( i != index ){
                if( array[i] == index ){
                    sum += getSize( array, i );
                }
            }
        }
        return sum;
    }

    public void doQuestion2(){
        int i;
        final int COUNT = 10;
        int[] array = this.getArray( COUNT );
        int[] size = this.getArrayByInitValue( COUNT, 1 );
        // 5-1 4-7 8-0 4-6 1-8 7-3 2-7 2-9 3-5
        int[][] p_q = {{5, 1}, {4, 7}, {8, 0}, {4, 6}, {1, 8}, {7, 3}, {2, 7}, {2, 9}, {3, 5}};

        for( i = 0; i < p_q.length; i++ ){
            this.unionByWeighted( array, p_q[i], size );
        }

        this.printArray( array );
    }

    private void unionByWeighted( int[] array, int[] p_q, int[] size ){
        int p = p_q[0];
        int q = p_q[1];
        int pRoot = this.getRoot( array, p );
        int qRoot = this.getRoot( array, q );
        if( pRoot != qRoot ){
            if( size[pRoot] < size[qRoot] ){
                array[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
            else{
                array[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }
        }
    }

    private void printArray( int[] array ){
        for( int i = 0; i < array.length; i++ ){
            System.out.print( array[i] );
            System.out.print( ' ' );
        }
        System.out.println();
    }

    private int getRoot( int[] array, int nodeIndex ){
        if( array[nodeIndex] == nodeIndex ){
            return nodeIndex;
        }
        else{
            return this.getRoot( array, array[nodeIndex] );
        }
    }

    public void doQuestion1(){
        int i;
        final int COUNT = 10;
        int[] array = this.getArray( COUNT );
        // 0-7 7-4 6-7 2-7 6-9 3-1
        int[][] p_q = { {0, 7}, {7, 4}, {6, 7}, {2, 7}, {6, 9}, {3, 1} };

        for( i = 0; i < p_q.length; i++ ){
            this.union( array, p_q[i] );
        }

        this.printArray( array );
    }

    private void union( int[] array, int[] p_q ){
        int p = p_q[0];
        int q = p_q[1];

        if( array[p] != array[q] ){
            int target = array[p];
            int value = array[q];

            for( int i = 0; i < array.length; i++ ){
                if( array[i] == target ){
                    array[i] = value;
                }
            }
        }
    }

    private int[] getArray( int count ){
        int[] array = new int[count];

        for (int index = 0; index < count; index++) {
            array[index] = index;
        }

        return array;
    }

    private int[] getArrayByInitValue( int count, int initValue ){
        int[] array = new int[count];

        for( int i = 0; i < count; i++ ){
            array[i] = initValue;
        }
        return array;
    }
}

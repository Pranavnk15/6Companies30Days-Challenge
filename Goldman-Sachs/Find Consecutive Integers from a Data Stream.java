// 2526. Find Consecutive Integers from a Data Stream

// For a stream of integers, implement a data structure that checks if the last k integers parsed in the stream are equal to value.

// Implement the DataStream class:

// DataStream(int value, int k) Initializes the object with an empty integer stream and the two integers value and k.
// boolean consec(int num) Adds num to the stream of integers. Returns true if the last k integers are equal to value, and false otherwise. If there are less than k integers, the condition does not hold true, so returns false.
 

// Example 1:

// Input
// ["DataStream", "consec", "consec", "consec", "consec"]
// [[4, 3], [4], [4], [4], [3]]
// Output
// [null, false, false, true, false]

// Explanation
// DataStream dataStream = new DataStream(4, 3); //value = 4, k = 3 
// dataStream.consec(4); // Only 1 integer is parsed, so returns False. 
// dataStream.consec(4); // Only 2 integers are parsed.
//                       // Since 2 is less than k, returns False. 
// dataStream.consec(4); // The 3 integers parsed are all equal to value, so returns True. 
// dataStream.consec(3); // The last k integers parsed in the stream are [4,4,3].
//                       // Since 3 is not equal to value, it returns False.


// Approach: - INthis we have to contruct a algorithm which takes in a value and k which is 
// frequency. and an function which takes a num, and check whether the num is the same as the entered value
// and has appeared k times before. 
// In this we need to keep track of the last element, and the number of times the last element has occured. 

class DataStream {
    int value;
    int k;
    int lastEle;
    int timesSeen;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;    
    }
    
    public boolean consec(int num) {
        if(lastEle == num){
            timesSeen++;
        } else {
            timesSeen = 1;
        }
        lastEle = num;
        return lastEle == value && timesSeen >= k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
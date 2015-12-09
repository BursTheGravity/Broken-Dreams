//Leo Au-Yeung
//APCS1 pd10
//HW43 -- This or That
//2015-12-07

//skeleton file for class Binary

public class Binary {
	
    private int _decNum;
    private String _binNum;
	
	
    /*=====================================
		default constructor
		pre:  n/a
		post: initializes _decNum to 0, _binNum to "0"
	=====================================*/
    public Binary() { 
		_decNum = 0;
		_binNum = "0";
	}
	
	
    /*=====================================
		overloaded constructor
		pre:  n >= 0
		post: sets _decNum to n, _binNum to equiv string of bits
	=====================================*/
    public Binary( int n ) {
		_decNum = n;
		_binNum = decToBin(_decNum);
	}
	
	
    /*=====================================
		overloaded constructor
		pre:  s is String representing non-negative binary number
		post: sets _binNum to input, _decNum to decimal equiv
	=====================================*/
    public Binary( String s ) {
		_binNum = s;
		_decNum = binToDec(s);
	}
	
	
    /*=====================================
		String toString() -- returns String representation of this Object
		pre:  n/a
		post: returns String of 1's and 0's representing value of this Object
	=====================================*/
    public String toString() { 
		return _binNum;
	}
	
	
    /*=====================================
		String decToBin(int) -- converts base-10 input to binary
		Dec -> Bin conv:
		1. Div decNum by 2, store remainder
		2. Save quotient as new decNum
		3. Repeat 1 & 2 til decNum == 0
		4. Stored remainders constitute binNum
		pre:  n >= 0
		post: returns String of bits
		eg  decToBin(0) -> "0"
		decToBin(1) -> "1"
		decToBin(2) -> "10"
		decToBin(3) -> "11"
		decToBin(14) -> "1110"
	=====================================*/
    public static String decToBin( int n ) {
		String ans = "";
		int quotient = n;
		int remainder;
		while ( !( quotient == 0 )) {
			remainder = quotient % 2;
			quotient = quotient / 2;
			ans = remainder + ans;
		}
		return ans;
	}
	
	
	/*=====================================
		String decToBinR(int) -- converts base-10 input to binary, recursively
		pre:  n >= 0
		post: returns String of bits
		eg  decToBinR(0) -> "0"
		decToBinR(1) -> "1"
		decToBinR(2) -> "10"
		decToBinR(3) -> "11"
		decToBinR(14) -> "1110"
	=====================================*/
	public static String decToBinR( int n ) { 
		String ans = "";
		if (n < 2) {
			ans += n;
		}
		else {
			ans = decToBinR(n / 2) + (n % 2);
		}
		return ans;
	}
	
	
	/*=====================================
		String binToDec(String) -- converts base-10 input to binary
		pre:  s represents non-negative binary number
		post: returns decimal equivalent as int
		eg  
		binToDec("0") -> 0
		binToDec("1") -> 1
		binToDec("10") -> 2
		binToDec("11") -> 3
		binToDec("1110") -> 14
	=====================================*/
	public static int binToDec( String s ) {
		int ans = 0;
		for (int x = s.length(); x > 0 ; x += 1) {
			ans += Math.pow(2, Integer.parseInt(s.substring(x - 1, x)));
		}
		return ans;
	}
	
	
	/*=====================================
		String binToDecR(String) -- converts base-10 input to binary, recursively
		pre:  s represents non-negative binary number
		post: returns decimal equivalent as int
		eg  
		binToDecR("0") -> 0
		binToDecR("1") -> 1
		binToDecR("10") -> 2
		binToDecR("11") -> 3
		binToDecR("1110") -> 14
	=====================================*/
	public static int binToDecR( String s ) { 
		int ans = 0;
		int n = Integer.parseInt(s);
		if (n < 2) {
			ans += n;
		}
		else {
			ans = binToDecR(s.substring(0, s.length() - 1)) + (int) (Math.pow(2, (n % 2)*s.length()));
		}
		return ans;
	}
	
	
	/*=============================================
		boolean equals(Object) -- tells whether 2 Objs are equivalent
		pre:  other is an instance of class Binary
		post: Returns true if this and other are aliases (pointers to same 
		Object), or if this and other represent equal binary values
	=============================================*/
	public boolean equals( Object other ) { 
		return ( this == other || this._binNum.equals( ((Binary)other)._binNum ) );
	}
	
	
	/*=============================================
		int compareTo(Object) -- tells which of two Binary objects is greater
		pre:  other is instance of class Binary
		post: Returns 0 if this Object is equal to the input Object,
		negative integer if this<input, positive integer otherwise
	=============================================*/
	public int compareTo( Object other ) {
		if (this.equals(other)) {
			return 0;
		}
		else if (this._decNum < ((Binary)other)._decNum) {
			return -1;
			}
		else { 
			return 1;
		}
	}
	
	
	//main method for testing
	public static void main( String[] args ) {
		
			System.out.println();
			System.out.println( "Testing ..." );
			
			Binary b1 = new Binary(5);
			Binary b2 = new Binary(5);
			Binary b3 = b1;
			Binary b4 = new Binary(7);
			
			System.out.println( b1 );
			System.out.println( b2 );
			System.out.println( b3 );       
			System.out.println( b4 );       
			
			System.out.println( "\n==..." );
			System.out.println( b1 == b2 ); //should be false
			System.out.println( b1 == b3 ); //should be true
			
			System.out.println( "\n.equals()..." );
			System.out.println( b1.equals(b2) ); //should be true
			System.out.println( b1.equals(b3) ); //should be true
			System.out.println( b3.equals(b1) ); //should be true
			System.out.println( b4.equals(b2) ); //should be false
			System.out.println( b1.equals(b4) ); //should be false

			System.out.println( "\n.compareTo..." );
			System.out.println( b1.compareTo(b2) ); //should be 0
			System.out.println( b1.compareTo(b3) ); //should be 0
			System.out.println( b1.compareTo(b4) ); //should be neg
			System.out.println( b4.compareTo(b1) ); //should be pos
			/*=========================================
		=========================================*/
	}//end main()
	
} //end class

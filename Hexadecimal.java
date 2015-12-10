//Leo Au-Yeung
//APCS1 pd10
//HW43 -- This or That
//2015-12-07

//skeleton file for class Binary

public class Binary {
	
    private int _decNum;
    private String _hexNum;
	private final static String HEXDIGITS = "0123456789ABCDEF"; 
	
    /*=====================================
		default constructor
		pre:  n/a
		post: initializes _decNum to 0, _hexNum to "0"
	=====================================*/
    public Binary() { 
		_decNum = 0;
		_hexNum = "0";
	}
	
	
    /*=====================================
		overloaded constructor
		pre:  n >= 0
		post: sets _decNum to n, _hexNum to equiv string of bits
	=====================================*/
    public Binary( int n ) {
		_decNum = n;
		_hexNum = decToBin(_decNum);
	}
	
	
    /*=====================================
		overloaded constructor
		pre:  s is String representing non-negative hexary number
		post: sets _hexNum to input, _decNum to decimal equiv
	=====================================*/
    public Binary( String s ) {
		_hexNum = s;
		_decNum = hexToDec(s);
	}
	
	
    /*=====================================
		String toString() -- returns String representation of this Object
		pre:  n/a
		post: returns String of 1's and 0's representing value of this Object
	=====================================*/
    public String toString() { 
		return _hexNum;
	}
	
	
    /*=====================================
		String decToBin(int) -- converts base-10 input to hexary
		Dec -> Bin conv:
		1. Div decNum by 2, store remainder
		2. Save quotient as new decNum
		3. Repeat 1 & 2 til decNum == 0
		4. Stored remainders constitute hexNum
		pre:  n >= 0
		post: returns String of bits
		eg  decToBin(0) -> "0"
		decToBin(1) -> "1"
		decToBin(2) -> "10"
		decToBin(3) -> "11"
		decToBin(14) -> "1110"
	=====================================*/
    public static String decToHex( int n ) {
		String ans = "";
		int quotient = n;
		int remainder;
		while ( quotient != 0 ) {
			remainder = quotient % 16;
			quotient = quotient / 16;
			ans = HEXADIGITS.substring(remainder, remainder + 1) + ans;
		}
		return ans;
	}
	
	
	/*=====================================
		String decToBinR(int) -- converts base-10 input to hexary, recursively
		pre:  n >= 0
		post: returns String of bits
		eg  decToBinR(0) -> "0"
		decToBinR(1) -> "1"
		decToBinR(2) -> "10"
		decToBinR(3) -> "11"
		decToBinR(14) -> "1110"
	=====================================*/
	public static String decToHexR( int n ) { 
		String ans = "";
		if (n < 16) {
			ans += HEXDIGITS.substring(n,n+1);
		}
		else {
			ans = decToBinR(n / 16) + HEXDIGITS.substring((n % 16), (n % 16)+1);
		}
		return ans;
	}
	
	
	/*=====================================
		String hexToDec(String) -- converts base-10 input to hexary
		pre:  s represents non-negative hexary number
		post: returns decimal equivalent as int
		eg  
		hexToDec("0") -> 0
		hexToDec("1") -> 1
		hexToDec("10") -> 2
		hexToDec("11") -> 3
		hexToDec("1110") -> 14
	=====================================*/
	public static int hexToDec( String s ) {
		int ans = 0;
		for (int x = s.length(); x > 0 ; x += 1) {
			ans += Math.pow(2, Integer.parseInt(s.substring(x - 1, x)));
		}
		return ans;
	}
	
	
	/*=====================================
		String hexToDecR(String) -- converts base-10 input to hexary, recursively
		pre:  s represents non-negative hexary number
		post: returns decimal equivalent as int
		eg  
		hexToDecR("0") -> 0
		hexToDecR("1") -> 1
		hexToDecR("10") -> 2
		hexToDecR("11") -> 3
		hexToDecR("1110") -> 14
	=====================================*/
	public static int hexToDecR( String s ) { 
		int ans = 0;
		int n = Integer.parseInt(s);
		if (n < 2) {
			ans += n;
		}
		else {
			ans = hexToDecR(s.substring(0, s.length() - 1)) + Math.pow(2, (n % 2)*s.length());
		}
		return ans;
	}
	
	
	/*=============================================
		boolean equals(Object) -- tells whether 2 Objs are equivalent
		pre:  other is an instance of class Binary
		post: Returns true if this and other are aliases (pointers to same 
		Object), or if this and other represent equal hexary values
	=============================================*/
	public boolean equals( Object other ) { 
		return ( this == other || this._hexNum.equals( ((Binary)other)._hexNum ) );
	}
	
	
	public int compareTo( Object o ) {
		if (o instanceof Comparable) {
			if (o instanceof Binary) {
				if( this.getDec() == ((Binary)o).getDec() )
				return 0;
				else if( this.getDec() > ((Binary)o).getDec() )
				return 1;
				else
				return -1;
			}
			else if (o instanceof Hexadecimal) {
				if( this.getDec() == ((Hexadecimal)o).getDec() )
				return 0;
				else if( this.getDec() > ((Hexadecimal)o).getDec() )
				return 1;
				else
				return -1;
			}
			else if (o instanceof Rational) {
				if( this.getDec() == ((Rational)o).floatValue() )
				return 0;
				else if( this.getDec() > ((Rational)o).floatValue() )
				return 1;
				else
				return -1;
			}
			else throw new NullPointerException ("Error! Nothing to compare value to!");
		}
		else throw new ClassCastException ("Error! Not an instance of Comparable!");
	}
	
	public int getDec() {
		return _decNum;
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

//Leo Au-Yeung
//APCS1 pd10
//HW45 -- Come Together
//2015-12-09

/*****************************
	* SKELETON for
	* class SuperArray --  A wrapper class for an array. 
	* Maintains functionality:
	*  access value at index
	*  overwrite value at index
	*  report number of meaningful items
	* Adds functionality to std Java array:
	*  resizability
	*  ability to print meaningfully
	*  add item (at end)
	*  insert item
	*  remove item (while maintaining "left-justification")
*****************************/

public class SuperArray {
	
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;
	
    //position of last meaningful value
    private int _lastPos;
	
    //size of this instance of SuperArray
    private int _size;
	
	
    //~~~~~METHODS~~~~~
    //default constructor initializes 10-item array
    public SuperArray() 
    {
		_data = new Comparable[10];
		_lastPos = -1; //flag to indicate no lastpos yet
		_size = 0;	
	}
	
	
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
		String ans = "[";
		for( int i = 0; i < _size; i++ ) {
			ans += _data[i] + ",";
		}
		//shave off trailing comma
		if ( ans.length() > 1 )
	    ans = ans.substring( 0, ans.length()-1 );
		ans += "]";
		return ans;
	}
	
	
    //double capacity of this SuperArray
    private void expand() 
    { 
		Comparable[] temp = new Comparable[ _data.length * 2 ];
		for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
		_data = temp;
	}
	
    //accessor -- return value at specified index
    public Comparable get( int index ) {
		return _data[index];
	}
	
	
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) 
    { 
		Comparable temp = _data[index];
		_data[index] = newVal;
		return temp;
	}
	
	
    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
		if ( _size == _data.length ) {
			expand(); // make sure _data is large enough for the addition
		}
		set( _lastPos + 1, newVal );
		_lastPos += 1;
		_size += 1;
	}
	
	
    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
		expand();
		for( int i = _lastPos; i >= index; i-- ) {
			_data[i + 1] = _data[i]; // shifts every element one slot to the right from the right
		}
		set( index, newVal );
		_lastPos += 1;
		_size += 1;
	}
	
    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
		for( int i = index; i <= _lastPos; i++ ) {
			_data[i - 1] = _data[i];
		}
		_lastPos -= 1;
		_size -= 1;
	}
	
	
    //return number of meaningful items in _data
    public int size() { return _size; }
	
	//FAZE FINAL
	public int linSearch (Comparable c) {
		for (int x = 0; x < _data.length ; x++) {
			if ( _data[x].equals(c)) {
				return x;
			}
		}
		return -1;
	}
	
	public boolean isSorted() {
		int ctr = 0;
		boolean sort = true;
		while (sort) {
			if ( _data[ctr].compareTo(_data[ctr + 1]) > 0 ) { sort = false; }
			ctr += 1;
		}
		return sort;
	}
	
	//main method for testing
	public static void main( String[] args ) 
	{
		SuperArray batman = new SuperArray();
		System.out.println("Printing empty Comparable batman...");
		System.out.println(batman);
		System.out.println();
		
		//Populates new Comparable batman
		batman.add(new Rational(7,11)); //0
		batman.add(new Hexadecimal("20")); //1
		batman.add(new Binary("100100")); //2
		batman.add(new Binary("10101")); //3
		batman.add(new Hexadecimal("17")); //4
		batman.add(new Rational(80,8)); //5
		batman.add(new Rational(189,3)); //6
		batman.add(new Hexadecimal("6C")); //7
		batman.add(new Binary("111111")); //8
		
		System.out.println("Printing populated Comparable batman...");
		System.out.println(batman);
		System.out.println();
		
		
		//Tests batman's functionality
		System.out.println( batman.isSorted() ); //should be false
		System.out.println( batman.size() ); //should be 9
		System.out.println( batman.linSearch (new Binary("100100")) ); //should be 2
		
		//Tests for compareTo
		System.out.println( batman.get(1).compareTo(batman.get(2))); //should be pos
		System.out.println( batman.get(2).compareTo(batman.get(4))); //should be neg
		System.out.println( batman.get(3).compareTo(batman.get(4))); //should be pos
		System.out.println( batman.get(5).compareTo(batman.get(8))); //should be neg
		System.out.println( batman.get(7).compareTo(batman.get(8))); //should be neg
		
	}//end main
	
}//end class

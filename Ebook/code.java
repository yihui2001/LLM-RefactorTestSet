class Order {
  private eBook _eBook;         
  private int _rDays;              

  public Order(eBook eBook, int rDays) {
    _eBook = eBook;
    _rDays = rDays;
  }

  public int getDays() {
    return _rDays; 
  }

  public eBook geteBook() {
    return _eBook;
  }
}



class Member {
  private String _name;                                
  private Vector _Orders = new Vector();              

  public Member(String name) {
      _name = name;
  }

  public void addOrder(Order arg) {
      _Orders.addElement(arg);
  }

  public String getName() {
      return _name;
  }

  public String printHistory() {
    double OrderSum = 0;                   
    int OrderPoint = 0;    
	String content = "Order Record for " + getName() + "\n";	
    
	Enumeration Orders = _Orders.elements();
	
    while(Orders.hasMoreElements()){ 
      double total = 0;
      Order thisOrder = (Order) Orders.nextElement(); 

	  
	  if(thisOrder.geteBook().getTypeIndex() == eBook.TECH){
		OrderPoint+=7;		
        total += 20;
        if(thisOrder.getDays()>10)
          total += (thisOrder.getDays()-10)*3;
	  }
	  else if(thisOrder.geteBook().getTypeIndex() == eBook.TOP_10){
		  total += 30;
		  OrderPoint+=10;
          if(thisOrder.getDays()>7)
            total += (thisOrder.getDays()-7)*5;
	  }
	  else if(thisOrder.geteBook().getTypeIndex() == eBook.MIND) {
		  total += 15;
		  OrderPoint+=8;
		  if(thisOrder.getDays()>7)
            total += (thisOrder.getDays()-7)*1.5;
	  
	  }
	  
      content += "\t" + thisOrder.geteBook().getbookName() + "\t" +
          String.valueOf(total) + "\n";
      OrderSum += total;
    }

    content += "This member has spent" + String.valueOf(OrderSum) + "\n";
    content += "Point earned: " + String.valueOf(OrderPoint) +
            " points";
    return content;
  }
}

public class eBook {

  private String _bookName;        
  private int _TypeIndex;  
  public static  int MIND = 2;
  public static  int TECH = 0;
  public static  int TOP_10 = 1;

     
  public eBook(String bookName, int TypeIndex){
      _bookName = bookName;
      _TypeIndex = TypeIndex;
  }
  public String getbookName() {
      return _bookName;
  }
   public int getTypeIndex() {
      return _TypeIndex;
  }

  public void setTypeIndex(int arg) {
      _TypeIndex = arg;
  }
   public void changeBookName(string newName) {
	  _bookName = newName;
  }


  
  public static void main(String[] args) {


	  Member m3 = new Member("Cindy");
      Member m4 = new Member("Debby");
      eBook b1 = new eBook("Atomic Habits", eBook.TOP_10);
      eBook b2 = new eBook("ETF Wealth for Millennials", eBook.TECH);
	  Member m2 = new Member("Bella");
      Member m1 = new Member("Amy");
      eBook b3 = new eBook("Object-Oriented Programming from 0 to 1", eBook.TECH);
	  eBook b4 = new eBook("The Courage to Be Disliked", eBook.MIND);
      Order o1 = new Order(b4, 14);
      Order o2 = new Order(b3, 25);
      Order o3 = new Order(b2, 15);
      Order o4 = new Order(b2, 20);
      Order o5 = new Order(b3, 9);
	  Order o6 = new Order(b1, 15);
	  Order o7 = new Order(b1, 23);
	  
      m1.addOrder(o5);
      m1.addOrder(o4);
	  System.out.println(m1.printHistory());
      m2.addOrder(o1);
      m2.addOrder(o2); 
	  System.out.println(m2.printHistory());
      m3.addOrder(o6);
	  System.out.println(m3.printHistory());
      m4.addOrder(o3);
	  m4.addOrder(o7);
      System.out.println(m4.printHistory());
  }
}


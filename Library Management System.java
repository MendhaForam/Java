import java.util.*;
class Library_Management_System{
    final String library_name;
	final String library_address;
	final int library_est;
	
	Library_Management_System(String library_name,String library_address, int library_est){
		this.library_name = library_name;
		this.library_address = library_address;
		this.library_est = library_est;
	}
	
	void displayDetails(){
		System.out.println("----------ABOUT LIBRARY----------");
		System.out.println();
		System.out.println("Name of the library     :  "+library_name);
		System.out.println("Address of the library  :  "+library_address);
		System.out.println("Established in          :  "+library_est);
		System.out.println();
	}
}

class Books{
	String eng_hin_book_1;
	String eng_hin_book_2;
	String eng_hin_book_3;
	
	Books(){}
	
	Books(String eng_hin_book_1, String eng_hin_book_2, String eng_hin_book_3){
		this.eng_hin_book_1 = eng_hin_book_1;
		this.eng_hin_book_2 = eng_hin_book_2;
		this.eng_hin_book_3 = eng_hin_book_3;
	}
	
	void displayDetails(){
		System.out.println("------------BOOKS AVAILABLE IN BOTH ENGLISH AND HINDI------------");
		System.out.println();
		System.out.println("Book 1  :  "+eng_hin_book_1);
		System.out.println("Book 2  :  "+eng_hin_book_2);
		System.out.println("Book 3  :  "+eng_hin_book_3);
		System.out.println();
	}
}

class English_Books extends Books{
	String eng_book_1;
	String eng_book_2;
	String eng_book_3;
	
	English_Books(){}
	
	English_Books(String eng_hin_book_1, String eng_hin_book_2, String eng_hin_book_3, String eng_book_1, String eng_book_2, String eng_book_3){
		super(eng_hin_book_1, eng_hin_book_2, eng_hin_book_3);
		this.eng_book_1 = eng_book_1;
		this.eng_book_2 = eng_book_2;
		this.eng_book_3 = eng_book_3;
	}
	
	void displayDetails(){
		super.displayDetails();
		System.out.println("----------BOOKS AVAILABLE IN ENGLISH----------");
		System.out.println();
		System.out.println("Book 1  :  "+eng_book_1);
		System.out.println("Book 2  :  "+eng_book_2);
		System.out.println("Book 3  :  "+eng_book_3);
		System.out.println();
	}
}

class Hindi_Books extends Books{
	String hin_book_1;
	String hin_book_2;
	String hin_book_3;
	
	Hindi_Books(){};
	
	Hindi_Books(String eng_hin_book_1, String eng_hin_book_2, String eng_hin_book_3, String hin_book_1, String hin_book_2, String hin_book_3){
		super(hin_book_1, hin_book_2, hin_book_3);
		this.hin_book_1 = hin_book_1;
		this.hin_book_2 = hin_book_2;
		this.hin_book_3 = hin_book_3;
	}
	
	void displayDetails(){
		System.out.println("----------BOOKS AVAILABLE IN HINDI----------");
		System.out.println();
		System.out.println("Book 1  :  "+hin_book_1);
		System.out.println("Book 2  :  "+hin_book_2);
		System.out.println("Book 3  :  "+hin_book_3);
		System.out.println();
	}
}

class Library_Member_Info{
	String user_name;
	int user_age;
	long user_phone;
	int member_id;
	int books_borrowed;
	int books_returned;
	Scanner sc = new Scanner(System.in);
	
	Library_Member_Info(){}
	
	void library_member_info(){
		System.out.println("Enter name : ");
		user_name = sc.nextLine();
		System.out.println("Enter age : ");
		user_age = sc.nextInt();
		System.out.println("Enter member id");
		member_id = sc.nextInt();
		books_borrowed = 0;
		System.out.println("Enter phone number : ");
		do{
			user_phone = sc.nextLong();
			String s = Long.toString(user_phone);
			if((s.length()==10) && (s.charAt(0)=='9' || s.charAt(0)=='8' || s.charAt(0)=='7' || s.charAt(0)=='6')){
				return;
			}else{
				System.out.println("Enter valid phone number");
			}
		}while(true);
	}
	
	void display_member_info(){
		System.out.println("User name       :  "+user_name);
		System.out.println("Age             :  "+user_age);
		System.out.println("Member id       :  "+ member_id);
		member_id++;
		System.out.println("Phone number    :  "+user_phone);
	}
	
	void display_member_info1(){
		System.out.println("User name       :  "+user_name);
		System.out.println("Age             :  "+user_age);
		System.out.println("Member id       :  "+member_id);
		System.out.println("Phone number    :  "+user_phone);
		System.out.println("Books borrowed : "+books_borrowed);
	}
}

class Library_Staff_Info{
	String staff_name;
	int staff_id;
	long staff_phone;
	Scanner sc = new Scanner(System.in);
	
	Library_Staff_Info(){}

	void library_staff_info(){
		System.out.println("Enter Name : ");
		staff_name = sc.nextLine();
		System.out.println("Enter staff ID");
		staff_id = sc.nextInt();
		System.out.println("Enter phone number : ");
		do{
			staff_phone = sc.nextLong();
			String s = Long.toString(staff_phone);
			if((s.length()==10) && (s.charAt(0)=='9' || s.charAt(0)=='8' || s.charAt(0)=='7' || s.charAt(0)=='6')){
				return;
			}else{
				System.out.println("Enter valid phone number");
			}
		}while(true);
	}

	void display_staff_info(){
		System.out.println("Staff name    :  "+staff_name);
		System.out.println("Staff Id      :  "+staff_id);
		System.out.println("Phone number  :  "+staff_phone);
	}
}

class Accounts{
	English_Books eb = new English_Books();
	Hindi_Books hb = new Hindi_Books();
	Library_Member_Info lmi = new Library_Member_Info();
	Library_Staff_Info lsi = new Library_Staff_Info();
	Main4 main = new Main4();
	int total_books_borrowed;
	int total_books_returned;
	
	boolean searchBook(String book_to_search){
		if(eb.eng_hin_book_1.equalsIgnoreCase(book_to_search) || eb.eng_hin_book_2.equalsIgnoreCase(book_to_search) || eb.eng_hin_book_3.equalsIgnoreCase(book_to_search) || eb.eng_book_1.equalsIgnoreCase(book_to_search) || eb.eng_book_2.equalsIgnoreCase(book_to_search) || eb.eng_book_3.equalsIgnoreCase(book_to_search) || hb.hin_book_1.equalsIgnoreCase(book_to_search) || hb.hin_book_2.equalsIgnoreCase(book_to_search) || hb.hin_book_3.equalsIgnoreCase(book_to_search)){
			return true;
		}
		else{
			return false;
		}
	}
	
	void member_borrow(int id,Library_Member_Info [] a){
		for (int i = 0; i < a.length; i++) {
			if(a[i].member_id == id){
				if(a[i].books_borrowed > a[i].books_returned + 2){
					System.out.println("Not more than 2 books can be borrowed at a time !");
				}
				else{
					a[i].books_borrowed += 1;
				}
			}
		}
	}
	
	void member_return(int id,Library_Member_Info [] a){
		if(a[id].books_borrowed > 0){
			a[id].books_returned += 1;
			a[id].books_borrowed--;

		} else{
			System.out.println("YOU HAVE NO BOOKS TO RETURN");
		}
		
	}

	boolean member_id_check(int member_id_search,Library_Member_Info [] a){
		for (int i = 0; i < a.length; i++) {
			if (a[i].member_id == member_id_search) {
				return true;
			} 
		}
			return false;
	}
	
	boolean staff_id_check(int staff_id_search,Library_Staff_Info [] a){
		for (int i = 0; i < a.length; i++) {
			if (a[i].staff_id == staff_id_search) {
				return true;
			} 
		}
			return false;
	}
}

class Main{
    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of members to enter");
		int total_members = sc.nextInt();
		System.out.println("Enter the number of staff members to enter");
		int total_staff = sc.nextInt();

		Library_Member_Info m[] = new Library_Member_Info[total_members];
		for (int i = 0; i < m.length; i++) {
			System.out.println("Enter the info of member "+(i+1));
			m[i] = new Library_Member_Info();
			m[i].library_member_info();
			System.out.println();
		}

		Library_Staff_Info s[] = new Library_Staff_Info[total_staff];
		for (int i = 0; i < s.length; i++) {
			System.out.println("Enter the info of staff member "+(i+1));
			s[i] = new Library_Staff_Info();
			s[i].library_staff_info();
			System.out.println();
		}

		for (int i = 0; i < m.length; i++) {
			System.out.println("-----INFO OF MEMBER "+(i+1)+"-----");
			System.out.println();
			m[i].display_member_info();
			System.out.println();
		}

		for (int i = 0; i < s.length; i++) {
			System.out.println("-----INFO OF STAFF MEMBER "+(i+1)+"-----");
			System.out.println();
			s[i].display_staff_info();
			System.out.println();
		}

		Library_Management_System lms = new Library_Management_System("Nice library","Maninagar",1990);
		lms.displayDetails();
		Books b = new Books("FLAMINGO", "VISTAS", "HORNBILL");
		English_Books eb = new English_Books("FLAMINGO", "VISTAS", "HORNBILL","THE POWER", "TGHE MONEY", "HARRY POTTER");
		Hindi_Books hb = new Hindi_Books("FLAMINGO", "VISTAS", "HORNBILL","RAGHUVANSHAM", "RAMAYANA", "MAHABHARAT");
		//Library_Member_Info lmi = new Library_Member_Info();
		//Library_Staff_Info lsi = new Library_Staff_Info();
		Accounts acc = new Accounts();
		eb.displayDetails();
		hb.displayDetails();
		
		System.out.println("Press 1 if you are if you are a member.");
		System.out.println("Press 2 if you are if you are a staff member.");
		int choice = sc.nextInt();
		
		switch(choice){
			case 1 :System.out.println("Enter your id");
					int check_id = sc.nextInt();
					int choice1=0;
					
					do {
						boolean a =acc.member_id_check(check_id,m );
						if (a==true) {
							System.out.println("Press 1 to search book, 2 to borrow book, 3 to return book, 4 to exit");
							choice1 = sc.nextInt();

							switch (choice1) {
								case 1 : System.out.println("Enter book to search");
										 String book_to_search = sc.nextLine();
										 if (acc.searchBook(book_to_search) == true) {
											System.out.println("THIS BOOK IS AVAILABLE");
										 } else {
											System.out.println("SORRY! THIS BOOK IS NOT AVAILABLE");
										 }	
									break;
								
								case 2 : acc.member_borrow(check_id,m);
										 for(int i = 0; i < m.length; i++){
											 if(m[i].member_id == check_id){
												 m[i].display_member_info1();
											 }
										 }
									break;

								case 3 : acc.member_return(check_id,m);
										 for(int i = 0; i < m.length; i++){
											 if(m[i].member_id == check_id){
												 m[i].display_member_info1();
											 }
										 }
									break;
									
								case 4 : System.out.println("THANK YOU!");
								return;

								default: 
									break;
							}
						} else{
							System.out.println("Invalid ID");
						}
					} while (choice1 != 4);
			break;
			
			case 2 : 
					int check_id1;
					 do{
						System.out.println("Enter ID");
						check_id1 = sc.nextInt();
						if(acc.staff_id_check(check_id1,s) == true){
							System.out.println("ID verified");
							break;
						}else{
							System.out.println("Invalid id");
						}
					 }while(acc.staff_id_check(check_id1,s) == false);
					 
			break;
			
			default : System.out.println("Invalid Input");
		}
	}
}
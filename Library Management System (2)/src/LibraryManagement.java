// Project Title : Libraray Management System

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

 class LibraryManagementSystem {
    static Scanner sc = new Scanner(System.in);
    private Hashtable<String, Book> library;
    private Hashtable<String, Book> issuedBook;

    public LibraryManagementSystem() {
        library = new Hashtable<>();
        issuedBook = new Hashtable<>();
    }

    class Book {
        String title;
        String author;
        String Genre;
        int year;
        int price;

        public Book(String title, String author, String Genre, int price, int year) {
            this.title = title;
            this.author = author;
            this.Genre = Genre;
            this.price = price;
            this.year = year;
        }
    }

    void enteredDetails1(){
        Book b1 = new Book("JAVA","HDS","Education",450,2004);
        Book b2 = new Book("MATHS","PVS","Education",650,2002);
        Book b3 = new Book("DS","JJS","Education",380,2008);
        Book b4 = new Book("DBMS","MDT","Education",449,2011);
        Book b5 = new Book("FEE","VHP","Education",280,2015);

        library.put("JAVA",b1);
        library.put("MATHS",b2);
        library.put("DS",b3);
        library.put("DBMS",b4);
        library.put("FEE",b5);

        issuedBook.put("MATHS",b2);
        issuedBook.put("DBMS",b4);

    }

    
    void addBook() {
        sc.nextLine();
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter Genre: ");
        String Genre = sc.nextLine();
        System.out.print("Enter Price: ");
        int price = sc.nextInt();
        System.out.print("Enter year of publication: ");
        int year = sc.nextInt();
        Book book = new Book(title, author, Genre,price, year);
        library.put(title, book);
        System.out.println("Book added successfully!");
    }

    void issueBook(){
        String title,author,Genre;
        int year,price;
        sc.nextLine();
        System.out.print("Enter book title you want to issue: ");
        title = sc.nextLine();
        if(library.containsKey(title)){
            System.out.print("Enter author: ");
            author = sc.nextLine();
            System.out.print("Enter Genre: ");
            Genre = sc.nextLine();
            System.out.print("Enter Price: ");
            price = sc.nextInt();
            System.out.print("Enter year of publication: ");
            year = sc.nextInt();
            Book book = new Book(title, author, Genre,price, year);
            issuedBook.put(title, book);
            System.out.println("Book issued successfully");
        }
        else{
            System.out.println("Book with entered book title is not availabe in the library");
        }
        
    }

    void returnBook(){
        sc.nextLine();
        System.out.print("Enter book title to return: ");
        String title = sc.nextLine();

        if(issuedBook.containsKey(title)){
            issuedBook.remove(title);
            System.out.println("Book returned successfully");
        }
        else{
            System.out.println("Book with entered title is not issued");
        }
    }

    void removeBook() {
        sc.nextLine();
        System.out.print("Enter book title to remove: ");
        String title = sc.nextLine();

        if (library.containsKey(title)) {
            library.remove(title);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    void searchBook() {
        sc.nextLine();
        System.out.print("Enter book title to search: ");
        String title = sc.nextLine();

        if (library.containsKey(title)) {
            Book book = library.get(title);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("Genre: " + book.Genre);
            System.out.println("Price: "+book.price);
            System.out.println("Year of Publication: " + book.year);
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    void listAllBooks() {
        sc.nextLine();
        if (library.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Listing all books in the library:");
            Set<String> titles = library.keySet();
            for (String title : titles) {
                Book book = library.get(title);
                System.out.println("--------------------------------------------------");
                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("Genre: " + book.Genre);
                System.out.println("Price: "+book.price);
                System.out.println("Year of Publication: " + book.year);
                System.out.println("--------------------------------------------------");
            }
        }
    }

    void listAllIssuedBooks(){
        sc.nextLine();
        if(issuedBook.isEmpty()){
            System.out.println("No books issued");
        }
        else{
            System.out.println("Listing all issued books from the library:");
            Set<String> titles = issuedBook.keySet();
            for (String title : titles) {
                Book book = issuedBook.get(title);
                System.out.println("---------------------------------------------------");
                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("Genre: " + book.Genre);
                System.out.println("Price: "+book.price);
                System.out.println("Year of Publication: " + book.year);
                System.out.println("---------------------------------------------------");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/LMS";
        String userName = "root";
        String password = "";
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(URL, userName, password);
        
        LibraryManagementSystem lms = new LibraryManagementSystem();
        
        int choice;
        int choice1,choice2,choice3,choice4;
        do{
            System.out.println();
            System.out.println("|-------------------------------------------------------------------------|");
            System.out.println("| WELCOME TO LIBRARY MANAGEMENT SYSTEM                                    |");
            System.out.println("|-------------------------------------------------------------------------|");
            System.out.println("| Press 1 to continue the program with concept of Collections             |");
            System.out.println("| Press 2 to continue the program with concept of JDBC                    |");
            System.out.println("| Press 3 to Exit                                                         |");
            System.out.println("|_________________________________________________________________________|");
            System.out.println();
            choice = sc.nextInt();

            switch(choice){

                case 1:
                    System.out.println();
                    System.out.println("Continuing the program with the concept of Collections");
                    do{
                        System.out.println();
                        System.out.println("|-------------------------------------------------------------|");
                        System.out.println("| Choose from the following operations                        |");
                        System.out.println("|-------------------------------------------------------------|");
                        System.out.println("| Press 1 to Add a book                                       |");
                        System.out.println("| Press 2 to Remove a book                                    |");
                        System.out.println("| Press 3 to Issue a book                                     |");
                        System.out.println("| Press 4 to Return a book                                    |");
                        System.out.println("| Press 5 to Search for a book                                |");
                        System.out.println("| Press 6 to List all books                                   |");
                        System.out.println("| Press 7 to List all issued books                            |");
                        System.out.println("| Press 8 to Exit                                             |");
                        System.out.println("|-------------------------------------------------------------|");
                        System.out.println();
                        choice1 = sc.nextInt();
                        lms.enteredDetails1();
                        switch(choice1){

                            case 1:
                            lms.addBook();
                            break;

                            case 2:
                            lms.removeBook();
                            break;

                            case 3:
                            lms.issueBook();
                            break;

                            case 4:
                            lms.returnBook();
                            break;

                            case 5:
                            lms.searchBook();
                            break;

                            case 6:
                            lms.listAllBooks();
                            break;

                            case 7:
                            lms.listAllIssuedBooks();
                            break;

                            case 8:
                            System.out.println("Exiting the system");
                            break;

                            default:
                            System.out.println("Choose from the given operations");
                            break;
                        }
                    }while(choice1 != 8);
                    break;

                case 2:

                    Statement st = con.createStatement();
                    

                    String s2 = "insert into book values (1,'JAVA','DJU',1998,560,'Education')";
                    String s3 = "insert into book values (2,'MATHS','PVS',1995,799,'Education')";
                    String s4 = "insert into book values (3,'DBMS','MDT',2011,450,'Education')";
                    String s5 = "insert into book values (4,'DS','JJS',2008,649,'Education')";
                    String s6 = "insert into book values (5,'FEE','DRS',2014,300,'Education')";
                    st.executeUpdate(s2);
                    st.executeUpdate(s3);
                    st.executeUpdate(s4);
                    st.executeUpdate(s5);
                    st.executeUpdate(s6);

                    String s7 = "insert into issued_books values (3,'DBMS','MDT',2011,450,'Education')";
                    String s8 = "insert into issued_books values (5,'FEE','DRS',2014,300,'Education')";
                    st.executeUpdate(s7);
                    st.executeUpdate(s8);

                    System.out.println();
                    System.out.println("Continuing the program with the concept of JDBC");
                    if(con!= null){
                        System.out.println("Connection Established Successfully");
                    }
                    else{
                        System.out.println("Connection Failed");
                    }
                    String userPassword = "LMS123";

                    do{
                        System.out.println();
                        System.out.println("|-------------------------------------------------------------|");
                        System.out.println("| Choose from the following operations                        |");
                        System.out.println("|-------------------------------------------------------------|");
                        System.out.println("| Press 1 for Admin                                           |");
                        System.out.println("| Press 2 for User                                            |");
                        System.out.println("| Press 3 to Exit                                             |");
                        System.out.println("|-------------------------------------------------------------|");
                        System.out.println();
                        choice2 = sc.nextInt();

                        switch(choice2){

                            case 1:
                            System.out.println();
                            System.out.println("|-------------------------------------------------------------|");
                            System.out.println("| Choose from the following operations                        |");
                            System.out.println("|-------------------------------------------------------------|");
                            System.out.println("| Press 1 if you are already an admin                         |");
                            System.out.println("| Press 2 if you are a new admin                              |");
                            System.out.println("|-------------------------------------------------------------|");
                            System.out.println();
                            int ans = sc.nextInt();
                            if(ans == 1){
                                System.out.println();
                                System.out.println("Admin access given");
                            }
                            else{
                                sc.nextLine();
                                System.out.println("Enter your Id");
                                int Admin_Id = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Enter your Name");
                                String Admin_Name = sc.nextLine();
                                for(int i=1;i<=3;i++){
                                    System.out.println("Enter Password");
                                    String upassword = sc.next();
                                    if(upassword.equalsIgnoreCase(userPassword)){
                                        String sql = "insert into Admin values (?,'"+Admin_Name+"','"+upassword+"')";
                                        PreparedStatement pst = con.prepareStatement(sql);
                                        pst.setInt(1, Admin_Id);
                                        int r = pst.executeUpdate();
                                        if(r>0){
                                            System.out.println("Admin added successfully");
                                        }
                                        else{
                                            System.out.println("Failed");
                                        }
                                        break;
                                    }
                                    else{
                                        System.out.println("Invalid password");
                                        if(i==3){
                                        break;
                                        }
                                        System.out.println("Try Again");
                                    }
                                }
                                
                            }   

                            do{
                                System.out.println();
                                System.out.println("|-------------------------------------------------------------|");
                                System.out.println("| Choose from the following operations                        |");
                                System.out.println("|-------------------------------------------------------------|");
                                System.out.println("| Press 1 to view Admin Details                               |");
                                System.out.println("| Press 2 to view User Details                                |");
                                System.out.println("| Press 3 to view Book List                                   |");
                                System.out.println("| Press 4 to add a new Book in the store                      |");
                                System.out.println("| press 5 to remove a book from the store                     |");
                                System.out.println("| Press 6 to add new User                                     |");
                                System.out.println("| Press 7 to remove the User                                  |");
                                System.out.println("| Press 8 to view Issued Books                                |");
                                System.out.println("| Press 9 to Exit                                             |");
                                System.out.println("|-------------------------------------------------------------|");
                                System.out.println();
                                choice3 = sc.nextInt();

                                switch(choice3){

                                    case 1:
                                    sc.nextLine();
                                    String sql1 = "select * from Admin";
                                    PreparedStatement pst = con.prepareStatement(sql1);
                                    ResultSet rs = pst.executeQuery();
                                    while(rs.next()){
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("Admin Id : "+rs.getInt(1));
                                        System.out.println("Admin Name : "+rs.getString(2));
                                        System.out.println("Admin Password : "+rs.getString(3));
                                        System.out.println("------------------------------------------------");
                                    }
                                    break;

                                    case 2:
                                    sc.nextLine();
                                    String sql2 = "select * from User";
                                    PreparedStatement pst1 = con.prepareStatement(sql2);
                                    ResultSet rs1 = pst1.executeQuery();
                                    while(rs1.next()){
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("User Id : "+rs1.getInt(1));
                                        System.out.println("User Name : "+rs1.getString(2));
                                        System.out.println("User Age : "+rs1.getInt(3));
                                        System.out.println("User Contact : "+rs1.getLong(4));
                                        System.out.println("-----------------------------------------------");
                                    }
                                    break;

                                    case 3:
                                    sc.nextLine();
                                    String sql3 = "select * from Book";
                                    PreparedStatement pst2 = con.prepareStatement(sql3);
                                    ResultSet rs2 = pst2.executeQuery();
                                    while(rs2.next()){
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("Book Id : "+rs2.getInt(1));
                                        System.out.println("Book Name : "+rs2.getString(2));
                                        System.out.println("Book Author Name : "+rs2.getString(3));
                                        System.out.println("Book Publish Year : "+rs2.getInt(4));
                                        System.out.println("Book Price : "+rs2.getInt(5));
                                        System.out.println("Book Genre : "+rs2.getString(6));
                                        System.out.println("-----------------------------------------------");
                                    }
                                    break;

                                    case 4:
                                    sc.nextLine();
                                    String sql4 = "insert into Book values (?,?,?,?,?,?)";
                                    PreparedStatement pst3 = con.prepareStatement(sql4);
                                    System.out.println("Enter Book Id");
                                    pst3.setInt(1, sc.nextInt());
                                    sc.nextLine();
                                    System.out.println("Enter Book Name");
                                    pst3.setString(2,sc.nextLine());
                                    System.out.println("Enter Author Name");
                                    pst3.setString(3, sc.nextLine());
                                    System.out.println("Enter publish year");
                                    pst3.setInt(4, sc.nextInt());
                                    System.out.println("Enter Book Price");
                                    pst3.setInt(5, sc.nextInt());
                                    sc.nextLine();
                                    System.out.println("Enter Book Type");
                                    pst3.setString(6, sc.nextLine());
                                    int r = pst3.executeUpdate();
                                    if(r>0){
                                        System.out.println("Book added successfully");
                                    }
                                    else{
                                        System.out.println("Failed");
                                    }
                                    break;

                                    case 5:
                                    sc.nextLine();
                                    String sql5 = "delete from Book where Book_id = ?";
                                    PreparedStatement pst4 = con.prepareStatement(sql5);
                                    System.out.println("Enter Book Id which you want to remove");
                                    pst4.setInt(1, sc.nextInt());
                                    int r1 = pst4.executeUpdate();
                                    if(r1>0){
                                        System.out.println("Book removed successfully");
                                    }
                                    else{
                                        System.out.println("Failed");
                                    }
                                    break;

                                    case 6:
                                    sc.nextLine();
                                    String sql6 = "insert into User values (?,?,?,?)";
                                    PreparedStatement pst5 = con.prepareStatement(sql6);
                                    System.out.println("Enter User Id");
                                    pst5.setInt(1, sc.nextInt());
                                    sc.nextLine();
                                    System.out.println("Enter User Name");
                                    pst5.setString(2, sc.nextLine());
                                    System.out.println("Enter User Age");
                                    pst5.setInt(3, sc.nextInt());
                                    System.out.println("Enter User Contact");
                                    long phoneno = sc.nextLong();
                                    Long phone = phoneno;
                                    while(phone.toString().length() != 10 || !((phone.toString().charAt(0) == '9' || phone.toString().charAt(0) == '8'
                                        || phone.toString().charAt(0) == '7' || phone.toString().charAt(0) == '6'))){
                                        System.out.println("Enter valid contact number");
                                        phoneno = sc.nextLong();
                                        phone = phoneno;
                                    }
                                    pst5.setLong(4, phone);
                                    int r2 = pst5.executeUpdate();
                                    if(r2>0){
                                        System.out.println("User Added Successfully");
                                    }
                                    else{
                                        System.out.println("Failed");
                                    }
                                    break;

                                    case 7:
                                    sc.nextLine();
                                    String sql7 = "delete from User where User_Id = ?";
                                    PreparedStatement pst6 = con.prepareStatement(sql7);
                                    System.out.println("Enter User Id");
                                    pst6.setInt(1, sc.nextInt());
                                    int r3 = pst6.executeUpdate();
                                    if(r3>0){
                                        System.out.println("User removed successfully");
                                    }
                                    else{
                                        System.out.println("Failed");
                                    }
                                    break;

                                    case 8:
                                    sc.nextLine();
                                    String sql8 = "select * from issued_books";
                                    PreparedStatement pst7 = con.prepareStatement(sql8);
                                    ResultSet rs7 = pst7.executeQuery();
                                    while(rs7.next()){
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("Book Id : "+rs7.getInt(1));
                                        System.out.println("Book Name : "+rs7.getString(2));
                                        System.out.println("Book Author Name : "+rs7.getString(3));
                                        System.out.println("Book Publish Year : "+rs7.getInt(4));
                                        System.out.println("Book Price : "+rs7.getInt(5));
                                        System.out.println("Book Genre : "+rs7.getString(6));
                                        System.out.println("-----------------------------------------------");
                                    }
                                    break;

                                    case 9:
                                    sc.nextLine();
                                    System.out.println("Exiting the system");
                                    break;

                                    default:
                                    sc.nextLine();
                                    System.out.println("Enter from the given choices");
                                    break;

                                }
                            }while(choice3 != 9);
                            break;

                            case 2:
                            System.out.println();
                            System.out.println("|-------------------------------------------------------------|");
                            System.out.println("| Choose from the following operations                        |");
                            System.out.println("|-------------------------------------------------------------|");
                            System.out.println("| Press 1 if you are alread a user                            |");
                            System.out.println("| Press 2 if you are new user                                 |");
                            System.out.println("|-------------------------------------------------------------|");
                            System.out.println();
                            int ch = sc.nextInt();
                            if(ch == 1){
                                System.out.println();
                                System.out.println("User login done successfully");
                            }
                            else{
                                System.out.println("Enter your Id");
                                int uid = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Enter your Name");
                                String uname = sc.nextLine();
                                System.out.println("Enter your Age");
                                int uage = sc.nextInt();
                                System.out.println("Enter your contact"); 
                                long phoneno = sc.nextLong();
                                    Long phone = phoneno;
                                    while(phone.toString().length() != 10 || !((phone.toString().charAt(0) == '9' || phone.toString().charAt(0) == '8'
                                        || phone.toString().charAt(0) == '7' || phone.toString().charAt(0) == '6'))){
                                        System.out.println("Enter valid contact number");
                                        phoneno = sc.nextLong();
                                        phone = phoneno;
                                    }
                                String sql = "insert into User values (?,?,?,?) ";
                                PreparedStatement pst = con.prepareStatement(sql);
                                pst.setInt(1, uid);
                                pst.setString(2, uname);
                                pst.setInt(3, uage);
                                pst.setLong(4, phone);
                                int r = pst.executeUpdate();
                                if(r>0){
                                    System.out.println();
                                    System.out.println("You are added to User");
                                }
                                else{
                                    System.out.println("You are not added to User");
                                }
                            }
                            do{
                                System.out.println();
                                System.out.println("|-------------------------------------------------------------|");
                                System.out.println("| Choose from the following operations                        |");
                                System.out.println("|-------------------------------------------------------------|");
                                System.out.println("| Press 1 to view Books                                       |");
                                System.out.println("| Press 2 to view Issued Books                                |");
                                System.out.println("| Press 3 to issue Book                                       |");
                                System.out.println("| Press 4 to return Book                                      |");
                                System.out.println("| Press 5 to Search Book                                      |");
                                System.out.println("| Press 6 to Exit                                             |");
                                System.out.println("|-------------------------------------------------------------|");
                                System.out.println();
                                choice4 = sc.nextInt();

                                switch(choice4){

                                    case 1:
                                    sc.nextLine();
                                    String sql1 = "select * from Book";
                                    PreparedStatement pst1 = con.prepareStatement(sql1);
                                    ResultSet rs1 = pst1.executeQuery();
                                   // while(rs1.next()){
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("Book Id : "+rs1.getInt(1));
                                        System.out.println("Book Name : "+rs1.getString(2));
                                        System.out.println("Book Author Name : "+rs1.getString(3));
                                        System.out.println("Book Publish Year : "+rs1.getInt(4));
                                        System.out.println("Book Price : "+rs1.getInt(5));
                                        System.out.println("Book Genre : "+rs1.getString(6));
                                        System.out.println("-----------------------------------------------");
                                   // }
                                    break;

                                    case 2:
                                    sc.nextLine();
                                    String sql = "select * from issued_books";
                                    PreparedStatement pst = con.prepareStatement(sql);
                                    ResultSet rs = pst.executeQuery();
                                    while(rs.next()){
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("Book Id : "+rs.getInt(1));
                                        System.out.println("Book Name : "+rs.getString(2));
                                        System.out.println("Book Author Name : "+rs.getString(3));
                                        System.out.println("Book Publish Year : "+rs.getInt(4));
                                        System.out.println("Book Price : "+rs.getInt(5));
                                        System.out.println("Book Genre : "+rs.getString(6));
                                        System.out.println("-----------------------------------------------");
                                    }
                                    break;

                                    case 3:
                                    sc.nextLine();
                                    System.out.println("Enter Book Id which you want to Issue");
                                    int bid = sc.nextInt();
                                    String sql2 = "select * from Book where Book_Id = ?";
                                    PreparedStatement pst2 = con.prepareStatement(sql2);
                                    pst2.setInt(1,bid);
                                    ResultSet rs2 = pst2.executeQuery();
                                    if(rs2.next()){
                                        int id = rs2.getInt(1);
                                        String name = rs2.getString(2);
                                        String author = rs2.getString(3);
                                        int publish_year = rs2.getInt(4);
                                        int price = rs2.getInt(5);
                                        String genre = rs2.getString(6);

                                        String sql4 = "insert into issued_Books values (?,?,?,?,?,?)";
                                        PreparedStatement pst4 = con.prepareStatement(sql4);
                                        pst4.setInt(1, id);
                                        pst4.setString(2, name);
                                        pst4.setString(3, author);
                                        pst4.setInt(4, publish_year);
                                        pst4.setInt(5, price);
                                        pst4.setString(6, genre);
                                        int r = pst4.executeUpdate();
                                        if(r>0){
                                            System.out.println("Book Issued Successfully");
                                        }
                                        else{
                                            System.out.println("Book you want to issue is not available");
                                        }
                                    }
                                    break;
                                    
                                    case 4:
                                    sc.nextLine();
                                    System.out.println("Enter Book Id which you want to Return");
                                    int bid1 = sc.nextInt();
                                    String sql3 = "select * from Book where Book_Id = ?";
                                    PreparedStatement pst3 = con.prepareStatement(sql3);
                                    pst3.setInt(1,bid1);
                                    ResultSet rs3 = pst3.executeQuery();
                                    if(rs3.next()){
                                        int id = rs3.getInt(1);
                                        
                                        String sql4 = "delete from issued_Books where Book_Id = ?";
                                        PreparedStatement pst4 = con.prepareStatement(sql4);
                                        pst4.setInt(1, id);
                                        int r = pst4.executeUpdate();
                                        if(r>0){
                                            System.out.println("Book Returned Successfully");
                                        }
                                        else{
                                            System.out.println("Book you want to return has not been issued");
                                        }
                                    }
                                    break;


                                    case 5:
                                    sc.nextLine();
                                    do{
                                        System.out.println();
                                        System.out.println("|-------------------------------------------------------------|");
                                        System.out.println("| Choose from the following operations                        |");
                                        System.out.println("|-------------------------------------------------------------|");
                                        System.out.println("| Press 1 to Search by Book Id                                |");
                                        System.out.println("| Press 2 to Search by Book Title                             |");
                                        System.out.println("| Press 3 to Search by Book Author                            |");
                                        System.out.println("| Press 4 to Exit                                             |");
                                        System.out.println("|-------------------------------------------------------------|");
                                        System.out.println();
                                        ch = sc.nextInt();

                                        switch(ch){

                                            case 1:
                                            sc.nextLine();
                                            System.out.println("Enter id of book you want to search");
                                            int id = sc.nextInt();
                                            String sql5 = "SELECT * FROM book  WHERE Book_Id = ?";
                                            PreparedStatement pst5 = con.prepareStatement(sql5);
                                            pst5.setInt(1, id);
                                            ResultSet rs5 = pst5.executeQuery();
                                            if(rs5.next()) {
                                                System.out.println("-----------------------------------------------------");
                                                System.out.println("Book Id : " + rs5.getInt(1));
                                                System.out.println("Book Name : " + rs5.getString(2));
                                                System.out.println("Book Author : " + rs5.getString(3));
                                                System.out.println("Publish Year : " + rs5.getInt(4));
                                                System.out.println("Price : " + rs5.getInt(5));
                                                System.out.println("Book Genre" + rs5.getString(6));
                                                System.out.println("-----------------------------------------------------");
                                            }
                                            else{
                                                System.out.println("Book with entered book id is not present in the library");
                                            }
                                            break;

                                            case 2:
                                            sc.nextLine();
                                            System.out.println("Enter name of the book you want to search");
                                            sc.nextLine();
                                            String name = sc.nextLine();
                                            String sql6 = "SELECT * FROM  book  WHERE Book_Name = ?";
                                            PreparedStatement pst6 = con.prepareStatement(sql6);
                                            pst6.setString(1, name);
                                            ResultSet rs6 = pst6.executeQuery();
                                            if(rs6.next()) {
                                                System.out.println("-----------------------------------------------------");
                                                System.out.println("Book Id : " + rs6.getInt(1));
                                                System.out.println("Book Name : " + rs6.getString(2));
                                                System.out.println("Book Author : " + rs6.getString(3));
                                                System.out.println("Publish Year : " + rs6.getInt(4));
                                                System.out.println("Price : " + rs6.getInt(5));
                                                System.out.println("Book Genre" + rs6.getString(6));
                                                System.out.println("-----------------------------------------------------");
                                            }
                                            else{
                                                System.out.println("Book with entered book title is not present in the library");
                                            }
                                            break;

                                            case 3:
                                            sc.nextLine();
                                            System.out.println("Enter author name of the book you want to search");
                                            sc.nextLine();
                                            String author = sc.nextLine();
                                            String sql7 = "SELECT * FROM  book  WHERE Author_Name = ?";
                                            PreparedStatement pst7 = con.prepareStatement(sql7);
                                            pst7.setString(1, author);
                                            ResultSet rs7 = pst7.executeQuery();
                                            if(rs7.next()) {
                                                System.out.println("-----------------------------------------------------");
                                                System.out.println("Book Id : " + rs7.getInt(1));
                                                System.out.println("Book Name : " + rs7.getString(2));
                                                System.out.println("Book Author : " + rs7.getString(3));
                                                System.out.println("Publish Year : " + rs7.getInt(4));
                                                System.out.println("Price : " + rs7.getInt(5));
                                                System.out.println("Book Genre" + rs7.getString(6));
                                                System.out.println("-----------------------------------------------------");
                                            }
                                            else{
                                                System.out.println("Book with entered author name is not present in the library");
                                            }
                                            break;

                                            case 4:
                                            sc.nextLine();
                                            System.out.println("Exiting the Serach Operation");
                                            break;

                                            default:
                                            sc.nextLine();
                                            System.out.println("Choose from the given Operations");
                                            break;
                                        }
                                    }while(ch != 4);
                                    case 6:
                                    sc.nextLine();
                                    System.out.println("Exiting the system as a User");
                                    break;

                                    default:
                                    sc.nextLine();
                                    System.out.println("Enter from the given choices");
                                    break;

                                }
                            }while(choice4 != 6);
                            break;

                            case 3:
                            sc.nextLine();
                            System.out.println("Exiting the system as an Admin");
                            break;

                            default:
                            sc.nextLine();
                            System.out.println("Enter from the given choices");
                            break;
                        }
                    }while(choice2 != 3);
                    break;

                case 3:
                sc.nextLine();
                System.out.println("Exiting the system");
                break;

                default:
                sc.nextLine();
                System.out.println("Enter from the given choices");
                break;
            }
        }while(choice != 3);
    }
}    
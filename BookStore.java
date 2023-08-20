import java.util.Scanner; 
class BookStore
{
    private String title, author, publisher; 
    private int copies; 
    private float price; 

    BookStore()
    {
        title= author= publisher= "";
        copies= 0;
        price= 0f; 
    }

    void input()
    {
        Scanner sc= new Scanner (System.in);
        System.out.print("Title: ");
        title= sc.nextLine();
        System.out.print("Author: ");
        author= sc.nextLine();
        System.out.print("Publisher: ");
        publisher= sc.nextLine(); 
        System.out.print("Copies: ");
        copies= sc.nextInt();
        System.out.print("Price: Rs ");
        price= sc.nextFloat();
    }

    void display()
    {
        System.out.println(title+"\t"+author+"\t"+publisher+"\t"+price+"\t"+copies);
    }

    int isPresent (BookStore book[], int n, String title, String author)
    {
        for (int i=0; i<n; i++)
            if (book[i].title.equalsIgnoreCase(title) && book[i].author.equalsIgnoreCase(author))
                return i;
        return -1;
    }

    void sellBooks(BookStore book[], int n, String title, String author, int copies)
    {
        int index= isPresent(book, n, title, author);
        if (index >= 0)
            if (book[index].copies <= copies) {
                book[index].copies-= copies;
                System.out.print("\nINVOICE: "+"\nTitle: "+title+"\nAuthor: "+author
                    +"\nAmount= "+copies+" x Rs "+book[index].price+" = Rs "+price*copies);
            }
            else 
                System.out.print("\n"+copies+" of the book "+title+" by "+author+" are currently "+
                    "not available!");
        else 
            System.out.print("\nThe book "+title+" by "+author+" is not available in our store!");
    }

    void showBooks(BookStore book[], int n)
    {
        System.out.println("\nTitle"+"\t\tAuthor"+"\t"+"\t"+"\tPublisher"+"\t\tPrice"+"\tCopies");
        for (int i=0; i<n; i++)
            book[i].display();
    }

    public static void main()
    {
        Scanner sc= new Scanner (System.in);
        BookStore book[] = new BookStore[100];
        int n= 0, index=0, choice=0; 

        while (choice != 4)
        {
            System.out.println("\n\nMenu: "+"\n1. Add book(s)"+"\n2. Display book details"
                +"\n3. Sell Books"+"\n4. Exit program");
            System.out.print("Enter your choice (1 - 4): ");
            choice= sc.nextInt();
            
            switch(choice)
            {
                case 1:
                    System.out.print("\nEnter the number of books to add to the store: ");
                    int x = sc.nextInt();
                    for (int i=0; i<x; i++)
                    {
                        System.out.println("\nEnter the details for Book #"+(i+1)+": ");
                        book[n]= new BookStore();
                        book[n++].input();
                    }         
                    break;

                case 2: 
                    book[0].showBooks(book, n); 
                    break;

                case 3: 
                    System.out.println("\nEnter the details of the book to purchase: ");
                    System.out.print("Title: ");
                    sc.nextLine(); String t= sc.nextLine(); 
                    System.out.print("Author: ");
                    String a= sc.nextLine();
                    System.out.print("No. of copies: ");
                    int c= sc.nextInt();    
                    book[0].sellBooks(book, n, t, a, c);
                    break;

                case 4: 
                    System.out.println("\nThe program ends here. Thank You!");
                    break;

                default: 
                    System.out.print("\nInvalid input! Enter choice between 1 - 4 only.");
                    break;
            }
        }
    }
}
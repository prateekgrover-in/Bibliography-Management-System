package packagebibtex;

import java.util.Scanner;

public class ConsoleBibManager{
    /** 
     * Driver Function, creates a factory containing Strategies of all the types of Bibliographic Items, offers Menu-based choices for operations in the Array List of Bibliographic Items, and implements the same.
     * 
     * @param args[]
     * contains command line arguments, not applicable here.
     */
    public static void main(String args[]){
        
        BookConsoleInputStrategy bookStrategy = new BookConsoleInputStrategy();
        ArticleConsoleInputStrategy articleStrategy = new ArticleConsoleInputStrategy();
        TechReportConsoleInputStrategy techStrategy = new TechReportConsoleInputStrategy();
        ConcreteBibItemFactory newCreatedFactory = new ConcreteBibItemFactory(bookStrategy, articleStrategy, techStrategy);
        
        ListBibItems lstBibItems = ListBibItems.getInstance();
        Scanner sc = new Scanner(System.in);
        
        loop : while(true) {
            System.out.println("What would you like to do? Please make a selection from the list below: ");
            System.out.println("- (L)oad a BibTeX file,");
            System.out.println("- (S)ave your bibliography to a file");
            System.out.println("- (A)dd an entry to the bibliography");
            System.out.println("- (D)elete an entry from the bibliography?,");
            System.out.println("- (V)iew the bibliography");
            System.out.println("- (Q)uit");

            String ch = sc.nextLine();
            switch (ch){
                case "L": {
                    System.out.println("Enter filename from which you want to load contents. ");
                    String fileName = sc.nextLine();
                    lstBibItems.readFromFile(fileName);
                    break;
                }
                case "S": {
                    System.out.println("Enter filename to which you want to save contents. ");
                    String fileName = sc.nextLine();
                    lstBibItems.saveToFile(fileName);
                    break;
                }
                case "A": {
                    System.out.println("What kind of entry would you like to add? (article | techreport | book)");
                    String type = sc.nextLine();
                    BibItem newCreated = newCreatedFactory.createBibItem(type);
                    lstBibItems.addBibItem(newCreated);
                    break;
                }
                case "D": {
                    System.out.println("Enter Cite-Key of the document you want to delete.");
                    String toDeleteCiteKey = sc.nextLine();
                    lstBibItems.removeBibItem(toDeleteCiteKey);
                    break;
                }
                case "V": {
                    //System.out.println("Printing Harvard Formatted Bibliography Entries : \n");
                    lstBibItems.viewAllBibItems();
                    break;
                }
                case "Q": {
                    break loop;
                }
                default: {
                    System.out.println("Invalid choice! Please make a valid choice. \n\n");
                    break;
                }   
            }
        }
        sc.close();
    }
}

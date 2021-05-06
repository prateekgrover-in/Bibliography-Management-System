package packagebibtex;

import java.util.Scanner;

public class ConsoleInputStrategy implements ItemInputStrategy {
    public String authorName;
    public int yearPublished;
    public String title;

    Scanner in = new Scanner(System.in);
    
    
    /** 
     * checks if the passed parameter strNum is numeric.
     * 
     * @param strNum
     * contains string which needs to be checked
     * 
     * @return boolean
     * returns true if the string is numeric, returns false otherwise.
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    
    /** 
     * Inputs common attributes ie. authorName, title and yearPublished through the console, creates a default BibItem from them, and returning the same.
     * 
     * @return BibItem
     * returns default BibItem created using common attributes.
     */
    public BibItem createBibItemFromInput(){
        System.out.print("Enter Name of Author : ");
        this.authorName = in.nextLine();
        while (this.authorName.length() == 0){
            System.out.println("Sorry, this field cannot be NULL");
            this.authorName = in.nextLine();
        }
        System.out.print("Enter Title : ");
        this.title = in.nextLine();
        while (this.title.length() == 0){
            System.out.println("Sorry, this field cannot be NULL");
            this.title = in.nextLine();
        }
        System.out.print("Enter Year when Published : ");
        String yearPublishedString = in.nextLine();
        while (yearPublishedString.length() == 0 || isNumeric(yearPublishedString) == false){
            System.out.println("Sorry, this field cannot be NULL or a String");
            yearPublishedString = in.nextLine();
        }
        this.yearPublished = Integer.parseInt(yearPublishedString);
        return new BibItem(this.authorName, this.yearPublished, this.title);
    }
}

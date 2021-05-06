package packagebibtex;

public class TechReportConsoleInputStrategy extends ConsoleInputStrategy {
    
    /** 
     * Calls for creation of default common BibItem using ConsoleInputStrategy's createBibItemFromInput() function, takes input for TechReport specific attributes ie. Name of Institution and Date of Publication, creates a TechReport Specific BibItem, returning the same.
     * 
     * @return BibItem
     * returns BibItem of the type Tech Report
     */
    public BibItem createBibItemFromInput(){
        BibItem defaultBibItem = super.createBibItemFromInput();
        System.out.println("Enter Name of Institution : ");
        String institutionName = in.nextLine();
        while (institutionName.length() == 0){
            System.out.println("Sorry, this field cannot be NULL");
            institutionName = in.nextLine();
        }
        System.out.println("Enter Date of Publication (in MMDDYY Format) : ");
        String datePublishedString = in.nextLine();
        while (datePublishedString.length() == 0){
            System.out.println("Sorry, this field cannot be NULL");
            datePublishedString = in.nextLine();
        }
        int datePublished = Integer.parseInt(datePublishedString); 
        return new BibItem(defaultBibItem.getAuthorName(), defaultBibItem.getYearPublished(), defaultBibItem.getTitle(), institutionName, datePublished);
    }
}

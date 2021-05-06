package packagebibtex;

public class BookConsoleInputStrategy extends ConsoleInputStrategy{
    
    
    /** 
     * Calls for creation of default common BibItem using ConsoleInputStrategy's createBibItemFromInput() function, takes input for Publisher, and creates a Book Specific BibItem, returning the same.
     * 
     * @return BibItem
     * returns Book-Specific BibItem Created
     */
    public BibItem createBibItemFromInput(){
        BibItem defaultBibItem = super.createBibItemFromInput();
        System.out.print("Enter Name of Publisher : ");
        String namePublisher = in.nextLine();
        while (namePublisher.length() == 0){
            System.out.println("Sorry, this field cannot be NULL");
            namePublisher = in.nextLine();
        }
        return new BibItem(defaultBibItem.getAuthorName(), defaultBibItem.getYearPublished(), defaultBibItem.getTitle(), namePublisher);
    }
}

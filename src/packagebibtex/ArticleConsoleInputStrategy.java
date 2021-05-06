package packagebibtex;

public class ArticleConsoleInputStrategy extends ConsoleInputStrategy{

    /** 
     * checks the validity of DOI Link, with conditions as provided in requirements
     * 
     * @param DOILink
     * contains DOI Link of the article
     * 
     * @return boolean
     * returns True if passed string is a valid DOI Link, returns False otherwise.
     */
    public boolean isValidDOI(String DOILink){
    
        if (DOILink.length() < 25){
            return false;
        }
        String toCheck = DOILink.substring(0, 16);
        if (DOILink.length() > 24 && toCheck.equals("https://doi.org/")){
            String toCheckOne = DOILink.substring(16, 18);
            if (isNumeric(toCheckOne)){
                String toCheckTwo = DOILink.substring(18, 19);
                if (toCheckTwo.equals(".")){
                    String toCheckThree = DOILink.substring(19,23);
                    if (isNumeric(toCheckThree)){
                        String toCheckFour = DOILink.substring(23, 24);
                        if (toCheckFour.equals("/")){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    
    /** 
     * Calls parent class' createBibItemFromInput() which takes input of the common attributes and takes input of article-specific attributes ie. journalName and DOI Link, creates a BibItem, and returns the same.
     * 
     * @return BibItem
     * returns Article-Specific BibItem created.
     */
    public BibItem createBibItemFromInput(){
        
        BibItem defaultBibItem = super.createBibItemFromInput();
        System.out.print("Enter Name of Journal : ");
        String nameJournal = in.nextLine();
        while (nameJournal.length() == 0){
            System.out.println("Sorry, this field cannot be NULL");
            nameJournal = in.nextLine();
        }
        System.out.print("Enter DOI Link : ");
        String DOILink = in.nextLine();
        
        while (!isValidDOI(DOILink)){
            System.out.println("Sorry, your input has incorrect DOI link.");
            DOILink = in.nextLine();
        
        }        
        return new BibItem(defaultBibItem.getAuthorName(), defaultBibItem.getYearPublished(), defaultBibItem.getTitle(), nameJournal, DOILink);
    }
}

package packagebibtex;

public class ConcreteBibItemFactory {

    ConsoleInputStrategy bookStrategy;
    ConsoleInputStrategy articleStrategy;
    ConsoleInputStrategy techReportStrategy;

    /** 
     * Acts as the Factory Design Pattern, Constructor that assigns Type - Specific Strategies to its class attributes.
     * 
     * @param bookInputStrategy
     *  
     * @param articleInputStrategy
     * 
     * @param techReportInputStrategy
     * 
     */
    public ConcreteBibItemFactory(ConsoleInputStrategy bookInputStrategy, ConsoleInputStrategy articleInputStrategy, ConsoleInputStrategy techReportInputStrategy){
        this.bookStrategy = bookInputStrategy;
        this.articleStrategy = articleInputStrategy;
        this.techReportStrategy = techReportInputStrategy;
    }
    
    /** 
     * Acts as the Factory Design Pattern, calling for creation of a new Bibliographic Item using the strategy of Bibliographic Type defined in Console and returns the same.
     * 
     * @param type
     * contains type of BibItem to be created, can be either "book", "article" or "techreport".
     * 
     * @return BibItem
     * returns BibItem created using Type-Specific Strategy.
     */
    public BibItem createBibItem(String type){
        BibItem newCreated = new BibItem("Hi", 2000, "Hi");
        if (type.equals("article")){
            newCreated = createBibItemUsingStrategy(this.articleStrategy);
        }
        if (type.equals("book")){
            newCreated = createBibItemUsingStrategy(this.bookStrategy);
        }
        if (type.equals("techreport")){
            newCreated = createBibItemUsingStrategy(this.techReportStrategy);
        }
        return newCreated;
    }
    
    /** 
     * calls for createBibItemFromInput() method of Type-specific Input Strategy.  
     * 
     * @param currStrategy
     * contains Strategy using which BibItem shall be created. 
     *
     * @return BibItem
     * returns BibItem created using the Type-Specific strategy.
     */
    public BibItem createBibItemUsingStrategy(ConsoleInputStrategy currStrategy){
        return currStrategy.createBibItemFromInput();
    }
}

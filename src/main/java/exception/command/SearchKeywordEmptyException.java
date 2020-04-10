package exception.command;

import exception.CustomException;

//@@author GanapathySanathBalaji
public class SearchKeywordEmptyException extends CustomException {

    public static final String KEYWORD_TO_BE_USED_FOR_SEARCH_IS_EMPTY = "Keyword to be used for search is empty";

    public SearchKeywordEmptyException() {
        super(KEYWORD_TO_BE_USED_FOR_SEARCH_IS_EMPTY);
    }
}
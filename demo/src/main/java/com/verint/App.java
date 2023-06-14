package com.verint;

import java.util.ArrayList;
import java.util.List;

public final class App {

    private App() {
    }

    public static List<Integer> getPages(int currentPage, int totalPagesOfResults, int pagesToDisplay) throws Exception {
        //validate inputs 
        if(currentPage <= 0 || totalPagesOfResults <= 0) {
            throw new Exception("currentPage or totalPagesOfResults cannot be negative or zero");
        } 
        if(currentPage > totalPagesOfResults) {
            throw new Exception("currentPage cannot be greater than totalPagesOfResults");
        }
        List<Integer> pages = new ArrayList<Integer>();

        // when pagesToDisplay is uneven pagesBefore is greater than pagesAfter
        // when pagesToDisplay is even pagesBefore and pagesAfter are equal
        Integer pagesBefore = pagesToDisplay % 2 == 0 ? pagesToDisplay/2 : pagesToDisplay/2 +1;
        Integer pagesAfter = pagesToDisplay/2;
        Integer pagesToShow = pagesBefore+pagesAfter;
        Integer pagesAfterCurrentPage = totalPagesOfResults - currentPage;
        if(pagesAfterCurrentPage > pagesAfter && currentPage > pagesBefore) {
            for(int i=currentPage-pagesBefore; i<currentPage+pagesAfter; i++) {
                pages.add(i);
            }  
        } else if(pagesAfterCurrentPage <= pagesAfter) {
            // the +1 here is a hacky fix to display only 10 results including the final result
            for(int i=totalPagesOfResults-pagesToShow+1; i<=totalPagesOfResults; i++) {
                pages.add(i);
            }  

        } else if(currentPage <= pagesBefore) {
            for(int i=1; i<=pagesToShow; i++) {
                pages.add(i);
            }  
        } 
        return pages;
         
    }
}

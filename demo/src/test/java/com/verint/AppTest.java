package com.verint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
class AppTest {
    
    @Test
    void givenLowCurrentPageAnd10PagesToDisplay() throws Exception {
        List<Integer> pageResult = App.getPages(1, 100, 10);
        Assertions.assertEquals(pageResult, List.of(1,2,3,4,5,6,7,8,9,10) );
    }

    @Test
    void givenLowCurrentPageAndTotalPagesAnd9PagesToDisplay() throws Exception {
        List<Integer> pageResult = App.getPages(1, 100, 9);
        Assertions.assertEquals(pageResult, List.of(1,2,3,4,5,6,7,8,9) );
    }

     @Test
    void givenLowCurrentPageAndTotalPages_unvenPagesToDisplay() throws Exception {
        List<Integer> pageResult = App.getPages(5, 100, 9);
        Assertions.assertEquals(pageResult, List.of(1,2,3,4,5,6,7,8,9) );
    }

    @Test
    void givenCurrentPageLessThanPagesToDisplayFromTotalPages() throws Exception {
        List<Integer> pageResult = App.getPages(99, 100, 10);
        Assertions.assertEquals(pageResult, List.of(91, 92, 93, 94, 95, 96, 97, 98, 99, 100) );
    }

    @Test
    void givenCurrentPageIs23() throws Exception {
        List<Integer> pageResult = App.getPages(23, 100, 10);
        Assertions.assertEquals(pageResult, List.of(18, 19, 20, 21, 22, 23, 24, 25, 26, 27));
    }

    @Test()
    void shouldThrowExceptionWhenTotalPagesIsZero() {
        // List<Integer> pageResult = App.getPages(23, 18, 10);
        Exception thrownException = Assertions.assertThrows(Exception.class, () -> App.getPages(10, 0, 0));
        Assertions.assertEquals(thrownException.getMessage(), "currentPage or totalPagesOfResults cannot be negative or zero");
    }

    @Test()
    void shouldThrowExceptionWhenCurrentPagesIsZero() {
        Exception thrownException = Assertions.assertThrows(Exception.class, () -> App.getPages(0, 10, 0));
        Assertions.assertEquals(thrownException.getMessage(), "currentPage or totalPagesOfResults cannot be negative or zero");
    }

    @Test()
    void shouldThrowExceptionWhenCurrentPagesGreaterThanTotalPages() {
        Exception thrownException = Assertions.assertThrows(Exception.class, () -> App.getPages(11, 10, 10));
        Assertions.assertEquals(thrownException.getMessage(), "currentPage cannot be greater than totalPagesOfResults");
    }

    
}

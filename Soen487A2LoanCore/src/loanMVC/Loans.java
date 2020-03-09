/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanMVC;

/**
 *
 * @author fokpoonkai
 */
public class Loans {
    public int borrowId;
    public String personBorrow;
    public String dateOfBorrowing;
    public String returnDate;
    public int isReturn;

    public Loans() {
    }

    public Loans(int borrowId, String personBorrow, String dateOfBorrowing, String returnDate, int isReturn) {
        this.borrowId = borrowId;
        this.personBorrow = personBorrow;
        this.dateOfBorrowing = dateOfBorrowing;
        this.returnDate = returnDate;
        this.isReturn = isReturn;
    }

    public Loans(int borrowId, String personBorrow, String dateOfBorrowing, String returnDate) {
        this.borrowId = borrowId;
        this.personBorrow = personBorrow;
        this.dateOfBorrowing = dateOfBorrowing;
        this.returnDate = returnDate;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public String getPersonBorrow() {
        return personBorrow;
    }

    public void setPersonBorrow(String personBorrow) {
        this.personBorrow = personBorrow;
    }

    public String getDateOfBorrowing() {
        return dateOfBorrowing;
    }

    public void setDateOfBorrowing(String dateOfBorrowing) {
        this.dateOfBorrowing = dateOfBorrowing;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int isIsReturn() {
        return isReturn;
    }

    public void setIsReturn(int isReturn) {
        this.isReturn = isReturn;
    }
    
    
    
}

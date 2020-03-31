/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webclient;

import java.util.Scanner;

/**
 *
 * @author HUY
 */
public class WebClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option) {
            // getListMember() 
            case 1:

                try {
                    String result = getListMember();
                    System.out.println("Result: \n" + result);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                }
                break;

            //   getMember(id)
            case 2:
                try (Scanner in = new Scanner(System.in)) {
                    System.out.print("Please enter member id: ");
                    int id = in.nextInt();
                    System.out.println("You entered the id " + id);
                    String result = getMember(id);
                    System.out.println("Result: \n" + result);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                }
                break;

            //  addMember(String name, String contact) ---> ??? should we check if the name or contact already exists
            case 3:
                try (Scanner in = new Scanner(System.in)) {
                    System.out.print("Please enter member name: ");
                    String name = in.nextLine();
                    System.out.print("Please enter member contact: ");
                    String contact = in.nextLine();
                    System.out.println("You entered member name: " + name);
                    System.out.println("You entered the contact " + contact);
                    String result = addMember(name, contact);
                    System.out.println("The added member: " + result);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                }
                break;

            //   updateMember(id, name, contact)
            case 4:
                try (Scanner in = new Scanner(System.in)) {
                    System.out.print("Please enter member id: ");
                    int id = Integer.parseInt(in.nextLine());
                    System.out.print("Please enter member name: ");
                    String name = in.nextLine();
                    System.out.print("Please enter member contact: ");
                    String contact = in.nextLine();
                    System.out.println("You entered the id " + id);
                    System.out.println("You entered member name: " + name);
                    System.out.println("You entered the contact: " + contact);
                    String result = updateMember(id, name, contact);
                    System.out.println("The update member: " + result);
                } catch (NumberFormatException ex) {
                    System.out.println("Exception: " + ex);
                }
                break;
            
            // deleteMember(id) 
            case 5:
                try (Scanner in = new Scanner(System.in)) {
                    System.out.print("Please enter member id: ");
                    int id = in.nextInt();
                    System.out.println("You entered the id " + id);
                    String result = deleteMember(id);
                    System.out.println("Result: \n" + result);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                }
                break;

            //  getLoanListByBookName(bookName)
            case 6:
                try (Scanner in = new Scanner(System.in)) {
                    System.out.print("Please enter the book name: ");
                    String bookName = in.nextLine();
                    System.out.println("You entered the book name: " + bookName);
                    String result = getLoanListByBookName(bookName);
                    System.out.println("Result: " + result);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                }
                break;

            //createLoanBook(borrowID, bookName, personBorrow, borrowDate, returnDate) 
            case 7:
                try (Scanner in = new Scanner(System.in)) {
                    System.out.print("Please enter the borrow ID: ");
                    int borrowID = Integer.parseInt(in.nextLine());
                    System.out.print("Please enter the book name: ");
                    String bookName = in.nextLine();
                    System.out.print("Please enter the book borrow person: ");
                    int personBorrow = Integer.parseInt(in.nextLine());
                    System.out.print("Please enter the book borrow date: ");
                    String borrowDate = in.nextLine();
                    System.out.print("Please enter the return date: ");
                    String returnDate = in.nextLine();
                    System.out.println("You entered the book name: " + bookName);
                    String result = createLoanBook(borrowID, bookName, personBorrow, borrowDate, returnDate);
                    System.out.println("Result: " + result);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                }
                break;

            //  borrowBook(bookid)    
            case 8:
                try (Scanner in = new Scanner(System.in)) {
                    System.out.print("Please enter the book ID: ");
                    int bookid = Integer.parseInt(in.nextLine());
                    System.out.println("You entered the book ID: " + bookid);
                    String result = borrowBook(bookid);
                    System.out.println("Result: " + result);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                }
                break;

            //  returnBook(bookID)
            case 9:
                try (Scanner in = new Scanner(System.in)) {
                    System.out.print("Please enter the book ID: ");
                    int bookID = Integer.parseInt(in.nextLine());
                    System.out.println("You entered the book ID: " + bookID);
                    String result = returnBook(bookID);
                    System.out.println("Result: " + result);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                }
                break;

            //  updateLoan(bookId, bookName, personBorrow, dateOfBorrowing, returnDate, isReturn)
            case 10:
                try (Scanner in = new Scanner(System.in)) {
                    System.out.print("Please enter the book ID: ");
                    int bookId = Integer.parseInt(in.nextLine());
                    System.out.print("Please enter the book name: ");
                    String bookName = in.nextLine();
                    System.out.print("Please enter the person borrow: ");
                    int personBorrow = Integer.parseInt(in.nextLine());
                    System.out.print("Please enter the date of borrowing: ");
                    String dateOfBorrowing = in.nextLine();
                    System.out.print("Please enter the return date: ");
                    String returnDate = in.nextLine();
                    System.out.print("Please choose the isReturn, either 0 or 1: ");
                    int isReturn = Integer.parseInt(in.nextLine());
                    System.out.println("You entered the book ID: " + bookId);
                    System.out.println("You entered the book name: " + bookName);
                    System.out.println("You entered the Person's Borrow: " + personBorrow);
                    System.out.println("You entered the Date Of Borrowing: " + dateOfBorrowing);
                    System.out.println("You entered the return date: " + returnDate);
                    System.out.println("You chose isReturn: " + isReturn);
                    String result = updateLoan(bookId, bookName, personBorrow, dateOfBorrowing, returnDate, isReturn);
                    System.out.println("Result: " + result);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                }
                break;

            //  deleteLoanBook(borrowBookId)
            case 11:
                try (Scanner in = new Scanner(System.in)) {
                    System.out.print("Please enter the borrowBookId: ");
                    int borrowBookId = Integer.parseInt(in.nextLine());
                    System.out.println("You entered the borrowBookId: " + borrowBookId);
                    String result = deleteLoanBook(borrowBookId);
                    System.out.println("Result: " + result);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                }
                break;
                
            //  showIsReturn(borrowBookId)
            case 12:
                try (Scanner in = new Scanner(System.in)) {
                    System.out.print("Please enter the borrowBookId: ");
                    int borrowBookId = Integer.parseInt(in.nextLine());
                    System.out.println("You entered the borrowBookId: " + borrowBookId);
                    int result = showIsReturn(borrowBookId);
                    System.out.println("Result: " + result);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                }
                break;
                
            default:
                System.out.println("Please choose one of the options as listed");
                break;
        }

    }

    private static String createLoanBook(int borrowID, java.lang.String bookName, int personBorrow, java.lang.String borrowDate, java.lang.String returnDate) {
        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
        loanservice.LoanService port = service.getLoanServicePort();
        return port.createLoanBook(borrowID, bookName, personBorrow, borrowDate, returnDate);
    }

    private static String addMember(java.lang.String name, java.lang.String contact) {
        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
        loanservice.LoanService port = service.getLoanServicePort();
        return port.addMember(name, contact);
    }

    private static String borrowBook(int bookid) {
        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
        loanservice.LoanService port = service.getLoanServicePort();
        return port.borrowBook(bookid);
    }

    private static String deleteLoanBook(int borrowBookId) {
        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
        loanservice.LoanService port = service.getLoanServicePort();
        return port.deleteLoanBook(borrowBookId);
    }

    private static String deleteMember(int id) {
        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
        loanservice.LoanService port = service.getLoanServicePort();
        return port.deleteMember(id);
    }

  
    private static String getListMember() {
        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
        loanservice.LoanService port = service.getLoanServicePort();
        return port.getListMember();
    }

    private static String getLoanListByBookName(java.lang.String bookName) {
        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
        loanservice.LoanService port = service.getLoanServicePort();
        return port.getLoanListByBookName(bookName);
    }

    private static String getMember(int id) {
        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
        loanservice.LoanService port = service.getLoanServicePort();
        return port.getMember(id);
    }

//    private static String hello(java.lang.String name) {
//        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
//        loanservice.LoanService port = service.getLoanServicePort();
//        return port.hello(name);
//    }
    private static String returnBook(int bookID) {
        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
        loanservice.LoanService port = service.getLoanServicePort();
        return port.returnBook(bookID);
    }

    private static int showIsReturn(int borrowBookId) {
        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
        loanservice.LoanService port = service.getLoanServicePort();
        return port.showIsReturn(borrowBookId);
    }

    private static String updateLoan(int bookId, java.lang.String bookName, int personBorrow, java.lang.String dateOfBorrowing, java.lang.String returnDate, int isReturn) {
        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
        loanservice.LoanService port = service.getLoanServicePort();
        return port.updateLoan(bookId, bookName, personBorrow, dateOfBorrowing, returnDate, isReturn);
    }

    private static String updateMember(int id, java.lang.String name, java.lang.String contact) {
        loanservice.LoanService_Service service = new loanservice.LoanService_Service();
        loanservice.LoanService port = service.getLoanServicePort();
        return port.updateMember(id, name, contact);
    }

}

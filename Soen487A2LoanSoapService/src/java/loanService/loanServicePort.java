/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author vickelleung
 */
@Path("loanserviceport")
public class loanServicePort {

    private loanService_client.LoanService port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of loanServicePort
     */
    public loanServicePort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method deleteLoanBook
     * @param borrowBookId resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("deleteloanbook/")
    public String getDeleteLoanBook(@QueryParam("borrowBookId")
            @DefaultValue("0") int borrowBookId) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.deleteLoanBook(borrowBookId);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method showIsReturn
     * @param borrowBookId resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("showisreturn/")
    public String getShowIsReturn(@QueryParam("borrowBookId")
            @DefaultValue("0") int borrowBookId) {
        try {
            // Call Web Service Operation
            if (port != null) {
                int result = port.showIsReturn(borrowBookId);
                return new java.lang.Integer(result).toString();
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method getMemberIdByName
     * @param name resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("getmemberidbyname/")
    public String getMemberIdByName(@QueryParam("name") String name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                int result = port.getMemberIdByName(name);
                return new java.lang.Integer(result).toString();
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method addMember
     * @param name resource URI parameter
     * @param contact resource URI parameter
     * @param password resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("addmember/")
    public String getAddMember(@QueryParam("name") String name, @QueryParam("contact") String contact, @QueryParam("password") String password) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.addMember(name, contact, password);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method updateMember
     * @param id resource URI parameter
     * @param name resource URI parameter
     * @param contact resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("updatemember/")
    public String getUpdateMember(@QueryParam("id")
            @DefaultValue("0") int id, @QueryParam("name") String name, @QueryParam("contact") String contact) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.updateMember(id, name, contact);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method getListMember
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("getlistmember/")
    public String getListMember() {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.getListMember();
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method deleteMember
     * @param id resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("deletemember/")
    public String getDeleteMember(@QueryParam("id")
            @DefaultValue("0") int id) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.deleteMember(id);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method getLoanListByBookName
     * @param bookName resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("getloanlistbybookname/")
    public String getLoanListByBookName(@QueryParam("bookName") String bookName) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.getLoanListByBookName(bookName);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method CreateLoanBook
     * @param borrowID resource URI parameter
     * @param bookName resource URI parameter
     * @param personBorrow resource URI parameter
     * @param borrowDate resource URI parameter
     * @param returnDate resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("createloanbook/")
    public String getCreateLoanBook(@QueryParam("borrowID")
            @DefaultValue("0") int borrowID, @QueryParam("bookName") String bookName, @QueryParam("personBorrow")
            @DefaultValue("0") int personBorrow, @QueryParam("borrowDate") String borrowDate, @QueryParam("returnDate") String returnDate) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.createLoanBook(borrowID, bookName, personBorrow, borrowDate, returnDate);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method borrowBook
     * @param bookid resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("borrowbook/")
    public String getBorrowBook(@QueryParam("bookid")
            @DefaultValue("0") int bookid) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.borrowBook(bookid);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method returnBook
     * @param bookID resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("returnbook/")
    public String getReturnBook(@QueryParam("bookID")
            @DefaultValue("0") int bookID) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.returnBook(bookID);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method updateLoan
     * @param bookId resource URI parameter
     * @param bookName resource URI parameter
     * @param personBorrow resource URI parameter
     * @param dateOfBorrowing resource URI parameter
     * @param returnDate resource URI parameter
     * @param isReturn resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("updateloan/")
    public String getUpdateLoan(@QueryParam("bookId")
            @DefaultValue("0") int bookId, @QueryParam("bookName") String bookName, @QueryParam("personBorrow")
            @DefaultValue("0") int personBorrow, @QueryParam("dateOfBorrowing") String dateOfBorrowing, @QueryParam("returnDate") String returnDate, @QueryParam("isReturn")
            @DefaultValue("0") int isReturn) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.updateLoan(bookId, bookName, personBorrow, dateOfBorrowing, returnDate, isReturn);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method getMember
     * @param id resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("getmember/")
    public String getMember(@QueryParam("id")
            @DefaultValue("0") int id) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.getMember(id);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private loanService_client.LoanService getPort() {
        try {
            // Call Web Service Operation
            loanService_client.LoanService_Service service = new loanService_client.LoanService_Service();
            loanService_client.LoanService p = service.getLoanServicePort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}

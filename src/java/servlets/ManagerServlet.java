/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Book;
import entity.Cover;
import entity.Reader;
import entity.User;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.BookFacade;
import session.CoverFacade;
import session.HistoryFacade;
import session.ReaderFacade;
import session.UserFacade;
import session.UserRolesFacade;

/**
 *
 * @author jvm
 */
@WebServlet(name = "ManagerServlet", urlPatterns = {
    "/addBook",
    "/createBook",
    "/editBookForm",
    "/editBook",
    "/uploadForm",
    
    

})
public class ManagerServlet extends HttpServlet {
    @EJB 
    private BookFacade bookFacade;
    @EJB 
    private ReaderFacade readerFacade;
    @EJB
    private HistoryFacade historyFacade;
    @EJB
    private UserFacade userFacade;
    @EJB private UserRolesFacade userRolesFacade;
    @EJB private CoverFacade coverFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.setAttribute("info", "У вас нет права для этого ресурса. Войдите в систему");
            request.getRequestDispatcher("/showLoginForm").forward(request, response);
            return;
        }
        User user = (User) session.getAttribute("user");
        if(user == null){
            request.setAttribute("info", "У вас нет права для этого ресурса. Войдите в систему");
            request.getRequestDispatcher("/showLoginForm").forward(request, response);
            return;
        }
        boolean isRole = userRolesFacade.isRole("MANAGER", user);
        if(!isRole){
            request.setAttribute("info", "У вас нет права для этого ресурса. Войдите в систему с соответствующими правами");
            request.getRequestDispatcher("/showLoginForm").forward(request, response);
            return;
        }
        String path = request.getServletPath();
        
        switch (path) {
            case "/addBook":
                request.setAttribute("activeAddBook", "true");
                List<Cover> listCovers = coverFacade.findAll();
                request.setAttribute("listCovers", listCovers);
                request.getRequestDispatcher(LoginServlet.pathToJsp.getString("addBook")).forward(request, response);
                break;
            case "/createBook":
                String name = request.getParameter("name");
                String author = request.getParameter("author");
                String publishedYear = request.getParameter("publishedYear");
                String text = request.getParameter("text");
                String price = request.getParameter("price");
                String coverId = request.getParameter("coverId");
                if("".equals(name) || name == null 
                        || "".equals(author) || author == null
                        || "".equals(publishedYear) || publishedYear == null
                        || "".equals(coverId) || coverId == null){
                    request.setAttribute("info","Заполните все поля формы");
                    request.setAttribute("name",name);
                    request.setAttribute("author",author);
                    request.setAttribute("publishedYear",publishedYear);
                    request.setAttribute("text",text);
                    request.setAttribute("price",price);
                    request.setAttribute("coverId",coverId);
                    request.getRequestDispatcher("/addBook").forward(request, response);
                    break; 
                }
                Cover cover = coverFacade.find(Long.parseLong(coverId));
                Book book = null;
                try {
                    book = new Book(name, author, Integer.parseInt(publishedYear), text, price, cover);
                } catch (NumberFormatException e) {
                    request.setAttribute("info","Неправильный формат цены: " + price );
                    request.setAttribute("name",name);
                    request.setAttribute("author",author);
                    request.setAttribute("publishedYear",publishedYear);
                    request.setAttribute("text",text);
                    request.setAttribute("price",price);
                    request.setAttribute("coverId",coverId);
                    request.getRequestDispatcher("/addBook").forward(request, response);
                    break;  
                }
                bookFacade.create(book);
                request.setAttribute("info","Добавлена книга: " +book.toString() );
                request.getRequestDispatcher("/addBook").forward(request, response);
                break;
            case "/editBookForm":
                request.setAttribute("activeEditBookForm", "true");
                String bookId = request.getParameter("bookId");
                book = bookFacade.find(Long.parseLong(bookId));
                request.setAttribute("book", book);
                request.getRequestDispatcher(LoginServlet.pathToJsp.getString("editBook")).forward(request, response);
                break;
            case "/editBook":
                bookId = request.getParameter("bookId");
                book = bookFacade.find(Long.parseLong(bookId));
                name = request.getParameter("name");
                author = request.getParameter("author");
                publishedYear = request.getParameter("publishedYear");
                if("".equals(name) || name == null 
                        || "".equals(author) || author == null
                        || "".equals(publishedYear) || publishedYear == null){
                    request.setAttribute("info","Поля не должны быть пустыми");
                    request.setAttribute("bookId", book.getId());
                    request.getRequestDispatcher("/editBookForm").forward(request, response);
                    break; 
                }
                book.setName(name);
                book.setAuthor(author);
                book.setPublishedYear(Integer.parseInt(publishedYear));
                bookFacade.edit(book);
                request.setAttribute("info","Книга отредактирована");
                request.setAttribute("bookId", book.getId());
                request.getRequestDispatcher("/editBookForm").forward(request, response);
                break;
            case "/uploadForm":
                request.getRequestDispatcher(LoginServlet.pathToJsp.getString("upload")).forward(request, response);
                break;
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

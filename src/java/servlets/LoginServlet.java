/**
 * Алгоритм создания веб приложения на JavaEE
 * 
 * 1. В NetBeans создаем веб приложение.
 *      File->New Project -> Java Web -> Web application
 * 2. Создать сущностные классы с аннотациями в пакете entity
 * 3. Создать базу данных с пользователем и паролем.
 * 4. Создать persistence.xml (useUnicode=true&characterEncoding=utf8)
 * 5. Создать сессионные бины в пакете session (используем паттерн Фасад)
 * 6. Создать jsp страницы со ссылками и формами. Проставить правильные запросы 
 *      в тегах <a href="..."> и <form action="..." method="POST">
 * 7. Создать сервлет "MyServlet" в пакете servlets.
 * 8. В аннотации @WebServlet(urlPatherns={"..."}) вместо многоточия прописать 
 *      паттерны запросов из jsp страниц
 * 9. В методе processRequest получить паттерн из текущего запроса в переменную 
 *      String path = request.getServletPath();
 * 10. В кейсах switch обработать полученный запрос и отправить веб контейнеру 
 *      страничку с данными для передачи ее клиенту. 
 *      Например: 
 *      request.getRequestDispatcher("/WEB-INF/addBookForm.jsp").forward(request, response);
 * 
 */
package servlets;

import entity.Book;
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
import session.ReaderFacade;
import session.UserFacade;

/**
 *
 * @author jvm
 */
@WebServlet(name = "LoginServlet", urlPatterns = {
    "/showLoginForm",
    "/login",
    "/logout",
    "/addReader",
    "/createReader",
    "/listBooks",
})
public class LoginServlet extends HttpServlet {
    @EJB private UserFacade userFacade;
    @EJB private ReaderFacade readerFacade;
    @EJB private BookFacade bookFacade;
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
        String path = request.getServletPath();
        
        switch (path) {
            case "/showLoginForm":
                request.getRequestDispatcher("/WEB-INF/showLoginForm.jsp").forward(request, response);
                break;
            case "/login":
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                User user = userFacade.findByLogin(login);
                if(user == null){
                    request.setAttribute("info", "Нет такого пользователя или неправильный пароль");
                    request.getRequestDispatcher("/showLoginForm").forward(request, response);
                    break;
                }
                if(!password.equals(user.getPassword())){
                     request.setAttribute("info", "Нет такого пользователя или неправильный пароль");
                    request.getRequestDispatcher("/showLoginForm").forward(request, response);
                    break;
                }
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                request.setAttribute("info", "Вы вошли! :)");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/logout":
                session = request.getSession(false);
                if(session != null){
                    session.invalidate();
                }
                request.setAttribute("info", "Вы вышли! :)");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/addReader":
                request.getRequestDispatcher("/WEB-INF/addReaderForm.jsp").forward(request, response);
                break;
            case "/createReader":
                String name = request.getParameter("name");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phone");
                login = request.getParameter("login");
                password = request.getParameter("password");
                if("".equals(name) || name == null 
                        || "".equals(lastname) || lastname == null
                        || "".equals(phone) || phone == null
                        || "".equals(login) || login == null
                        || "".equals(password) || password == null){
                    request.setAttribute("info","Заполните все поля формы");
                    request.setAttribute("name",name);
                    request.setAttribute("lastname",lastname);
                    request.setAttribute("phone",phone);
                    request.getRequestDispatcher("/addReaderForm").forward(request, response);
                    break; 
                }
                Reader reader= new Reader(name, lastname, phone);
                readerFacade.create(reader);
                user = new User(login, password, reader);
                userFacade.create(user);
                request.setAttribute("info","Добавлена читатель: " +reader.toString() );
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/listBooks":
                List<Book> listBooks = bookFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.getRequestDispatcher("/WEB-INF/listBooks.jsp").forward(request, response);
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

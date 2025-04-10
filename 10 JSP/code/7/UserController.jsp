<%
// CONTROLADOR DE USUARIOS
import User;
import java.io.IOException;
import java.util.List;

public class UserController extends HttpServlet {
    public static void getAll() {
        List<User> users = User.getAll();
        View.show("userList.jsp", users);
    }
}

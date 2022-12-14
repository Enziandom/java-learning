package servlets;

import configs.MySQLConfig;
import entities.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JdbcOperation;

import java.io.IOException;

@WebServlet(name = "GetPost", urlPatterns = {"/get/post"})
public class GetPostServlet extends HttpServlet {

  private static final JdbcOperation<Post> op = new JdbcOperation<>(MySQLConfig.class, Post.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/json");
    int id = Integer.parseInt(req.getParameter("id"));
    Post post = new Post();
    post.setId(id);
    resp.getWriter().write(op.load(post).select(true, "id = " + "'" + id + "'", null).getJson());
    op.close();
  }
}

package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Calculator;

/**
 * Servlet implementation class CalcServlet
 */
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CalcServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Calculator calc = new Calculator();
        
        String p1 = request.getParameter("a");
        String p2 = request.getParameter("b");
        String op = request.getParameter("op");
        int par1=Integer.parseInt(p1);
        int par2=Integer.parseInt(p2);
        int result=-1;

        if (op.equals("+"))
            result = calc.sumar(par1,par2);
        else if (op.equals("-"))
            result = calc.restar(par1,par2);
        else if (op.equals("*"))
            result = calc.multiplicar(par1,par2);
        else if(op.equals("/"))
            result = calc.dividir(par1,par2);
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalcServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>"+p1+" "+op+" "+p2+"="+result);
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

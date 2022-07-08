package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            int n = 0;
            String a = "", b = "", c = "", d = "", e = "", f = "", g = "";
            String curso[] = new String[27];
            for (int t = 0; t <= 26; t++) {
                switch (t) {
                    case 0:
                        a = " ";
                        break;
                    case 1:
                        a = "A";
                        break;
                    case 2:
                        a = "B";
                        break;
                    case 3:
                        a = "C";
                        break;
                    case 4:
                        a = "D";
                        break;
                    case 5:
                        a = "E";
                        break;
                    case 6:
                        a = "F";
                        break;
                    case 7:
                        a = "G";
                        break;
                    case 8:
                        a = "H";
                        break;
                    case 9:
                        a = "I";
                        break;
                    case 10:
                        a = "J";
                        break;
                    case 11:
                        a = "K";
                        break;
                    case 12:
                        a = "L";
                        break;
                    case 13:
                        a = "M";
                        break;
                    case 14:
                        a = "N";
                        break;
                    case 15:
                        a = "O";
                        break;
                    case 16:
                        a = "P";
                        break;
                    case 17:
                        a = "Q";
                        break;
                    case 18:
                        a = "R";
                        break;
                    case 19:
                        a = "S";
                        break;
                    case 20:
                        a = "T";
                        break;
                    case 21:
                        a = "U";
                        break;
                    case 22:
                        a = "V";
                        break;
                    case 23:
                        a = "W";
                        break;
                    case 24:
                        a = "X";
                        break;
                    case 25:
                        a = "Y";
                        break;
                    case 26:
                        a = "Z";
                        break;
                }
                for (int ff = 0; ff <= 26; ff++) {
                    switch (ff) {
                        case 0:
                            b = " ";
                            break;
                        case 1:
                            b = "A";
                            break;
                        case 2:
                            b = "B";
                            break;
                        case 3:
                            b = "C";
                            break;
                        case 4:
                            b = "D";
                            break;
                        case 5:
                            b = "E";
                            break;
                        case 6:
                            b = "F";
                            break;
                        case 7:
                            b = "G";
                            break;
                        case 8:
                            b = "H";
                            break;
                        case 9:
                            b = "I";
                            break;
                        case 10:
                            b = "J";
                            break;
                        case 11:
                            b = "K";
                            break;
                        case 12:
                            b = "L";
                            break;
                        case 13:
                            b = "M";
                            break;
                        case 14:
                            b = "N";
                            break;
                        case 15:
                            b = "O";
                            break;
                        case 16:
                            b = "P";
                            break;
                        case 17:
                            b = "Q";
                            break;
                        case 18:
                            b = "R";
                            break;
                        case 19:
                            b = "S";
                            break;
                        case 20:
                            b = "T";
                            break;
                        case 21:
                            b = "U";
                            break;
                        case 22:
                            b = "V";
                            break;
                        case 23:
                            b = "W";
                            break;
                        case 24:
                            b = "X";
                            break;
                        case 25:
                            b = "Y";
                            break;
                        case 26:
                            b = "Z";
                            break;
                    }
                    for (int j = 0; j <= 26; j++) {
                        switch (j) {
                            case 0:
                                c = " ";
                                break;
                            case 1:
                                c = "A";
                                break;
                            case 2:
                                c = "B";
                                break;
                            case 3:
                                c = "C";
                                break;
                            case 4:
                                c = "D";
                                break;
                            case 5:
                                c = "E";
                                break;
                            case 6:
                                c = "F";
                                break;
                            case 7:
                                c = "G";
                                break;
                            case 8:
                                c = "H";
                                break;
                            case 9:
                                c = "I";
                                break;
                            case 10:
                                c = "J";
                                break;
                            case 11:
                                c = "K";
                                break;
                            case 12:
                                c = "L";
                                break;
                            case 13:
                                c = "M";
                                break;
                            case 14:
                                c = "N";
                                break;
                            case 15:
                                c = "O";
                                break;
                            case 16:
                                c = "P";
                                break;
                            case 17:
                                c = "Q";
                                break;
                            case 18:
                                c = "R";
                                break;
                            case 19:
                                c = "S";
                                break;
                            case 20:
                                c = "T";
                                break;
                            case 21:
                                c = "U";
                                break;
                            case 22:
                                c = "V";
                                break;
                            case 23:
                                c = "W";
                                break;
                            case 24:
                                c = "X";
                                break;
                            case 25:
                                c = "Y";
                                break;
                            case 26:
                                c = "Z";
                                break;
                        }
                        for (int k = 0; k <= 26; k++) {
                            switch (k) {
                                case 0:
                                    d = " ";
                                    break;
                                case 1:
                                    d = "A";
                                    break;
                                case 2:
                                    d = "B";
                                    break;
                                case 3:
                                    d = "C";
                                    break;
                                case 4:
                                    d = "D";
                                    break;
                                case 5:
                                    d = "E";
                                    break;
                                case 6:
                                    d = "F";
                                    break;
                                case 7:
                                    d = "G";
                                    break;
                                case 8:
                                    d = "H";
                                    break;
                                case 9:
                                    d = "I";
                                    break;
                                case 10:
                                    d = "J";
                                    break;
                                case 11:
                                    d = "K";
                                    break;
                                case 12:
                                    d = "L";
                                    break;
                                case 13:
                                    d = "M";
                                    break;
                                case 14:
                                    d = "N";
                                    break;
                                case 15:
                                    d = "O";
                                    break;
                                case 16:
                                    d = "P";
                                    break;
                                case 17:
                                    d = "Q";
                                    break;
                                case 18:
                                    d = "R";
                                    break;
                                case 19:
                                    d = "S";
                                    break;
                                case 20:
                                    d = "T";
                                    break;
                                case 21:
                                    d = "U";
                                    break;
                                case 22:
                                    d = "V";
                                    break;
                                case 23:
                                    d = "W";
                                    break;
                                case 24:
                                    d = "X";
                                    break;
                                case 25:
                                    d = "Y";
                                    break;
                                case 26:
                                    d = "Z";
                                    break;
                            }
                            for (int l = 0; l <= 26; l++) {
                                switch (l) {
                                    case 0:
                                        e = " ";
                                        break;
                                    case 1:
                                        e = "A";
                                        break;
                                    case 2:
                                        e = "B";
                                        break;
                                    case 3:
                                        e = "C";
                                        break;
                                    case 4:
                                        e = "D";
                                        break;
                                    case 5:
                                        e = "E";
                                        break;
                                    case 6:
                                        e = "F";
                                        break;
                                    case 7:
                                        e = "G";
                                        break;
                                    case 8:
                                        e = "H";
                                        break;
                                    case 9:
                                        e = "I";
                                        break;
                                    case 10:
                                        e = "J";
                                        break;
                                    case 11:
                                        e = "K";
                                        break;
                                    case 12:
                                        e = "L";
                                        break;
                                    case 13:
                                        e = "M";
                                        break;
                                    case 14:
                                        e = "N";
                                        break;
                                    case 15:
                                        e = "O";
                                        break;
                                    case 16:
                                        e = "P";
                                        break;
                                    case 17:
                                        e = "Q";
                                        break;
                                    case 18:
                                        e = "R";
                                        break;
                                    case 19:
                                        e = "S";
                                        break;
                                    case 20:
                                        e = "T";
                                        break;
                                    case 21:
                                        e = "U";
                                        break;
                                    case 22:
                                        e = "V";
                                        break;
                                    case 23:
                                        e = "W";
                                        break;
                                    case 24:
                                        e = "X";
                                        break;
                                    case 25:
                                        e = "Y";
                                        break;
                                    case 26:
                                        e = "Z";
                                        break;
                                }
                                for (int m = 0; m <= 26; m++) {
                                    switch (m) {
                                        case 0:
                                            f = " ";
                                            break;
                                        case 1:
                                            f = "A";
                                            break;
                                        case 2:
                                            f = "B";
                                            break;
                                        case 3:
                                            f = "C";
                                            break;
                                        case 4:
                                            f = "D";
                                            break;
                                        case 5:
                                            f = "E";
                                            break;
                                        case 6:
                                            f = "F";
                                            break;
                                        case 7:
                                            f = "G";
                                            break;
                                        case 8:
                                            f = "H";
                                            break;
                                        case 9:
                                            f = "I";
                                            break;
                                        case 10:
                                            f = "J";
                                            break;
                                        case 11:
                                            f = "K";
                                            break;
                                        case 12:
                                            f = "L";
                                            break;
                                        case 13:
                                            f = "M";
                                            break;
                                        case 14:
                                            f = "N";
                                            break;
                                        case 15:
                                            f = "O";
                                            break;
                                        case 16:
                                            f = "P";
                                            break;
                                        case 17:
                                            f = "Q";
                                            break;
                                        case 18:
                                            f = "R";
                                            break;
                                        case 19:
                                            f = "S";
                                            break;
                                        case 20:
                                            f = "T";
                                            break;
                                        case 21:
                                            f = "U";
                                            break;
                                        case 22:
                                            f = "V";
                                            break;
                                        case 23:
                                            f = "W";
                                            break;
                                        case 24:
                                            f = "X";
                                            break;
                                        case 25:
                                            f = "Y";
                                            break;
                                        case 26:
                                            f = "Z";
                                            break;
                                    }
                                    for (int tn = 0; tn <= 26; tn++) {
                                        switch (tn) {
                                            case 0:
                                                g = " ";
                                                break;
                                            case 1:
                                                g = "A";
                                                break;
                                            case 2:
                                                g = "B";
                                                break;
                                            case 3:
                                                g = "C";
                                                break;
                                            case 4:
                                                g = "D";
                                                break;
                                            case 5:
                                                g = "E";
                                                break;
                                            case 6:
                                                g = "F";
                                                break;
                                            case 7:
                                                g = "G";
                                                break;
                                            case 8:
                                                g = "H";
                                                break;
                                            case 9:
                                                g = "I";
                                                break;
                                            case 10:
                                                g = "J";
                                                break;
                                            case 11:
                                                g = "K";
                                                break;
                                            case 12:
                                                g = "L";
                                                break;
                                            case 13:
                                                g = "M";
                                                break;
                                            case 14:
                                                g = "N";
                                                break;
                                            case 15:
                                                g = "O";
                                                break;
                                            case 16:
                                                g = "P";
                                                break;
                                            case 17:
                                                g = "Q";
                                                break;
                                            case 18:
                                                g = "R";
                                                break;
                                            case 19:
                                                g = "S";
                                                break;
                                            case 20:
                                                g = "T";
                                                break;
                                            case 21:
                                                g = "U";
                                                break;
                                            case 22:
                                                g = "V";
                                                break;
                                            case 23:
                                                g = "W";
                                                break;
                                            case 24:
                                                g = "X";
                                                break;
                                            case 25:
                                                g = "Y";
                                                break;
                                            case 26:
                                                g = "Z";
                                                break;
                                        }
                                        curso[k] = a + b;
                                        n++;


        
      out.write("\n");
      out.write("        <h1>");
      out.print(curso[k] + "<br>");
}
                                }
                            }
                        }
                    }
                }
            }
      out.write("</h1>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

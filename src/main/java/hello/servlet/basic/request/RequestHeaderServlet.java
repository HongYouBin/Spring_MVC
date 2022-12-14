package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "reqeustHeaderServlet", urlPatterns = "/reqeust-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.service(req, resp);

        //String method = request.getMethod();
        //String protocol = request.getProtocol();
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
    }

    private void printStartLine(HttpServletRequest request){
        System.out.println("---REQUEST LINE start---");

        System.out.println("request.getMethod() = "+request.getMethod());
        System.out.println("request.getProtocol() = "+request.getProtocol());
        System.out.println("request.getScheme() = "+request.getScheme());

        System.out.println("request.getRequestURL() = "+request.getRequestURL());
        System.out.println("request.getRequestURI() = "+request.getRequestURI());

        System.out.println("request.getQueryString() = "+request.getQueryString());
        System.out.println("request.isSecure() = "+request.isSecure());


        System.out.println("---REQUEST LINE end ---");

    }

    private void printHeaders(HttpServletRequest request){
        System.out.println("---Headers start ---");
        /*
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName +": " +headerName);
        }*/
        request.getHeaderNames().asIterator().forEachRemaining(headerName -> System.out.println(headerName+": "+headerName));
        System.out.println("---Headers end ---");
    }

    private void printHeaderUtils(HttpServletRequest request){
        System.out.println("---Headers ?????? ?????? ---");
        System.out.println("[Host ?????? ??????]");
        System.out.println("request.getServerName() = "+request.getServerName());
        System.out.println("request.getServerPort() = "+request.getServerPort());

        System.out.println("[Accept-Language ?????? ??????]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = "+locale));
        System.out.println("request.getLocale() = "+request.getLocale());
        System.out.println("request.getLocale() = "+request.getLocale());

        System.out.println("[cookie ?????? ??????]");
        if(request.getCookies()!=null){
            for(Cookie cookie :request.getCookies()){
                System.out.println(cookie.getName()+": "+cookie.getValue());
            }
        }

        System.out.println("[content ?????? ??????]");
        System.out.println("request.getContentType() = "+request.getContentType());
        System.out.println("request.getContentLength() = "+request.getContentLength());
        System.out.println("request.getCharacterEncoding() = "+request.getCharacterEncoding());


    }
}

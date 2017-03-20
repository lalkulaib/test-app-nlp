package wasdev.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifiers;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print("Test!");
        
        NaturalLanguageClassifier service = new NaturalLanguageClassifier();
        service.setUsernameAndPassword("f24bfe3a-e831-41b3-beec-9b11ba14c421","oBFD4XzAhwa2");
        
        Classifiers classifiers = service.getClassifiers().execute();
        response.getWriter().print(classifiers);
        
        Classifier classifier = service.getClassifier("90e7b7x198-nlc-3089").execute();
        response.getWriter().print(classifier.getStatus());
  
        System.out.println(classifier);
        
        Classification classification = service.classify("90e7b7x198-nlc-3089",
        		  "إن ثورة ٣٠ يونيو ليست ببعيدة، ولن تكون أبدا بعيدة.. وستظل حية نابضة بجهد وإصرار عشرات الملايين الذين فجروها").execute();
        		System.out.println(classification);
        
    }

}

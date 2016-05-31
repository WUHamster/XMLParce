package Home2_1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by WUHamster on 31.05.2016.
 */
public class Loader {

    public void loadNewTrain(String path) {
        try {
            File xmlTrains = new File(path);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlTrains);
            Element root = document.getDocumentElement();

            Element train = document.createElement("train");
            root.appendChild(train);
            Element from = document.createElement("from");
            from.setTextContent(ConsoleHelper.askFrom());
            train.appendChild(from);
            Element to = document.createElement("to");
            to.setTextContent(ConsoleHelper.askTo());
            train.appendChild(to);
            Element date = document.createElement("date");
            date.setTextContent(ConsoleHelper.askDate());
            train.appendChild(date);
            Element departure = document.createElement("departure");
            departure.setTextContent(ConsoleHelper.askTime());
            train.appendChild(departure);


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("2.xml"));

            transformer.transform(source, result);

        }
        catch (Exception e) {

        }
    }
}

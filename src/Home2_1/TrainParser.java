package Home2_1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by WUHamster on 31.05.2016.
 * Есть список поездов, представленный с виде XML. Вывести на экран информацию о тех поездах, которые отправляются сегодня с 15:00 до 19:00.
 */
public class TrainParser {

    public void parseTrain(String path) {

        try {
            File xmlTrains = new File(path);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlTrains);
            Element root = document.getDocumentElement();
            NodeList trains = root.getChildNodes();
            for (int i = 0; i < trains.getLength(); i++) {
                Node node = trains.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element train = (Element) node;
                    String date = train.getElementsByTagName("date").item(0).getChildNodes().item(0).getNodeValue();
                    String departure = train.getElementsByTagName("departure").item(0).getChildNodes().item(0).getNodeValue();
                    int departreHour = Integer.parseInt(departure.substring(0,2));
                    String from = train.getElementsByTagName("from").item(0).getChildNodes().item(0).getNodeValue();
                    String to = train.getElementsByTagName("to").item(0).getChildNodes().item(0).getNodeValue();
                    if (date.equals("31.05.2016") && (departreHour>14 && departreHour<19)) {
                        System.out.println("The train from " + from + " to " + to + " departures at " +departure + ". Have a nice trip!");
                    }
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}

package loader.xml.impl;

import loader.xml.XmlLoader;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.car.CarData;
import model.carbody.CarBody;
import model.engine.Engine;
import model.enums.CarBodyType;
import model.enums.Color;
import model.enums.EngineType;
import model.enums.TyreType;
import model.wheel.Wheel;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode
public class CarsXmlLoaderImpl implements XmlLoader<Set<CarData>> {

    @Override
    public Set<CarData> load(String path) {

        try {
            var result = new HashSet<CarData>();

            var dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            var db = dbf.newDocumentBuilder();
            var doc = db.parse(new File(path));

            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("car");

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element
                            .getElementsByTagName("id")
                            .item(0)
                            .getTextContent();
                    String carModel = element
                            .getElementsByTagName("carModel")
                            .item(0)
                            .getTextContent();
                    String carPrice = element
                            .getElementsByTagName("carPrice")
                            .item(0)
                            .getTextContent();
                    String carMileage = element
                            .getElementsByTagName("carMileage")
                            .item(0)
                            .getTextContent();
                    var engineNode = element
                            .getElementsByTagName("carEngine")
                            .item(0)
                            .getChildNodes();
                    String engineType = engineNode
                            .item(0)
                            .getTextContent();
                    String enginePower = engineNode
                            .item(1)
                            .getTextContent();
                    var carBodyNode = element
                            .getElementsByTagName("carBody")
                            .item(0)
                            .getChildNodes();
                    String color = carBodyNode
                            .item(0)
                            .getTextContent();
                    String carBodyType = carBodyNode
                            .item(1)
                            .getTextContent();
                    var componentsNode = carBodyNode
                            .item(2)
                            .getChildNodes();
                    List<String> components = new ArrayList<>();
                    for (int i = 0; i < componentsNode.getLength(); i++) {
                        components.add(componentsNode.item(i).getTextContent());
                    }
                    var carWheelNode = element
                            .getElementsByTagName("carWheel")
                            .item(0)
                            .getChildNodes();
                    String wheelModel = carWheelNode
                            .item(0)
                            .getTextContent();
                    String wheelSize = carWheelNode
                            .item(1)
                            .getTextContent();
                    String tyreType = carWheelNode
                            .item(2)
                            .getTextContent();

                    result.add(
                            CarData
                                    .builder()
                                    .id(Long.parseLong(id))
                                    .carModel(carModel)
                                    .carPrice(new BigDecimal(carPrice))
                                    .carMileage(Integer.parseInt(carMileage))
                                    .carEngine(
                                            Engine
                                                    .builder()
                                                    .engineType(EngineType.valueOf(engineType))
                                                    .enginePower(Integer.parseInt(enginePower))
                                                    .build()
                                    )
                                    .carBody(
                                            CarBody
                                                    .builder()
                                                    .color(Color.valueOf(color))
                                                    .carBodyType(CarBodyType.valueOf(carBodyType))
                                                    .components(components)
                                                    .build()
                                    )
                                    .carWheel(
                                            Wheel
                                                    .builder()
                                                    .wheelModel(wheelModel)
                                                    .wheelSize(Integer.parseInt(wheelModel))
                                                    .tyreType(TyreType.valueOf(tyreType))
                                                    .build()
                                    )
                                    .build()
                    );
                }
            }
            return result;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }


}

package com.example.parsing;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    TextView text;
    String data;
    // 20180517 이렇게 오늘의 년도날짜 받아오는 것

    SimpleDateFormat formatter

            = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);

    Date date = new Date();

    String weather_date = formatter.format(date);

    // 위도/경도 서울시 강남구 고정, 시간 오후 2시로 고정

    String weather_url = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey=KS7TJNLpaDVjIhEMu9f4RUIPTTUbCOIu6YYJ7Xyy1noK4hR1Fn3YizRAydRpY%2FaAnQfiyz8b4YKoLCo64ivYFw%3D%3D" + "&base_date=" + weather_date + "&base_time=1400&nx=61&ny=126&numOfRows=10&_type=xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);

        //new GetXMLTask().execute();

        class GetXMLTask extends AsyncTask<String, Void, Document> {

            @Override

            protected Document doInBackground(String... urls) {

                URL url;

                Document doc = null;

                try {

                    url = new URL(weather_url);

                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                    DocumentBuilder db = dbf.newDocumentBuilder();

                    doc = db.parse(new InputSource(url.openStream()));

                    doc.getDocumentElement().normalize();


                } catch (Exception e) {

                    Toast.makeText(getBaseContext(), "Parsing Error", Toast.LENGTH_SHORT).show();

                }

                return doc;

            }


            @Override

            protected void onPostExecute(Document doc) {


                String s = "";

                NodeList nodeList = doc.getElementsByTagName("item");


                for (int i = 0; i < nodeList.getLength(); i++) {


                    Node node = nodeList.item(i);

                    Element fstElmnt = (Element) node;


                    NodeList idx = fstElmnt.getElementsByTagName("category");

                    // 모든 category 값들을 출력 위한

                    // s += "category = "+  idx.item(0).getChildNodes().item(0).getNodeValue() +"\n";


                    // 강수확률 PDP, fcstValue 강수확률에 해당하는 값

                    if (idx.item(0).getChildNodes().item(0).getNodeValue().equals("POP")) {

                        NodeList gugun = fstElmnt.getElementsByTagName("fcstValue");

                        s += "fcstValue 강수확률 = " + gugun.item(0).getChildNodes().item(0).getNodeValue() + "% \n";

                    }


                    // 습도 REH, fcstValue 습도에 해당하는 값

                    if (idx.item(0).getChildNodes().item(0).getNodeValue().equals("REH")) {

                        NodeList gugun = fstElmnt.getElementsByTagName("fcstValue");

                        s += "fcstValue 습도 = " + gugun.item(0).getChildNodes().item(0).getNodeValue() + "% \n";

                    }


                    // 온도 T3H, fcstValue 온도에 해당하는 값

                    if (idx.item(0).getChildNodes().item(0).getNodeValue().equals("T3H")) {

                        NodeList gugun = fstElmnt.getElementsByTagName("fcstValue");

                        s += "fcstValue 온도 = " + gugun.item(0).getChildNodes().item(0).getNodeValue() + "'C \n";

                    }


                    // 구름상태 SKY, fcstValue 구름상태에 해당하는 값

                    // 0~2 : 맑음, 3~5 : 구름조금, 6~8 : 구름많음, 9~10 : 흐림

                    if (idx.item(0).getChildNodes().item(0).getNodeValue().equals("SKY")) {

                        NodeList gugun = fstElmnt.getElementsByTagName("fcstValue");

                        int cloud_num = Integer.parseInt(gugun.item(0).getChildNodes().item(0).getNodeValue());


                        if (cloud_num == 0 || cloud_num == 1 || cloud_num == 2) {

                            s += "fcstValue 하늘상태 = 맑음\n";

                        } else if (cloud_num == 3 || cloud_num == 4 || cloud_num == 5) {

                            s += "fcstValue 하늘상태 = 구름 조금\n";

                        } else if (cloud_num == 6 || cloud_num == 7 || cloud_num == 8) {

                            s += "fcstValue 하늘상태 = 구름 많음\n";

                        } else if (cloud_num == 9 || cloud_num == 10) {

                            s += "fcstValue 하늘상태 = 흐림\n";

                            // s += "fcstValue 하늘상태 = "+  gugun.item(0).getChildNodes().item(0).getNodeValue() +"\n";

                        }


                        // 모든 카테고리에 대한 fcstValue 값들을 출력 위한

                        // NodeList gugun = fstElmnt.getElementsByTagName("fcstValue");

                        // s += "fcstValue = "+  gugun.item(0).getChildNodes().item(0).getNodeValue() +"\n";

                    }

                    text.setText(s);

                    super.onPostExecute(doc);

                }

            }

        }

    }
}
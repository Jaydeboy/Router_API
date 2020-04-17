package com.router.ssa_Office.office_List;

import com.router.seralization.SerializationXML;
import com.router.ssa_Office.HearingOffices.Hearing_Office;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SSA_List {

    //HashMap Fast for updating
    public static  Map<Integer, Hearing_Office> hearingOfficeList = new HashMap<>();

    static {
        if (hearingOfficeList.isEmpty()) {
            try {
                if (hearingOfficeList.isEmpty()) {

                    SerializationXML.Hearing_wait_Time_XML_To_Object();
                }
            } catch (IOException | SAXException | ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
    }
    //private Map<String, Social_Security_Field_Office> fieldOfficeList = new HashMap<>();

/* will implement later
    public List<Hearing_Office> getHearingOfficeList(){
        HearingOfficeListCheck();
        return new ArrayList<Hearing_Office>(hearingOfficeList.values());
    }

    private void HearingOfficeListCheck(){

        if(hearingOfficeList.isEmpty()) {
            try {
                if (hearingOfficeList.isEmpty()) {

                    SerializationXML.Hearing_wait_Time_XML_To_Object();
                }
            } catch (IOException | SAXException | ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
    }

*/
}

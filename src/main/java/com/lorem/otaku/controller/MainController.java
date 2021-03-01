package com.lorem.otaku.controller;

import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lorem.otaku.lorem.LoremIpsum;
import com.lorem.otaku.models.ServiceResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * MainController
 */
@RestController
public class MainController {

    @GetMapping(path = "/htmlparagraph/{arg1}/{arg0}")
    public ServiceResponse getHmltParagraph(@PathVariable String arg0, @PathVariable String arg1){
        try {
            String[] numeros = arg0.split("\\+");
            int numero1 = Integer.parseInt(numeros[0]);
            int numero2 =  Integer.parseInt(numeros[1]);
            String loremType = arg1.toLowerCase();
            LoremIpsum lorem;
            if (loremType.equals("otaku")) {
                lorem = LoremIpsum.getInstance("loremOtaku.txt");
            }else if(loremType.equals("otaku")) {
                lorem = LoremIpsum.getInstance("loremChile.txt");
            }else{
                lorem = LoremIpsum.getInstance("lorem.txt");
            }
            String result = lorem.getHtmlParagraphs(numero1, numero2);
            HashMap<String,String> resultMap = new HashMap<>(); 
            resultMap.put("Data", result);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node =  mapper.convertValue(resultMap,JsonNode.class);
            lorem = null;
            return new ServiceResponse("1",node);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping(path = "/paragraph/{arg1}/{arg0}")
    public ServiceResponse getParagraph(@PathVariable String arg0, @PathVariable String arg1){
        try {
            String[] numeros = arg0.split("\\+");
            int numero1 = Integer.parseInt(numeros[0]);
            int numero2 =  Integer.parseInt(numeros[1]);
            String loremType = arg1.toLowerCase();
            LoremIpsum lorem;
            if (loremType.equals("otaku")) {
                lorem = LoremIpsum.getInstance("loremOtaku.txt");
            }else if(loremType.equals("otaku")) {
                lorem = LoremIpsum.getInstance("loremChile.txt");
            }else{
                lorem = LoremIpsum.getInstance("lorem.txt");
            }
            String result = lorem.getParagraphs(numero1, numero2);
            HashMap<String,String> resultMap = new HashMap<>(); 
            resultMap.put("Data", result);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node =  mapper.convertValue(resultMap,JsonNode.class);
            return new ServiceResponse("1",node);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping(path = "/title/{arg1}/{arg0}")
    public ServiceResponse getTitle(@PathVariable String arg0, @PathVariable String arg1){
        try {
            String[] numeros = arg0.split("\\+");
            int numero1 = Integer.parseInt(numeros[0]);
            int numero2 =  Integer.parseInt(numeros[1]);
            String loremType = arg1.toLowerCase();
            LoremIpsum lorem;
            if (loremType.equals("otaku")) {
                lorem = LoremIpsum.getInstance("loremOtaku.txt");
            }else if(loremType.equals("otaku")) {
                lorem = LoremIpsum.getInstance("loremChile.txt");
            }else{
                lorem = LoremIpsum.getInstance("lorem.txt");
            }
            String result = lorem.getTitle(numero1, numero2);
            HashMap<String,String> resultMap = new HashMap<>(); 
            resultMap.put("Data", result);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node =  mapper.convertValue(resultMap,JsonNode.class);
            return new ServiceResponse("1",node);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import controller.ValuesToSave;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class Exchange {

    HashMap<String,Double> exchangeRates = new HashMap<String, Double>(){
        {
          put("USDHUF", 320.4377);
          put("USDEUR", 0.884);
          put("USDGBP", 0.7377);
          put("HUFUSD", 0.0028);
          put("HUFGBP", 0.0022);
          put("HUFEUR", 0.0026);
          put("EURGBP", 0.8386);
          put("EURUSD", 1.0545);
          put("EURHUF", 378.3572);
          put("GBPHUF", 451.1558);
          put("GBPEUR", 1.1924);
          put("GBPUSD", 1.2573);

          put("USDUSD", 1.0);
          put("GBPGBP", 1.0);
          put("EUREUR", 1.0);
          put("HUFHUF", 1.0);
           }
    };

    public String CalculateCurrency(String a,String b){
        return Double.toString(Double.parseDouble(a)*(exchangeRates.get(b)));
    }

    public void SavingTheChangedValues(String a, String b, String c,String d) throws IOException {
        var objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        var changedValuesToSave = new ArrayList<ValuesToSave>();
        changedValuesToSave.add(new ValuesToSave(a,b,c,d));

        //filewriter
        try(var writer = new FileWriter("CurrencyExchangeSaveFile.txt",true)){
            objectMapper.writeValue(writer,changedValuesToSave);
            //System.out.println(changedValuesToSave);
        }
    }

    //filereader
    public String ReadingTheChangedValues() throws IOException {
        String savedTextFile = Files.readString(Path.of("CurrencyExchangeSaveFile.txt"));
        return savedTextFile;
    }

}
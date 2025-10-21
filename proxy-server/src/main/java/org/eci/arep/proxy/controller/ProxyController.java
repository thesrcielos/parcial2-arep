package org.eci.arep.proxy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping()
public class ProxyController {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String[] servicesUrl = new String[]{"http://localhost:8080"};
    private static int server = 0;

    public String httpRequestMathServiceLucasSeq(String GET_URL) throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("Response Code :: " + responseCode);
        String answer = null;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            answer = response.toString();
        } else {
            System.out.println("GET request not worked");
            answer ="GET request not worked";
        }
        System.out.println("GET DONE");
        return answer;
    }
    @GetMapping("/lucasseq")
    public ResponseEntity<?> getLucasSequence(@RequestParam long value) throws IOException {
        String url = getLucasSeqServiceUrl(value);
        return ResponseEntity.ok(httpRequestMathServiceLucasSeq(url));
    }

    private String getLucasSeqServiceUrl(long value){
        String host = servicesUrl[server];
        server = server == servicesUrl.length - 1? 0 : server + 1;
        return host + "/lucasseq?value=" + value;
    }
}

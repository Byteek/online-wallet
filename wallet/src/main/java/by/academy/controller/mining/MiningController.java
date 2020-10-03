package by.academy.controller.mining;

import by.academy.entity.AppUser;
import by.academy.service.UserService;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
@RequestMapping("/mining")
public class MiningController {

    @Autowired
    UserService userService;

    public static final Logger logger = LoggerFactory.getLogger(MiningController.class);

    @GetMapping
    public ModelAndView getMiningPage() {
        return new ModelAndView("mining");
    }

    @PostMapping
    public String runMining() throws IOException, InterruptedException {

         AppUser appUser = userService.getUserByUsername(UserService.getUsernameAuthUser());
        String appUserJson = new GsonBuilder().setPrettyPrinting().create().toJson(appUser);

        postRequestToTheMiningService(appUserJson);
        return "redirect:home";
    }


    private static HttpResponse<String>
    postRequestToTheMiningService(String body) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/runMining"))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json")
                .build();

        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}

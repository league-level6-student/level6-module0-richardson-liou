package _03_intro_to_authenticated_APIs;

import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;
import _03_intro_to_authenticated_APIs.data_transfer_objects.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class NewsApiTest {

    NewsApi newsApi;

    @BeforeEach
    void setUp() {
    	newsApi = new NewsApi();
    }

    @Test
    void itShouldGetNewsStoryByTopic() {
        //given
    	String topic = "fires";
        //when
    	ApiExampleWrapper aew = newsApi.getNewsStoryByTopic(topic);
        //then
    	assertNotNull(aew);
    }

    @Test
    void itShouldFindStory(){
        //given
    	String topic = "fires";
        //when
    	String message = newsApi.findStory(topic);
        //then
    	assertNotNull(message);
    }


}
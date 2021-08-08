package com.pi.simpleapi.controller;

import com.google.gson.Gson;
import com.pi.simpleapi.entity.Breed;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class SimpleAPIControllerTest {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Gson gson;

    @Test
    public void getAllTest(){
        String endPointToTest = "http://localhost:8080/api/breeds/list/all";
        String expected = "{\"message\":{\"affenpinscher\":[],\"african\":[],\"airedale\":[],\"akita\":[],\"appenzeller\":[],\"australian\":[\"shepherd\"],\"basenji\":[],\"beagle\":[],\"bluetick\":[],\"borzoi\":[],\"bouvier\":[],\"boxer\":[],\"brabancon\":[],\"briard\":[],\"buhund\":[\"norwegian\"],\"bulldog\":[\"boston\",\"english\",\"french\"],\"bullterrier\":[\"staffordshire\"],\"cairn\":[],\"cattledog\":[\"australian\"],\"chihuahua\":[],\"chow\":[],\"clumber\":[],\"cockapoo\":[],\"collie\":[\"border\"],\"coonhound\":[],\"corgi\":[\"cardigan\"],\"cotondetulear\":[],\"dachshund\":[],\"dalmatian\":[],\"dane\":[\"great\"],\"deerhound\":[\"scottish\"],\"dhole\":[],\"dingo\":[],\"doberman\":[],\"elkhound\":[\"norwegian\"],\"entlebucher\":[],\"eskimo\":[],\"finnish\":[\"lapphund\"],\"frise\":[\"bichon\"],\"germanshepherd\":[],\"greyhound\":[\"italian\"],\"groenendael\":[],\"havanese\":[],\"hound\":[\"afghan\",\"basset\",\"blood\",\"english\",\"ibizan\",\"plott\",\"walker\"],\"husky\":[],\"keeshond\":[],\"kelpie\":[],\"komondor\":[],\"kuvasz\":[],\"labradoodle\":[],\"labrador\":[],\"leonberg\":[],\"lhasa\":[],\"malamute\":[],\"malinois\":[],\"maltese\":[],\"mastiff\":[\"bull\",\"english\",\"tibetan\"],\"mexicanhairless\":[],\"mix\":[],\"mountain\":[\"bernese\",\"swiss\"],\"newfoundland\":[],\"otterhound\":[],\"ovcharka\":[\"caucasian\"],\"papillon\":[],\"pekinese\":[],\"pembroke\":[],\"pinscher\":[\"miniature\"],\"pitbull\":[],\"pointer\":[\"german\",\"germanlonghair\"],\"pomeranian\":[],\"poodle\":[\"miniature\",\"standard\",\"toy\"],\"pug\":[],\"puggle\":[],\"pyrenees\":[],\"redbone\":[],\"retriever\":[\"chesapeake\",\"curly\",\"flatcoated\",\"golden\"],\"ridgeback\":[\"rhodesian\"],\"rottweiler\":[],\"saluki\":[],\"samoyed\":[],\"schipperke\":[],\"schnauzer\":[\"giant\",\"miniature\"],\"setter\":[\"english\",\"gordon\",\"irish\"],\"sheepdog\":[\"english\",\"shetland\"],\"shiba\":[],\"shihtzu\":[],\"spaniel\":[\"blenheim\",\"brittany\",\"cocker\",\"irish\",\"japanese\",\"sussex\",\"welsh\"],\"springer\":[\"english\"],\"stbernard\":[],\"terrier\":[\"american\",\"australian\",\"bedlington\",\"border\",\"dandie\",\"fox\",\"irish\",\"kerryblue\",\"lakeland\",\"norfolk\",\"norwich\",\"patterdale\",\"russell\",\"scottish\",\"sealyham\",\"silky\",\"tibetan\",\"toy\",\"westhighland\",\"wheaten\",\"yorkshire\"],\"vizsla\":[],\"waterdog\":[\"spanish\"],\"weimaraner\":[],\"whippet\":[],\"wolfhound\":[\"irish\"]},\"status\":\"success\"}";
        Breed breedExpected = gson.fromJson(expected, Breed.class);
        Breed breadActual = restTemplate.getForObject(endPointToTest, Breed.class);
        Assert.isTrue(breedExpected.equals(breadActual));
    }

}

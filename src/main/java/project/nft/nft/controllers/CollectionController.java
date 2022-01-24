package project.nft.nft.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.nft.nft.models.Collection;
import project.nft.nft.services.CollectionService;

import java.io.IOException;
import java.util.List;

import static project.nft.nft.controllers.KMeans.kMeanspp;
import static project.nft.nft.controllers.KMeans.kmeans;

@RestController
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4200"}, maxAge = 6000)
@RequestMapping("/collections")
@RequiredArgsConstructor
public class CollectionController {
    @Autowired
    private final CollectionService collectionService;

    @GetMapping("/list")
    public List<Collection> getCollections(@RequestParam("limit") int limit, @RequestParam("page") int page) {
        System.out.println(limit);
        System.out.println(page);
        return (List<Collection>) this.collectionService.list(limit, page);
    }

    @GetMapping("/analysis")
    public String startAnalysis(@RequestParam("clusters") int k) {
        System.out.println(k);
        try {
            // read data
            DataSet data = new DataSet("files/sample.csv");
            System.out.println(data.getAttrNames());
            // remove (input any irrelevant attributes)
            // data.removeAttr("Class");
            // cluster
            kmeans(data, k);
            // output into a csv
            data.createCsvOutput("files/sampleClustered.csv");
        } catch (IOException e){
            e.printStackTrace();
        }

        return "KMeans finished successfully";
    }

}

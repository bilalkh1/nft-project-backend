package project.nft.nft.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.nft.nft.models.Collection;
import project.nft.nft.models.KMeansCollection;
import project.nft.nft.services.CollectionService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static project.nft.nft.controllers.KMeans.kmeans;

@RestController
@CrossOrigin(origins = {"http://localhost:4200" , "http://localhost:8100"}, maxAge = 6000)
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
    public List<Collection> startAnalysis(@RequestParam("clusters") int k) {
        // get data from mongodb
        List<Collection> collections = this.collectionService.getCollectionData();
        // push data to csvFile
        try(BufferedWriter csvWriter = new BufferedWriter(new FileWriter("files/sample.csv"))) {
            csvWriter.write("name");
            csvWriter.write(";");
            csvWriter.write("totalSupply");
            csvWriter.write(";");
            csvWriter.write("owners");
            csvWriter.write(";");
            csvWriter.write("estimatedMarketCap");
            csvWriter.write(";");
            csvWriter.write("volume_7d");
            csvWriter.write(";");
            csvWriter.write("avg_price_7d");
            csvWriter.write(";");
            csvWriter.write("sales_7d");
            csvWriter.write(";");
            csvWriter.write("sales_all_time");
            csvWriter.write(";");
            csvWriter.write("volume_all_time");
            csvWriter.write(";");
            csvWriter.write("owners_percentage");
            csvWriter.write("\n");
            for (Collection collection: collections) {
                csvWriter.write(collection.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // read data
            DataSet data = new DataSet("files/sample.csv");
            // remove (input any irrelevant attributes)
             data.removeAttr("name");
            // cluster
            kmeans(data, k);
            // output into a csv
            data.createCsvOutput("files/sampleClustered.csv");
        } catch (IOException e){
            e.printStackTrace();
        }

        return collectionService.returnCollectionFromCSV("files/sample.csv", "files/sampleClustered.csv");
    }

    @PostMapping("/store")
    public void storeKmeansData() {
        // store data in mongodb
        collectionService.storeCollectionKMeans("files/sample.csv", "files/sampleClustered.csv");
    }

    @GetMapping("/kmeans")
    public List<KMeansCollection> getKmeansData() {
        // get data from mongodb
        return collectionService.getKMeans();
    }
}

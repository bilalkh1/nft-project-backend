package project.nft.nft.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nft.nft.models.Collection;
import project.nft.nft.models.KMeansCollection;
import project.nft.nft.repositories.CollectionRepository;
import project.nft.nft.services.CollectionService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
@Transactional
public class CollectionServiceImplementation implements CollectionService {
    @Autowired
    private final CollectionRepository collectionRepository;

    private final MongoOperations mongoOperations;

    @Override
    public java.util.Collection<Collection> list(int limit, int page) {
        Query query = new Query();
        query.limit(limit);
        query.skip((page - 1)*limit);
        return mongoOperations.find(query, Collection.class);
//        return (java.util.Collection<Collection>) collectionRepository.findAll().stream().limit(limit);
    }

    @Override
    public List<Collection> getCollectionData() {
        return mongoOperations.findAll(Collection.class);
    }

    @Override
    public List<Collection> returnCollectionFromCSV(String fileName, String fileNameKmeans) {
        List<Collection> collections = new ArrayList<>();
        List<String> collectionNames = new ArrayList<>();
        Path pathToFile = Paths.get(fileNameKmeans);
        Path pathToFile1 = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile1,
                StandardCharsets.UTF_8)) {
            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                String[] attributes = line.split(";");
                // adding int collectionNames
                collectionNames.add(attributes[0]);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.UTF_8)) {
            // read the first line from the text file
            String line = br.readLine();
            int i = 0;
            // loop until all lines are read
            while (line != null) {
                String[] attributes = line.split(";");
                Collection collection = createCollection(attributes, collectionNames.get(i));
                // adding collection into ArrayList
                collections.add(collection);
                line = br.readLine();
                i++;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        collections.remove(0);
        return collections;
    }

    @Override
    public void storeCollectionKMeans(String fileName, String fileNameKmeans) {
        List<Collection> collections = returnCollectionFromCSV(fileName, fileNameKmeans);
        mongoOperations.insert(collections, KMeansCollection.class);
    }

    public static Collection createCollection(String[] metadata, String name) {
        // extract variables from metadata
        String totalSupply = metadata[0];
        String owners = metadata[1];
        String estimatedMarketCap = metadata[2];
        String volume_7d = metadata[3];
        String avg_price_7d = metadata[4];
        String sales_7d = metadata[5];
        String sales_all_time = metadata[6];
        String volume_all_time = metadata[7];
        String owners_percentage = metadata[8];
        String number = metadata[9];

        // create and return collection
        return new Collection(null, number, name, totalSupply, owners, estimatedMarketCap, null, null, null, null, null, null, null, null, volume_7d, avg_price_7d, sales_7d, sales_all_time, volume_all_time, owners_percentage);
    }
}

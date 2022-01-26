package project.nft.nft.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.nft.nft.models.TopCollections;

public interface TopCollectionRepository extends MongoRepository<TopCollections, String> {
}

package project.nft.nft.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.nft.nft.models.Collection;
import project.nft.nft.models.RecentCollection;

@Repository
public interface RecentCollectionRepository extends MongoRepository<RecentCollection, String> {
}

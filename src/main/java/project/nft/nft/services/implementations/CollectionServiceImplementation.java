package project.nft.nft.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nft.nft.models.Collection;
import project.nft.nft.repositories.CollectionRepository;
import project.nft.nft.services.CollectionService;

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
}

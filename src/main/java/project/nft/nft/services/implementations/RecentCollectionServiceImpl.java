package project.nft.nft.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nft.nft.models.RecentCollection;
import project.nft.nft.repositories.RecentCollectionRepository;
import project.nft.nft.services.RecentCollectionService;

@RequiredArgsConstructor
@Service
@Transactional
public class RecentCollectionServiceImpl implements RecentCollectionService {

    @Autowired
    private final RecentCollectionRepository recentCollectionRepository;

    private final MongoOperations mongoOperations;

    @Override
    public java.util.List<RecentCollection> list() {
        return this.recentCollectionRepository.findAll();
    }
}
